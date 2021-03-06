package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import pl.put.poznan.buildinginfo.model.Building;
import pl.put.poznan.buildinginfo.model.Floor;
import pl.put.poznan.buildinginfo.model.LocalizationType;
import pl.put.poznan.buildinginfo.model.Room;

import java.util.Optional;

@Component("localizationFinder")
public class LocalizationFinder {

    private static final Logger logger = LoggerFactory.getLogger(LocalizationFinder.class);

    public Localization findLocalizationInBuilding(Building building, LocalizationType type, String id) {

        switch (type) {

            case BUILDING:

                if (!building.getId().equals(id)) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "Building's ID is different than provided ID in the query param: " + id);
                }
                logger.debug("Found building with ID: " + id);
                return building;

            case FLOOR:
                Optional<Floor> floorOptional = building.getFloors().stream()
                        .filter(floor -> floor.getId().equals(id)).findFirst();

                if (floorOptional.isEmpty()) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "Provided Building does not contain " + type + " with id: " + id);
                }

                logger.debug("Found floor with ID: " + id);
                return floorOptional.get();

            case ROOM:
                Optional<Room> roomOptional = building.getFloors().stream()
                        .flatMap(x -> x.getRooms().stream())
                        .filter(room -> room.getId().equals(id))
                        .findFirst();

                if (roomOptional.isEmpty()) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "Provided Building does not contain " + type + " with id: " + id);
                }
                logger.debug("Found room with ID: " + id);
                return roomOptional.get();

        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Not supported Localization Type");
    }

}
