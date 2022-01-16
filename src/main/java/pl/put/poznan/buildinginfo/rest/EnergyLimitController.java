package pl.put.poznan.buildinginfo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.logic.EnergyLimitService;
import pl.put.poznan.buildinginfo.model.*;

import java.math.BigDecimal;

/**
 * Controller class for surface REST endpoints
 */
@RestController
@RequestMapping("/rest/v1/energyLimit")
@Component
public class EnergyLimitController {

    private static final Logger logger = LoggerFactory.getLogger(EnergyLimitController.class);

    private EnergyLimitService helper;

    /**
     * Rest method responsible for calculating surface area
     *
     * @param building         json object provided in request body
     * @param id               rest of localization provided in request body
     * @param localizationType type of localization provided in request body
     * @param limit            limit of energy consumption
     * @return object containing information of energy consumption per volume unit
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public EnergyLimitInformation getEnergyLimit(@RequestBody Building building, @RequestParam(value = "id") String id,
                                            @RequestParam(value = "type") LocalizationType localizationType, @RequestParam(value = "limit") BigDecimal limit) {
        logger.info("Received GET request on /rest/v1/energyLimit with ID: " + id + " and type: " + localizationType);

        return helper.checkEnergyLimit(building, id, localizationType, limit);
    }

    @Autowired
    public void setHelper(EnergyLimitService energyLimitService) {
        this.helper = energyLimitService;
    }
}