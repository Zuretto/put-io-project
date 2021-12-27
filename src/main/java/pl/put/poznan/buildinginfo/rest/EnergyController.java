package pl.put.poznan.buildinginfo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.logic.EnergyService;
import pl.put.poznan.buildinginfo.model.*;

/**
 * Controller class for surface REST endpoints
 */
@RestController
@RequestMapping("/rest/v1/energy")
public class EnergyController {

    private static final Logger logger = LoggerFactory.getLogger(EnergyController.class);
    private final EnergyService helper = new EnergyService();

    /**
     * Rest method responsible for calculating surface area
     * @param building json object provided in request body
     * @param id rest of localization provided in request body
     * @param localizationType type of localization provided in request body
     * @return object containing information of energy consumption per volume unit
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public EnergyInformation getEnergy(@RequestBody Building building, @RequestParam(value = "id") String id,
                                         @RequestParam(value = "type") LocalizationType localizationType) {
        logger.info("Received GET request on /rest/v1/energy with ID: " + id + " and type: " + localizationType );

        return helper.calculateEnergy(building,id,localizationType);
    }
}