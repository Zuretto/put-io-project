package pl.put.poznan.buildinginfo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.buildinginfo.logic.SurfaceService;
import pl.put.poznan.buildinginfo.logic.VolumeService;
import pl.put.poznan.buildinginfo.model.*;

/**
 * Controller class for volume REST endpoints
 */
@RestController
@RequestMapping("/rest/v1/volume")
@Component
public class VolumeController {

    private static final Logger logger = LoggerFactory.getLogger(VolumeController.class);

    private VolumeService helper;

    /**
     * rest method responsible for calculating Volume
     *
     * @param building         json object provided in request body
     * @param id               rest of localization provided in request body
     * @param localizationType type of localization provided in request body
     * @return object containing information of cube volume
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public VolumeInformation getVolume(@RequestBody Building building, @RequestParam(value = "id") String id,
                                       @RequestParam(value = "type") LocalizationType localizationType) {
        logger.info("Received GET request on /rest/v1/volume with ID: " + id + " and type: " + localizationType);

        return helper.calculateVolume(building, id, localizationType);
    }

    @Autowired
    public void setHelper(VolumeService service) {
        this.helper = service;
    }
}
