package pl.put.poznan.buildinginfo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {

    @Test
    public void testCalculateSurface(){
        Integer expectedResult = 340;

        Building building = new Building();
        Floor floor1 = new Floor();
        Floor floor2 = new Floor();

        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();
        Room room4 = new Room();
        Room room5 = new Room();

        room1.setArea(100);
        room2.setArea(50);
        room3.setArea(75);
        room4.setArea(60);
        room5.setArea(55);

        floor1.setRooms(List.of(room1,room2));
        floor2.setRooms(List.of(room3,room4,room5));
        building.setFloors(List.of(floor1,floor2));

        Integer actualResult = building.calculateSurface();
        Assertions.assertEquals(actualResult,expectedResult);
    }
}