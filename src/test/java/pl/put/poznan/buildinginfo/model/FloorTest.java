package pl.put.poznan.buildinginfo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}