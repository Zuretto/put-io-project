package pl.put.poznan.buildinginfo.logic;

import java.math.BigDecimal;

/**
 * Interface which is a Component in Composite project pattern
 * provides method signatures for calculating properties of a localization
 */
public interface Localization {

    /**
     * method responsible for calculating surface of the localization
     *
     * @return Integer calculated surface
     */
    Integer calculateSurface();

    /**
     * method responsible for calculating volume of the localization
     *
     * @return Integer calculated volume
     */
    Integer calculateVolume();

    /**
     * method responsible for calculating heating of the localization
     *
     * @return BigDecimal calculated heating
     */

    BigDecimal calculateHeating();

    /**
     * method responsible for calculating energy consumption per cube of the localization
     *
     * @return BigDecimal calculated energy consumption per volume unit
     */
    BigDecimal calculateEnergy();

    /**
     * method responsible for calculating usage of light power per m^2
     *
     * @return BigDecimal calculated usage of light power per m^2
     */
    BigDecimal calculateLight();

    /**
     * method responsible for getting name of the localization
     *
     * @return String name of the localization
     */
    String getName();

}
