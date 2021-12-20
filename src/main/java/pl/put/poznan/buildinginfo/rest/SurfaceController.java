package pl.put.poznan.buildinginfo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.logic.SurfaceService;
import pl.put.poznan.buildinginfo.model.*;

/**
 * Controller class for surface REST endpoints
 */
@RestController
@RequestMapping("/rest/v1/surface")
public class SurfaceController {

    private static final Logger logger = LoggerFactory.getLogger(SurfaceController.class);
    private final SurfaceService helper = new SurfaceService();

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
}



