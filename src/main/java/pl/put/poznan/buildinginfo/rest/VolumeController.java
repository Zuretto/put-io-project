package pl.put.poznan.buildinginfo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.logic.VolumeService;
import pl.put.poznan.buildinginfo.model.*;

/**
 * Controller class for volume REST endpoints
 */
@RestController
@RequestMapping("/rest/v1/surface")
public class VolumeController {

    private static final Logger logger = LoggerFactory.getLogger(SurfaceController.class);
    private final VolumeService helper = new VolumeService();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public VolumeInformation getVolume(@RequestBody Building building, @RequestParam(value = "id") String id,
                                         @RequestParam(value = "type") LocalizationType localizationType) {


        return helper.calculateVolume(building,id,localizationType);
    }
}
