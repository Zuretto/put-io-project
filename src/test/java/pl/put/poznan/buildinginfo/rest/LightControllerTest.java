package pl.put.poznan.buildinginfo.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;
import pl.put.poznan.buildinginfo.logic.LightService;
import pl.put.poznan.buildinginfo.logic.LocalizationFinder;
import pl.put.poznan.buildinginfo.model.Building;
import pl.put.poznan.buildinginfo.model.LightInformation;
import pl.put.poznan.buildinginfo.model.LocalizationType;

import javax.annotation.Resource;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LightControllerTest {

    @InjectMocks
    @Resource
    LightController cut;

    private static final BigDecimal light = new BigDecimal("200");
    private static final String id = "2";


    @BeforeEach
    public void setUp() {
        cut = new LightController();
    }

    @Test
    void testIfTheMethodIsCalledWithProperArguments() throws NoSuchFieldException {
        //mock
        Building building = new Building();
        LightInformation mockedLightInformation = new LightInformation();

        LightService lightService = Mockito.mock(LightService.class);
        Mockito.when(lightService.calculateLight(Mockito.eq(building), Mockito.eq("2"),
                Mockito.eq(LocalizationType.BUILDING)))
                .thenReturn(mockedLightInformation);

        FieldSetter.setField(cut, cut.getClass().getDeclaredField("helper"), lightService);

        //when
        LightInformation actual = cut.getPower(building, id, LocalizationType.BUILDING);

        //then
        Mockito.verify(lightService).calculateLight(building, id, LocalizationType.BUILDING);
    }
}