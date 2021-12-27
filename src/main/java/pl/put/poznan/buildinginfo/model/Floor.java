package pl.put.poznan.buildinginfo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.buildinginfo.logic.Localization;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;

/**
 * Data Transfer Object class for floor
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Floor implements Localization {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("heightOfCeiling")
    private BigDecimal heightOfCeiling;

    @JsonProperty("rooms")
    private List<Room> rooms;

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

    public BigDecimal getHeightOfCeiling() {return heightOfCeiling;}

    public void setHeightOfCeiling(BigDecimal heightOfCeiling) {this.heightOfCeiling = heightOfCeiling;}

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * @return JSON file
     */
    @Override
    public String toString() {
        return "Floor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", heightOfCeiling=" + heightOfCeiling + '\'' +
                ", rooms=" + rooms +
                '}';
    }

    /**
     * Method responsible for calculating surface of a floor in a building
     * @return surface area of a floor as an integer
     */
    @Override
    public Integer calculateSurface() {
        return rooms.stream()
                .map(Room::getArea)
                .reduce(0, Integer::sum);
    }

    /**
     * method responsible for calculating Volume of Floor
     * @return integer value of sum of all Volume Rooms
     */
    @Override
    public Integer calculateVolume() {
        return rooms.stream()
                .map(Room::getCube)
                .reduce(0, Integer::sum);
    }

    /**
     * method responsible for calculating Heating of Floor
     * @return BigDecimal value of sum of all Heating Rooms
     */
    @Override
    public BigDecimal calculateHeating() {
        return rooms.stream()
                .map(Room::getHeating)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

    /**
     * method responsible for calculating Energy Consumption of floor per cube
     * @return BigDecimal value of Energy Consumption per volume unit on the floor
     */
    @Override
    public BigDecimal calculateEnergy() {
         return this.calculateHeating().divide(BigDecimal.valueOf(this.calculateVolume()), 5, RoundingMode.HALF_UP);
    }

    /**
     * method responsible for returning light value per m^2 of a floor
     * @return BigDecimal value of light divided by surface of a floor
     */
    @Override
    public BigDecimal calculateLight(){
        BigDecimal light = (rooms.stream()
                            .map(Room::getLight)
                            .reduce(BigDecimal.valueOf(0), BigDecimal::add));
        BigDecimal surface = BigDecimal.valueOf(calculateSurface());
        return light.divide(surface, 5, RoundingMode.HALF_UP);
    }
    /**
     * method responsible for calculating Height of floor
     * @return BigDecimal value of Height
     */
    public BigDecimal calculateHeight(){
        return this.heightOfCeiling.add(rooms.stream().map(Room::getHeight).max(Comparator.naturalOrder()).get());
    }
}
