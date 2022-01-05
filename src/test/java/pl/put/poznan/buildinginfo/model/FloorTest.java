package pl.put.poznan.buildinginfo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;


class FloorTest {

    @Test
    public void testCalculateSurface() {
        Integer expectedResult = 200;

        Floor cut = new Floor();

        Room room1 = new Room();
        room1.setArea(50);

        Room room2 = new Room();
        room2.setArea(150);

        cut.setRooms(List.of(room1, room2));

        Integer actualResult = cut.calculateSurface();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCalculateLight(){
        BigDecimal expectedResult = new BigDecimal(2);

        Floor floor = new Floor();

        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();
        room1.setLight(BigDecimal.valueOf(200));
        room1.setArea(100);
        room2.setLight(BigDecimal.valueOf(200));
        room2.setArea(100);
        room3.setLight(BigDecimal.valueOf(200));
        room3.setArea(100);

        floor.setRooms(List.of(room1,room2,room3));
        BigDecimal actualResult = floor.calculateLight();

        Assertions.assertEquals(0, actualResult.compareTo(expectedResult));
    }

    @Test
    public void testCalculateEnergy(){
        BigDecimal expectedResult = new BigDecimal(2);

        Floor floor = new Floor();
        Room room1 = new Room();
        Room room2 = new Room();

        room1.setHeating(BigDecimal.valueOf(24));
        room1.setCube(15);
        room2.setHeating(BigDecimal.valueOf(46));
        room2.setCube(20);

        floor.setRooms(List.of(room1,room2));

        BigDecimal actualResult = floor.calculateEnergy();

        Assertions.assertEquals(0, actualResult.compareTo(expectedResult));
    }

    @Test
    public void testCalculateHeight(){
        BigDecimal expectedResult = new BigDecimal(12);

        Floor floor = new Floor();
        Room room1 = new Room();
        Room room2 = new Room();

        floor.setHeightOfCeiling(BigDecimal.valueOf(1));
        room1.setHeight(BigDecimal.valueOf(11));
        room2.setHeight(BigDecimal.valueOf(8));

        floor.setRooms(List.of(room1,room2));

        BigDecimal actualResult = floor.calculateHeight();

        Assertions.assertEquals(0, actualResult.compareTo(expectedResult));
    }

    @Test
    public void testCalculateVolume() {
        Integer expectedResult = 777;

        Floor floor = new Floor();

        Room room1 = new Room();
        room1.setCube(444);

        Room room2 = new Room();
        room2.setCube(333);

        floor.setRooms(List.of(room1, room2));

        Integer actualResult = floor.calculateVolume();
        Assertions.assertEquals(expectedResult, actualResult);
    }
}