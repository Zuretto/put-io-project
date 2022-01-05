package pl.put.poznan.buildinginfo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    public void testCalculateSurface(){
        Integer expectedResult = 69;

        Room room1 = new Room();
        room1.setArea(69);

        Integer actualResult = room1.calculateSurface();

        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testCalculateLight(){
        BigDecimal expectedResult = BigDecimal.valueOf(15);

        Room room1 = new Room();
        room1.setLight(BigDecimal.valueOf(225));
        room1.setArea(15);

        BigDecimal actualResult = room1.calculateLight();

        assertEquals(0, expectedResult.compareTo(actualResult));

    }

    @Test
    public void testCalculateHeight(){
        BigDecimal expectedResult = BigDecimal.valueOf(8);

        Room room1 = new Room();
        room1.setHeight(BigDecimal.valueOf(8));

        BigDecimal actualResult = room1.calculateHeight();

        assertEquals(0, expectedResult.compareTo(actualResult));

    }

    @Test
    public void testCalculateVolume(){
        Integer expectedResult = 300;

        Room room1 = new Room();
        room1.setCube(300);

        Integer actualResult = room1.calculateVolume();

        Assertions.assertEquals(expectedResult,actualResult);
    }
}