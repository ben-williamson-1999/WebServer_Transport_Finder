package location.model;

public class LocationModel {

    private String country;

    private String city;

    private String name;

    private Location location;

    private String type;

    private String icao;

    public String getCountry() {
        return country;
    }

    public LocationModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public LocationModel setCity(String city) {
        this.city = city;
        return this;
    }

    public String getName() {
        return name;
    }

    public LocationModel setName(String name) {
        this.name = name;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public LocationModel setLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getType() {
        return type;
    }

    public LocationModel setType(String type) {
        this.type = type;
        return this;
    }

    public String getIcao() {
        return icao;
    }

    public LocationModel setIcao(String icao) {
        this.icao = icao;
        return this;
    }
}
