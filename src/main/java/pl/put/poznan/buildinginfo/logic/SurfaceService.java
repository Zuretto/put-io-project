package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildinginfo.model.*;

import java.util.List;

public class SurfaceService {

    private static final Logger logger = LoggerFactory.getLogger(SurfaceService.class);

    public SurfaceInformation calculateSurface(Building building, String id, LocalizationType type) {
        SurfaceInformation inf = new SurfaceInformation();
        int surface_area = 0;
        inf.setType(type);
        if (type == LocalizationType.BUILDING) {
            logger.debug("Calculating surface of the building " + id);
            inf.setName(building.getName());
            inf.setId(id);
            List<Floor> floors = building.getFloors();
            for (Floor floor : floors) {
                for (Room room : floor.getRooms()) {
                    surface_area += room.getArea();
                }
            }
        } else if (type == LocalizationType.FLOOR) {
            logger.debug("Calculating surface of the floor " + id);
            List<Floor> floors = building.getFloors();
            for (Floor floor : floors) {
                if (floor.getId().equals(id)) {
                    inf.setName(floor.getName());
                    inf.setId(id);
                    for (Room room : floor.getRooms()) {
                        surface_area += room.getArea();
                    }
                }
            }
        } else if (type == LocalizationType.ROOM) {
            logger.debug("calculating surface of the room " + id);
            List<Floor> floors = building.getFloors();
            for (Floor floor : floors) {
                for (Room room : floor.getRooms()) {
                    if (room.getId().equals(id)) {
                        inf.setName(room.getName());
                        inf.setId(id);
                        surface_area += room.getArea();
                    }
                }
            }
        }
        inf.setSurface(surface_area);
        return inf;
    }

}
