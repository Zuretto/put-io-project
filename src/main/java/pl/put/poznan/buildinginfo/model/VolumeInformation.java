package pl.put.poznan.buildinginfo.model;

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
