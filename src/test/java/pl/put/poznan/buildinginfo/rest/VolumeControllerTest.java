package pl.put.poznan.buildinginfo.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import pl.put.poznan.buildinginfo.logic.VolumeService;
import pl.put.poznan.buildinginfo.model.Building;
import pl.put.poznan.buildinginfo.model.LocalizationType;
import pl.put.poznan.buildinginfo.model.VolumeInformation;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
class VolumeControllerTest {

    @InjectMocks
    @Resource
    VolumeController cut;

    @Mock
    VolumeService volumeService;

    private static final String id = "2";


    @BeforeEach
    public void setUp() {
        cut = new VolumeController();

        //mock
        MockitoAnnotations.initMocks(this);

        VolumeInformation mockedVolumeInformation = new VolumeInformation();

        Mockito.when(volumeService.calculateVolume(Mockito.any(), Mockito.eq("2"),
                Mockito.eq(LocalizationType.BUILDING)))
                .thenReturn(mockedVolumeInformation);
    }

    @Test
    void testIfTheMethodIsCalledWithProperArguments() {
        Building building = new Building();

        //when
        cut.getVolume(building, id, LocalizationType.BUILDING);

        //then
        Mockito.verify(volumeService).calculateVolume(building, id, LocalizationType.BUILDING);
    }
}