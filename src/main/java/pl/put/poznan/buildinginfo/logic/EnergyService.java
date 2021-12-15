package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildinginfo.model.*;


/**
 * class responsible for calculating Energy consumption per volume unit
 */
public class EnergyService {

    private static final Logger logger = LoggerFactory.getLogger(EnergyService.class);

    private final LocalizationFinder localizationFinder = new LocalizationFinder();

    /**
     * method responsible for calculating Energy consumption of specific Building, Floor or Room based on type and id
     *
     * @param building object containing floors
     * @param id       id of localization
     * @param type     type of localization
     * @return EnergyInformation - object containing calculated Energy Consumption with id, name and type of localization
     */
    public EnergyInformation calculateEnergy(Building building, String id, LocalizationType type) {

        logger.debug("Calculating energy of the localization: " + id);

        EnergyInformation inf = new EnergyInformation();

        Localization localization = localizationFinder.findLocalizationInBuilding(building, type, id);

        inf.setName(localization.getName());
        inf.setType(type);
        inf.setId(id);
        inf.setEnergy(localization.calculateEnergy());

        return inf;
    }

}
