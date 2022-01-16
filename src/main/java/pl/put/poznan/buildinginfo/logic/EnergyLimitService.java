package pl.put.poznan.buildinginfo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.put.poznan.buildinginfo.model.*;

import java.math.BigDecimal;


/**
 * class responsible for checking if rooms are exceeding energy limit
 */
@Component
public class EnergyLimitService {

    private static final Logger logger = LoggerFactory.getLogger(EnergyLimitService.class);

    private LocalizationFinder localizationFinder;

    @Autowired
    public void setLocalizationFinder(LocalizationFinder localizationFinder) {
        this.localizationFinder = localizationFinder;
    }

    /**
     * method responsible for checking if rooms are exceeding energy limit in specific Building or Floor based on type and id
     *
     * @param building object containing floors
     * @param id       id of localization
     * @param type     type of localization
     * @return EnergyLimitInformation - object containing calculated rooms that exceed limit, id, name and type of localization
     */
    public EnergyLimitInformation checkEnergyLimit(Building building, String id, LocalizationType type, BigDecimal limit) {

        logger.debug("Calculating energy of the rooms in localization: " + id);

        EnergyLimitInformation inf = new EnergyLimitInformation();

        Localization localization = localizationFinder.findLocalizationInBuilding(building, type, id);

        inf.setName(localization.getName());
        inf.setType(type);
        inf.setId(id);
        inf.setRooms(localization.checkEnergyLimit(limit));

        return inf;
    }

}