package location.model;

public class LocationModel {

    private String country;

    private String city;

    private String name;

    private LatitudeAndLongitude latitudeAndLongitude;

    private String type;

    private String icao;

    private String timeZone;

    private String iata;

    private String dst;

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

    public LatitudeAndLongitude getLatitudeAndLongitude() {
        return latitudeAndLongitude;
    }

    public LocationModel setLatitudeAndLongitude(LatitudeAndLongitude latitudeAndLongitude) {
        this.latitudeAndLongitude = latitudeAndLongitude;
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

    public String getTimeZone() {
        return timeZone;
    }

    public LocationModel setTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public String getIata() {
        return iata;
    }

    public LocationModel setIata(String iata) {
        this.iata = iata;
        return this;
    }

    public String getDst() {
        return dst;
    }

    public LocationModel setDst(String dst) {
        this.dst = dst;
        return this;
    }
}
