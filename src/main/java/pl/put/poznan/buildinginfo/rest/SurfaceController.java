package pl.put.poznan.buildinginfo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.logic.SurfaceService;
import pl.put.poznan.buildinginfo.model.*;

import java.util.List;

/**
 * Controller class for surface REST endpoints
 */
@RestController
@RequestMapping("/rest/v1/surface")
public class BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    private final SurfaceService helper = new SurfaceService();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public SurfaceInformation getSurface(@RequestBody Building building, @RequestParam(value = "id") String id,
                                         @RequestParam(value = "type") LocalizationType localizationType) {


            return helper.calculateSurface(building,id,localizationType);
    }
}



