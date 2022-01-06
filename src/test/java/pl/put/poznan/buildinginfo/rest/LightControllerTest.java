package pl.put.poznan.buildinginfo.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.FieldSetter;
import org.springframework.test.context.junit4.SpringRunner;
import pl.put.poznan.buildinginfo.logic.LightService;
import pl.put.poznan.buildinginfo.model.Building;
import pl.put.poznan.buildinginfo.model.LightInformation;
import pl.put.poznan.buildinginfo.model.LocalizationType;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
class LightControllerTest {

    @InjectMocks
    @Resource
    LightController cut;

    @Mock
    LightService lightService;

    private static final BigDecimal light = new BigDecimal("200");
    private static final String id = "2";


    @BeforeEach
    public void setUp() {
        cut = new LightController();

        MockitoAnnotations.initMocks(this);

        LightInformation mockedLightInformation = new LightInformation();

        Mockito.when(lightService.calculateLight(Mockito.any(), Mockito.eq("2"),
                Mockito.eq(LocalizationType.BUILDING)))
                .thenReturn(mockedLightInformation);
    }

    @Test
    void testIfTheMethodIsCalledWithProperArguments() {
        //mock
        Building building = new Building();

        //when
        cut.getPower(building, id, LocalizationType.BUILDING);

        //then
        Mockito.verify(lightService).calculateLight(building, id, LocalizationType.BUILDING);
    }
}