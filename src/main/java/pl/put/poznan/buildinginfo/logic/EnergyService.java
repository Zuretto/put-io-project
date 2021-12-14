package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import pl.put.poznan.buildinginfo.model.*;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * class responsible for calculating Energy consumption per volume unit
 */
public class EnergyService {

    private static final Logger logger = LoggerFactory.getLogger(EnergyService.class);

    /**
     * method responsible for calculating Energy consumption of specific Building, Floor or Room based on type and id
     *
     * @param building object containing floors
     * @param id id of localization
     * @param type type of localization
     * @return  EnergyInformation - object containing calculated Energy Consumption with id, name and type of localization
     */

    public EnergyInformation calculateEnergy(Building building, String id, LocalizationType type) {
        EnergyInformation inf = new EnergyInformation();
        BigDecimal energyConsumption = BigDecimal.valueOf(0);
        inf.setType(type);

        if (type == LocalizationType.BUILDING) {
            logger.debug("Calculating energy consumption per volume unit of the building: " + id);

            if (!building.getId().equals(id)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Building's ID is different than provided ID in the query param: " + id);
            }

            energyConsumption = building.calculateEnergy();

            inf.setName(building.getName());

        } else if (type == LocalizationType.FLOOR) {
            logger.debug("Calculating energy consumption per volume unit of the floor: " + id);

            Optional<Floor> floorOptional = building.getFloors().stream()
                    .filter(floor -> floor.getId().equals(id)).findFirst();

            if (floorOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Provided Building does not contain " + type + " with id: " + id);
            }

            energyConsumption = floorOptional.get().calculateEnergy();

            inf.setName(floorOptional.get().getName());

        } else if (type == LocalizationType.ROOM) {
            logger.debug("Calculating energy consumption per volume unit of the room: " + id);

            Optional<Room> roomOptional = building.getFloors().stream()
                    .flatMap(x -> x.getRooms().stream())
                    .filter(room -> room.getId().equals(id))
                    .findFirst();

            if (roomOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Provided Building does not contain " + type + " with id: " + id);
            }

            energyConsumption = roomOptional.get().calculateEnergy();

            inf.setName(roomOptional.get().getName());
        }

        inf.setId(id);
        inf.setEnergy(energyConsumption);
        return inf;
    }
}
