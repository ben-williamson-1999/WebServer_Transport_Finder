package location.model;

public class LatitudeAndLongitude {

    private double latitude;

    private double longitude;

    private double altitude;

    public LatitudeAndLongitude(String lat, String lng, String alt){
        this.latitude = Double.parseDouble(lat);
        this.longitude = Double.parseDouble(lng);
        this.altitude = Double.parseDouble(alt);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }
}
