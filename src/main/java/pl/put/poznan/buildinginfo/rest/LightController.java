package pl.put.poznan.buildinginfo.rest;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.logic.HeightService;
import pl.put.poznan.buildinginfo.logic.LightService;
import pl.put.poznan.buildinginfo.model.*;

/**
 * Controller class for power REST endpoints
 */
@RestController
@RequestMapping("/rest/v1/light")
@Component
public class LightController {

    private static final Logger logger = LoggerFactory.getLogger(LightController.class);

    private LightService helper;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public LightInformation getPower(@RequestBody Building building, @RequestParam(value = "id") String id,
                                     @RequestParam(value = "type") LocalizationType localizationType) {
        logger.info("Received GET request on /rest/v1/light with ID: " + id + " and type: " + localizationType);

        return helper.calculateLight(building, id, localizationType);
    }

    @Autowired
    public void setHelper(LightService service) {
        this.helper = service;
    }
}


