package pl.put.poznan.buildinginfo.model;

import java.util.List;

/**
 * class responsible for storing information about: id, name, type and rooms exceeding energy limit
 * this class is only for returning data to client
 */
public class EnergyLimitInformation {
    String id;
    String name;
    LocalizationType type;
    List<Room> roomsOverLimit;

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

    public List<Room> getRooms() {
        return roomsOverLimit;
    }

    public void setRooms(List<Room> rooms) {
        this.roomsOverLimit = rooms;
    }

    /**
     * @return JSON file
     */
    @Override
    public String toString() {
        String result =  "EnergyLimitInformation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", rooms=[";
        for (Room r : getRooms()){
            result = result + "{" +
                    "id='" + r.getId() + '\'' +
                    ", name'" + r.getName() + '\'' +
                    ", energy=" + r.calculateEnergy() +
                    '}';
        }
        if (!roomsOverLimit.isEmpty()) {result = result.substring(0, result.length() -1);}
        return result + "]}";
    }
}