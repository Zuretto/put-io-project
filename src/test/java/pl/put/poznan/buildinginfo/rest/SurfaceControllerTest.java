package pl.put.poznan.buildinginfo.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import pl.put.poznan.buildinginfo.logic.SurfaceService;
import pl.put.poznan.buildinginfo.model.Building;
import pl.put.poznan.buildinginfo.model.SurfaceInformation;
import pl.put.poznan.buildinginfo.model.LocalizationType;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
class SurfaceControllerTest {

    @InjectMocks
    @Resource
    SurfaceController cut;

    @Mock
    SurfaceService surfaceService;

    private static final String id = "2";


    @BeforeEach
    public void setUp() {
        cut = new SurfaceController();

        //mock
        MockitoAnnotations.initMocks(this);

        SurfaceInformation mockedSurfaceInformation = new SurfaceInformation();

        Mockito.when(surfaceService.calculateSurface(Mockito.any(), Mockito.eq("2"),
                Mockito.eq(LocalizationType.BUILDING)))
                .thenReturn(mockedSurfaceInformation);
    }

    @Test
    void testIfTheMethodIsCalledWithProperArguments() {
        Building building = new Building();

        //when
        cut.getSurface(building, id, LocalizationType.BUILDING);

        //then
        Mockito.verify(surfaceService).calculateSurface(building, id, LocalizationType.BUILDING);
    }
}