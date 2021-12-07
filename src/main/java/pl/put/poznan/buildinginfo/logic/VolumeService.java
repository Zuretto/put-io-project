package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import pl.put.poznan.buildinginfo.model.*;

import java.util.Optional;

/**
 * class responsible for calculating Volume
 */
public class VolumeService {

    private static final Logger logger = LoggerFactory.getLogger(VolumeService.class);

    /**
     * method responsible for calculating Volume of specific Building, Floor or Room based on type and id
     *
     * @param building object containing floors
     * @param id id of localization
     * @param type type of localization
     * @return  VolumeInformation - object containing calculated volume with id, name and type of localization
     */

    public VolumeInformation calculateVolume(Building building, String id, LocalizationType type) {
        VolumeInformation inf = new VolumeInformation();
        int volumeCube = 0;
        inf.setType(type);

        if (type == LocalizationType.BUILDING) {
            logger.debug("Calculating volume of the building: " + id);

            if (!building.getId().equals(id)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Building's ID is different than provided ID in the query param: " + id);
            }

            volumeCube = building.calculateVolume();

            inf.setName(building.getName());

        } else if (type == LocalizationType.FLOOR) {
            logger.debug("Calculating volume of the cube: " + id);

            Optional<Floor> floorOptional = building.getFloors().stream()
                    .filter(floor -> floor.getId().equals(id)).findFirst();

            if (floorOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Provided Building does not contain " + type + " with id: " + id);
            }

            volumeCube = floorOptional.get().calculateVolume();

            inf.setName(floorOptional.get().getName());

        } else if (type == LocalizationType.ROOM) {
            logger.debug("calculating volume of the room: " + id);

            Optional<Room> roomOptional = building.getFloors().stream()
                    .flatMap(x -> x.getRooms().stream())
                    .filter(room -> room.getId().equals(id))
                    .findFirst();

            if (roomOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Provided Building does not contain " + type + " with id: " + id);
            }

            volumeCube = roomOptional.get().calculateVolume();

            inf.setName(roomOptional.get().getName());
        }

        inf.setId(id);
        inf.setVolume(volumeCube);
        return inf;
    }
}
