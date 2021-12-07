package pl.put.poznan.buildinginfo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.buildinginfo.logic.Localization;

import java.util.List;

/**
 * Data Transfer Object class for building
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Building implements Localization {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("floors")
    private List<Floor> floors;

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

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", floors=" + floors +
                '}';
    }

    @Override
    public Integer calculateSurface() {
        return floors.stream()
                .map(Floor::calculateSurface)
                .reduce(0, Integer::sum);
    }

    /**
     * method responsible for calculating Volume of Building
     * @return integer value of sum of all Volume Floors
     */
    @Override
    public Integer calculateVolume() {
        return floors.stream()
                .map(Floor::calculateVolume)
                .reduce(0, Integer::sum);
    }
}
