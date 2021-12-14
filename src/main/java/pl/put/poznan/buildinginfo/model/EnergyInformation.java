package pl.put.poznan.buildinginfo.model;

import java.math.BigDecimal;

/**
 * class responsible for storing information about: id, name, type and energy per volume unit
 * this class is only for returning data to client
 */
public class EnergyInformation {
    String id;
    String name;
    LocalizationType type;
    BigDecimal energy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalizationType getType() {
        return type;
    }

    public void setType(LocalizationType type) {
        this.type = type;
    }

    public BigDecimal getEnergy() {
        return energy;
    }

    public void setEnergy(BigDecimal energy) {
        this.energy = energy;
    }

    /**
     * @return JSON file
     */
    @Override
    public String toString() {
        return "EnergyInformation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", energy=" + energy +
                '}';
    }
}
