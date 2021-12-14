package pl.put.poznan.buildinginfo.model;


import java.math.BigDecimal;

/**
 * Class responsible for storing information about: id, name, type and power
 * This class is responsible for returning information to client
 */
public class LightInformation {
    String id;
    String name;
    LocalizationType type;
    BigDecimal light;

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

    public BigDecimal getLight() {
        return light;
    }
    public void setLight(BigDecimal light) {
        this.light = light;
    }

    /**
     * @return JSON file
     */
    @Override
    public String toString() {
        return "PowerInformation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ",type=" + type +
                ", power=" + light + '}';
    }
}

