package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import pl.put.poznan.buildinginfo.model.*;

import java.math.BigDecimal;
import java.util.Optional;

public class LightService {
    private static final Logger logger = LoggerFactory.getLogger(SurfaceService.class);

    /**
     * method responsible for calculating light value per m^2 of Building, Floor or Room based on type and id
     *
     * @param building object containing floors
     * @param id       id of localization
     * @param type     type of localization
     * @return usage of light power of a building, floor or a room
     */
    public LightInformation calculateLight(Building building, String id, LocalizationType type) {
        LightInformation inf = new LightInformation();
        BigDecimal lightPower = BigDecimal.valueOf(0);
        inf.setType(type);
        if (type == LocalizationType.BUILDING) {
            logger.debug("Calculating usage of light power of the building: " + id);
            if (!building.getId().equals(id)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Building's ID is different than provided ID in the query param: " + id);
            }
            lightPower = building.calculateLight();
            inf.setName(building.getName());

        } else if (type == LocalizationType.FLOOR) {
            logger.debug("Calculating usage of light power of the floor: " + id);
            Optional<Floor> floorOptional = building.getFloors().stream()
                    .filter(floor -> floor.getId().equals(id)).findFirst();

            if (floorOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Provided Building does not contain " + type + " with id: " + id);
            }
            lightPower = floorOptional.get().calculateLight();
            inf.setName(floorOptional.get().getName());

        } else if (type == LocalizationType.ROOM) {
            logger.debug("Calculating usage of light power of the room: " + id);
            Optional<Room> roomOptional = building.getFloors().stream()
                    .flatMap(x -> x.getRooms().stream())
                    .filter(room -> room.getId().equals(id))
                    .findFirst();

            if (roomOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Provided Building does not contain " + type + " with id: " + id);
            }
            lightPower = roomOptional.get().calculateLight();
            inf.setName(roomOptional.get().getName());
        }
        inf.setId(id);
        inf.setLight(lightPower);
        return inf;
    }
}
