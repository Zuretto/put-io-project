package pl.put.poznan.buildinginfo.rest;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.logic.LightService;
import pl.put.poznan.buildinginfo.model.*;

/**
 * Controller class for power REST endpoints
 */
@RestController
@RequestMapping("/rest/v1/light")
public class LightController {

    private static final Logger logger = LoggerFactory.getLogger(LightController.class);
    private final LightService helper = new LightService();


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public LightInformation getPower(@RequestBody Building building, @RequestParam(value = "id") String id,
                                     @RequestParam(value = "type") LocalizationType localizationType) {

        return helper.calculateLight(building, id, localizationType);
    }

}


