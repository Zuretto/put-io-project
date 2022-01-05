package pl.put.poznan.buildinginfo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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

    @Test
    public void testCalculateHeight() {
        BigDecimal expectedResult = new BigDecimal(31);
        Building building = new Building();
        building.setAboveSurface(BigDecimal.valueOf(6));

        Floor floor1 = new Floor();
        Room room101 = new Room();
        Room room102 = new Room();
        floor1.setHeightOfCeiling(BigDecimal.valueOf(1));
        room101.setHeight(BigDecimal.valueOf(11));
        room102.setHeight(BigDecimal.valueOf(8));
        floor1.setRooms(List.of(room101,room102));

        Floor floor2 = new Floor();
        Room room201 = new Room();
        Room room202 = new Room();
        floor2.setHeightOfCeiling(BigDecimal.valueOf(3));
        room201.setHeight(BigDecimal.valueOf(9));
        room202.setHeight(BigDecimal.valueOf(10));
        floor2.setRooms(List.of(room201,room202));
        building.setFloors(List.of(floor1,floor2));

        BigDecimal actualResult = building.calculateHeight();

        assertEquals(0, actualResult.compareTo(expectedResult));
    }

    @Test
    public void testCalculateVolume(){
        Integer expectedResult = 1410;

        Building building = new Building();
        Floor floor1 = new Floor();
        Floor floor2 = new Floor();

        Room room101 = new Room();
        Room room102 = new Room();
        Room room201 = new Room();
        Room room202 = new Room();


        room101.setCube(777);
        room102.setCube(410);
        room201.setCube(222);
        room202.setCube(1);

        floor1.setRooms(List.of(room101,room102));
        floor2.setRooms(List.of(room201,room202));
        building.setFloors(List.of(floor1,floor2));

        Integer actualResult = building.calculateVolume();
        Assertions.assertEquals(actualResult,expectedResult);
    }
}