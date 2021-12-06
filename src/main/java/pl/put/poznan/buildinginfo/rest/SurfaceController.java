package pl.put.poznan.buildinginfo.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.model.Building;
import pl.put.poznan.buildinginfo.model.LocalizationType;

/**
 * Controller class for surface REST endpoints
 */
@RestController
@RequestMapping("/rest/v1/surface")
public class BuildingInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getSurface(@RequestBody Building building, @RequestParam(value="id") String id,
                      @RequestParam(value= "type") LocalizationType localizationType) {

        // log the parameters
     //   logger.debug(String.valueOf(building));

        // perform the transformation, you should run your logic here, below is just a silly example
        return "OK1";
    }

}


