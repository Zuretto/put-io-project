package pl.put.poznan.buildinginfo.model;

public class SurfaceInformation {
    String id;
    String name;
    LocalizationType type;
    Integer surface;

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

    public Integer getSurface() {
        return surface;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "SurfaceInformation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", surface=" + surface +
                '}';
    }
}
