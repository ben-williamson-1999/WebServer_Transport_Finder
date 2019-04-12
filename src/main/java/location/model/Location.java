package location.model;

public class Location {

    private double latitude;

    private double longitude;

    public Location(String lat, String lng){
        this.latitude = Double.parseDouble(lat);
        this.longitude = Double.parseDouble(lng);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
