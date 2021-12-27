package pl.put.poznan.buildinginfo.model;

import java.math.BigDecimal;

/**
 * Class responsible for storing information about: id, name, type and height
 * This class is responsible for returning information to client
 */
public class HeightInformation {
    String id;
    String name;
    LocalizationType type;
    BigDecimal height;

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

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    /**
     * @return JSON file
     */
    @Override
    public String toString() {
        return "PowerInformation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", height=" + height + '}';
    }
}
