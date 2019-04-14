package location.model;

public class LatitudeAndLongitude {

    private double latitude;

    private double longitude;

    public LatitudeAndLongitude(String lat, String lng){
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
