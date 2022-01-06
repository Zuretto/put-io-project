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
import pl.put.poznan.buildinginfo.model.HeightInformation;
import pl.put.poznan.buildinginfo.model.LocalizationType;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
class HeightServiceTest {

    @InjectMocks
    @Resource
    HeightService cut;

    @Mock
    LocalizationFinder localizationFinder;

    Building building;

    private static final BigDecimal height = new BigDecimal("200");
    private static final String id = "2";


    @BeforeEach
    public void setUp() {
        cut = new HeightService();

        //mock
        MockitoAnnotations.initMocks(this);

        building = Mockito.mock(Building.class);
        Mockito.when(building.calculateHeight()).thenReturn(height);
        Mockito.when(building.getName()).thenReturn("Name");

        Mockito.when(localizationFinder
                .findLocalizationInBuilding(Mockito.any(), Mockito.eq(LocalizationType.BUILDING),
                        Mockito.eq("2")))
                .thenReturn(building);
    }

    @Test
    void getPowerShouldReturnObjectWithProperNameAndType() {
        //when
        HeightInformation actual = cut.calculateHeight(building, id, LocalizationType.BUILDING);

        //then
        Mockito.verify(building).calculateHeight();
        Mockito.verify(localizationFinder).findLocalizationInBuilding(building, LocalizationType.BUILDING, id);

        Assertions.assertEquals(actual.getName(), "Name");
        Assertions.assertEquals(actual.getId(), id);
        Assertions.assertEquals(actual.getType(), LocalizationType.BUILDING);
        Assertions.assertEquals(actual.getHeight(), height);
    }
}