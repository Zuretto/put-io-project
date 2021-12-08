package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import pl.put.poznan.buildinginfo.model.*;

import java.util.Optional;

/**
 * Class responsible for calculating surface
 */
public class SurfaceService {

    private static final Logger logger = LoggerFactory.getLogger(SurfaceService.class);

    /**
     * method responsible for calculating surface area of specific Building, Floor or Room based on type and id
     * @param building object containing floors
     * @param id id of localization
     * @param type type of localization
     * @return surface area of a building, a floor or a room
     */
    public SurfaceInformation calculateSurface(Building building, String id, LocalizationType type) {
        SurfaceInformation inf = new SurfaceInformation();
        int surfaceArea = 0;
        inf.setType(type);

        if (type == LocalizationType.BUILDING) {
            logger.debug("Calculating surface of the building: " + id);

            if (!building.getId().equals(id)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Building's ID is different than provided ID in the query param: " + id);
            }

            surfaceArea = building.calculateSurface();

            inf.setName(building.getName());

        } else if (type == LocalizationType.FLOOR) {
            logger.debug("Calculating surface of the floor: " + id);

            Optional<Floor> floorOptional = building.getFloors().stream()
                    .filter(floor -> floor.getId().equals(id)).findFirst();

            if (floorOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Provided Building does not contain " + type + " with id: " + id);
            }

            surfaceArea = floorOptional.get().calculateSurface();

            inf.setName(floorOptional.get().getName());

        } else if (type == LocalizationType.ROOM) {
            logger.debug("calculating surface of the room: " + id);

            Optional<Room> roomOptional = building.getFloors().stream()
                    .flatMap(x -> x.getRooms().stream())
                    .filter(room -> room.getId().equals(id))
                    .findFirst();

            if (roomOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Provided Building does not contain " + type + " with id: " + id);
            }

            surfaceArea = roomOptional.get().calculateSurface();

            inf.setName(roomOptional.get().getName());
        }

        inf.setId(id);
        inf.setSurface(surfaceArea);
        return inf;
    }
}
