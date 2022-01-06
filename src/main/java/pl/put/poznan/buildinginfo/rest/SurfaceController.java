package pl.put.poznan.buildinginfo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.logic.LightService;
import pl.put.poznan.buildinginfo.logic.SurfaceService;
import pl.put.poznan.buildinginfo.model.*;

/**
 * Controller class for surface REST endpoints
 */
@RestController
@RequestMapping("/rest/v1/surface")
@Component
public class SurfaceController {

    private static final Logger logger = LoggerFactory.getLogger(SurfaceController.class);

    private SurfaceService helper;

    /**
     * Rest method responsible for calculating surface area
     *
     * @param building         json object provided in request body
     * @param id               rest of localization provided in request body
     * @param localizationType type of localization provided in request body
     * @return object containing information of surface area
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public SurfaceInformation getSurface(@RequestBody Building building, @RequestParam(value = "id") String id,
                                         @RequestParam(value = "type") LocalizationType localizationType) {
        logger.info("Received GET request on /rest/v1/surface with ID: " + id + " and type: " + localizationType);

        return helper.calculateSurface(building, id, localizationType);
    }

    @Autowired
    public void setHelper(SurfaceService service) {
        this.helper = service;
    }
}



