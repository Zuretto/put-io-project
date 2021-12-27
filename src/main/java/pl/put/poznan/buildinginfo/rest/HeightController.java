package pl.put.poznan.buildinginfo.rest;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.logic.HeightService;
import pl.put.poznan.buildinginfo.model.*;

/**
 * Controller class for height REST endpoints
 */
@RestController
@RequestMapping("/rest/v1/height")
public class HeightController {

    private static final Logger logger = LoggerFactory.getLogger(HeightController.class);
    private final HeightService helper = new HeightService();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public HeightInformation getHeight(@RequestBody Building building, @RequestParam(value = "id") String id,
                                         @RequestParam(value = "type") LocalizationType localizationType) {
        logger.info("Received GET request on /rest/v1/height with ID: " + id + " and type: " + localizationType);

        return helper.calculateHeight(building, id, localizationType);
    }
}
