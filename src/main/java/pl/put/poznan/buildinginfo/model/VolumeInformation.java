package pl.put.poznan.buildinginfo.model;

/**
 * class responsible for storing information about: id, name, type and volume Cube
 * this class is only for returning data to client
 */
public class VolumeInformation {
    String id;
    String name;
    LocalizationType type;
    Integer volume;

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

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     * @return JSON file
     */
    @Override
    public String toString() {
        return "VolumeInformation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", volume=" + volume +
                '}';
    }
}
