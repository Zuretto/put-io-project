package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildinginfo.model.*;

/**
 * class responsible for calculating Volume
 */
public class VolumeService {

    private static final Logger logger = LoggerFactory.getLogger(VolumeService.class);

    private final LocalizationFinder localizationFinder = new LocalizationFinder();

    /**
     * method responsible for calculating Volume of specific Building, Floor or Room based on type and id
     *
     * @param building object containing floors
     * @param id       id of localization
     * @param type     type of localization
     * @return VolumeInformation - object containing calculated volume with id, name and type of localization
     */
    public VolumeInformation calculateVolume(Building building, String id, LocalizationType type) {

        logger.debug("Calculating volume of the localization: " + id);

        VolumeInformation inf = new VolumeInformation();

        Localization localization = localizationFinder.findLocalizationInBuilding(building, type, id);

        inf.setName(localization.getName());
        inf.setType(type);
        inf.setId(id);
        inf.setVolume(localization.calculateVolume());

        return inf;
    }

}
