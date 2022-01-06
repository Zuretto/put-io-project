package pl.put.poznan.buildinginfo.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import pl.put.poznan.buildinginfo.model.Building;
import pl.put.poznan.buildinginfo.model.SurfaceInformation;
import pl.put.poznan.buildinginfo.model.LocalizationType;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
class SurfaceServiceTest {

    @InjectMocks
    @Resource
    SurfaceService cut;

    @Mock
    LocalizationFinder localizationFinder;

    Building building;

    private static final int surface = 200;
    private static final String id = "2";


    @BeforeEach
    public void setUp() {
        cut = new SurfaceService();

        //mock
        MockitoAnnotations.initMocks(this);

        building = Mockito.mock(Building.class);
        Mockito.when(building.calculateSurface()).thenReturn(surface);
        Mockito.when(building.getName()).thenReturn("Name");

        Mockito.when(localizationFinder
                .findLocalizationInBuilding(Mockito.any(), Mockito.eq(LocalizationType.BUILDING),
                        Mockito.eq("2")))
                .thenReturn(building);
    }

    @Test
    void getPowerShouldReturnObjectWithProperNameAndType() {
        //when
        SurfaceInformation actual = cut.calculateSurface(building, id, LocalizationType.BUILDING);

        //then
        Mockito.verify(building).calculateSurface();
        Mockito.verify(localizationFinder).findLocalizationInBuilding(building, LocalizationType.BUILDING, id);

        Assertions.assertEquals(actual.getName(), "Name");
        Assertions.assertEquals(actual.getId(), id);
        Assertions.assertEquals(actual.getType(), LocalizationType.BUILDING);
        Assertions.assertEquals(actual.getSurface(), surface);
    }
}