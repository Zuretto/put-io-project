package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildinginfo.model.*;

public class HeightService {

    private static final Logger logger = LoggerFactory.getLogger(HeightService.class);

    private final LocalizationFinder localizationFinder = new LocalizationFinder();
    /**
     * method responsible for calculating height of Building, Floor or Room based on type and id
     *
     * @param building object containing floors
     * @param id       id of localization
     * @param type     type of localization
     * @return height of a building, floor or a room
     */

    public HeightInformation calculateHeight(Building building, String id, LocalizationType type) {

        logger.debug("Calculating height of the localization: " + id);

        HeightInformation inf = new HeightInformation();

        Localization localization = localizationFinder.findLocalizationInBuilding(building, type, id);

        inf.setName(localization.getName());
        inf.setType(type);
        inf.setId(id);
        inf.setHeight(localization.calculateHeight());

        return inf;
    }
}
