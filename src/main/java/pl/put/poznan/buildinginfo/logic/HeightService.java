package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.put.poznan.buildinginfo.model.*;

@Component
public class HeightService {

    private static final Logger logger = LoggerFactory.getLogger(HeightService.class);

    private LocalizationFinder localizationFinder;

    @Autowired
    public void setLocalizationFinder(LocalizationFinder localizationFinder) {
        this.localizationFinder = localizationFinder;
    }
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
