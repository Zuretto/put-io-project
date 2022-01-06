package pl.put.poznan.buildinginfo.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import pl.put.poznan.buildinginfo.logic.HeightService;
import pl.put.poznan.buildinginfo.model.Building;
import pl.put.poznan.buildinginfo.model.HeightInformation;
import pl.put.poznan.buildinginfo.model.LocalizationType;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
class HeightControllerTest {

    @InjectMocks
    @Resource
    HeightController cut;

    @Mock
    HeightService heightService;

    private static final String id = "2";


    @BeforeEach
    public void setUp() {
        cut = new HeightController();

        //mock
        MockitoAnnotations.initMocks(this);

        HeightInformation mockedHeightInformation = new HeightInformation();

        Mockito.when(heightService.calculateHeight(Mockito.any(), Mockito.eq("2"),
                Mockito.eq(LocalizationType.BUILDING)))
                .thenReturn(mockedHeightInformation);
    }

    @Test
    void testIfTheMethodIsCalledWithProperArguments() {
        Building building = new Building();

        //when
        cut.getHeight(building, id, LocalizationType.BUILDING);

        //then
        Mockito.verify(heightService).calculateHeight(building, id, LocalizationType.BUILDING);
    }
}