package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildinginfo.model.*;


/**
 * Class responsible for calculating surface
 */
public class SurfaceService {

    private static final Logger logger = LoggerFactory.getLogger(SurfaceService.class);

    private final LocalizationFinder localizationFinder = new LocalizationFinder();

    /**
     * method responsible for calculating surface area of specific Building, Floor or Room based on type and id
     *
     * @param building object containing floors
     * @param id       id of localization
     * @param type     type of localization
     * @return surface area of a building, a floor or a room
     */
    public SurfaceInformation calculateSurface(Building building, String id, LocalizationType type) {

        logger.debug("Calculating surface of the localization: " + id);

        SurfaceInformation inf = new SurfaceInformation();

        Localization localization = localizationFinder.findLocalizationInBuilding(building, type, id);

        inf.setName(localization.getName());
        inf.setType(type);
        inf.setId(id);
        inf.setSurface(localization.calculateSurface());

        return inf;
    }

}
