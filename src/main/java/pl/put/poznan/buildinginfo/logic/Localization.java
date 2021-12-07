package pl.put.poznan.buildinginfo.logic;

/**
 * Interface which is a Component in Composite project pattern
 * provides method signatures for calculating properties of a localization
 */
public interface Localization {

    /**
     * method responsible for calculating surface of the localization
     * @return Integer calculated surface
     */
    Integer calculateSurface();

    /**
     * method responsible for calculating volume of the localization
     * @return Integer calculated volume
     */
    Integer calculateVolume();

}
