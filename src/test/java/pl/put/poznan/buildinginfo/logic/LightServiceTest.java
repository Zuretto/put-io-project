package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;
import pl.put.poznan.buildinginfo.model.Building;
import pl.put.poznan.buildinginfo.model.LightInformation;
import pl.put.poznan.buildinginfo.model.LocalizationType;

import javax.annotation.Resource;

import java.math.BigDecimal;


class LightServiceTest {

    @InjectMocks
    @Resource
    LightService cut;

    private static final BigDecimal light = new BigDecimal("200");
    private static final String id = "2";


    @BeforeEach
    public void setUp() {
        cut = new LightService();
    }

    @Test
    void getPowerShouldReturnObjectWithProperNameAndType() throws NoSuchFieldException {
        //mock
        Building mockedBuilding = Mockito.mock(Building.class);
        Mockito.when(mockedBuilding.calculateLight()).thenReturn(light);
        Mockito.when(mockedBuilding.getName()).thenReturn("Name");

        LocalizationFinder localizationFinder = Mockito.mock(LocalizationFinder.class);
        Mockito.when(localizationFinder
                .findLocalizationInBuilding(Mockito.any(), Mockito.eq(LocalizationType.BUILDING),
                        Mockito.eq("2")))
                .thenReturn(mockedBuilding);

        FieldSetter.setField(cut, cut.getClass().getDeclaredField("localizationFinder"), localizationFinder);

        //when
        LightInformation actual = cut.calculateLight(mockedBuilding, id, LocalizationType.BUILDING);

        //then
        Mockito.verify(mockedBuilding).calculateLight();
        Mockito.verify(localizationFinder).findLocalizationInBuilding(mockedBuilding, LocalizationType.BUILDING, id);

        Assertions.assertEquals(actual.getName(), "Name");
        Assertions.assertEquals(actual.getId(), id);
        Assertions.assertEquals(actual.getType(), LocalizationType.BUILDING);
        Assertions.assertEquals(actual.getLight(), light);
    }
}