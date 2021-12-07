package pl.put.poznan.buildinginfo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.buildinginfo.logic.Localization;

import java.math.BigDecimal;

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

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", cube=" + cube +
                ", heating=" + heating +
                ", light=" + light +
                '}';
    }

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
}
