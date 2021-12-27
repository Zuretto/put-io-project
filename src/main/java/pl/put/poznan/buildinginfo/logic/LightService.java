package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildinginfo.model.*;

public class LightService {

    private static final Logger logger = LoggerFactory.getLogger(LightService.class);

    private final LocalizationFinder localizationFinder = new LocalizationFinder();

    /**
     * method responsible for calculating light value per m^2 of Building, Floor or Room based on type and id
     *
     * @param building object containing floors
     * @param id       id of localization
     * @param type     type of localization
     * @return usage of light power of a building, floor or a room
     */
    public LightInformation calculateLight(Building building, String id, LocalizationType type) {

        logger.debug("Calculating light of the localization: " + id);

        LightInformation inf = new LightInformation();

        Localization localization = localizationFinder.findLocalizationInBuilding(building, type, id);

        inf.setName(localization.getName());
        inf.setType(type);
        inf.setId(id);
        inf.setLight(localization.calculateLight());

        return inf;
    }
}
