package pl.put.poznan.buildinginfo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

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
}
