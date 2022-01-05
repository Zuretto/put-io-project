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

        Assertions.assertTrue(actualResult.compareTo(expectedResult)==0);
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

        Assertions.assertTrue(actualResult.compareTo(expectedResult) == 0);
    }
}