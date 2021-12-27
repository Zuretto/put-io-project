package pl.put.poznan.buildinginfo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.buildinginfo.logic.Localization;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Data Transfer Object class for room
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room implements Localization {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("area")
    private Integer area;

    @JsonProperty("cube")
    private Integer cube;

    @JsonProperty("heating")
    private BigDecimal heating;

    @JsonProperty("light")
    private BigDecimal light;

    @JsonProperty("height")
    private BigDecimal height;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getCube() {
        return cube;
    }

    public void setCube(Integer cube) {
        this.cube = cube;
    }

    public BigDecimal getHeating() {
        return heating;
    }

    public void setHeating(BigDecimal heating) {
        this.heating = heating;
    }

    public BigDecimal getLight() {
        return light;
    }

    public void setLight(BigDecimal light) {
        this.light = light;
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
        return "Room{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", cube=" + cube +
                ", heating=" + heating +
                ", light=" + light +
                ", heightOfRoom=" + height +
                '}';
    }

    /**
     * method responsible for returning surface area of a room
     * @return surface area of a room
     */
    @Override
    public Integer calculateSurface() {
        return this.area;
    }

    /**
     * method responsible for returning Volume of Room
     * @return integer value of Volume
     */
    @Override
    public Integer calculateVolume() {
        return this.cube;
    }

    /**
     * method responsible for returning heating Room
     * @return BigDecimal value of Heating
     */
    @Override
    public BigDecimal calculateHeating() {
        return this.heating;
    }

    /**
     * method responsible for returning Energy consumption of Room per cube
     * @return BigDecimal value of Energy Consumption per volume unit in the room
     */
    @Override
    public BigDecimal calculateEnergy() {
        return this.heating.divide(BigDecimal.valueOf(this.cube), 5, RoundingMode.HALF_UP);
    }

    /**
     * method responsible for returning light value per m^2 of a room
     * @return BigDecimal value of light divided by surface of a room
     */
    @Override
    public BigDecimal calculateLight(){

        return this.getLight().divide(BigDecimal.valueOf(getArea()), 5, RoundingMode.HALF_UP);
    }

    /**
     * method responsible for returning Height of Room
     * @return BigDecimal value of Height
     */
    @Override
    public BigDecimal calculateHeight(){return this.height;}
}
