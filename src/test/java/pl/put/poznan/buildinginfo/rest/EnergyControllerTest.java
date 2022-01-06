package pl.put.poznan.buildinginfo.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import pl.put.poznan.buildinginfo.logic.EnergyService;
import pl.put.poznan.buildinginfo.model.Building;
import pl.put.poznan.buildinginfo.model.EnergyInformation;
import pl.put.poznan.buildinginfo.model.LocalizationType;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
class EnergyControllerTest {

    @InjectMocks
    @Resource
    EnergyController cut;

    @Mock
    EnergyService energyService;

    private static final String id = "2";


    @BeforeEach
    public void setUp() {
        cut = new EnergyController();

        //mock
        MockitoAnnotations.initMocks(this);

        EnergyInformation mockedEnergyInformation = new EnergyInformation();

        Mockito.when(energyService.calculateEnergy(Mockito.any(), Mockito.eq("2"),
                Mockito.eq(LocalizationType.BUILDING)))
                .thenReturn(mockedEnergyInformation);
    }

    @Test
    void testIfTheMethodIsCalledWithProperArguments() {
        Building building = new Building();

        //when
        cut.getEnergy(building, id, LocalizationType.BUILDING);

        //then
        Mockito.verify(energyService).calculateEnergy(building, id, LocalizationType.BUILDING);
    }
}