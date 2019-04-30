package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnectionManager {

    private final String url = "jdbc:sqlite:./database/transport.sqlite";

    private String stations = "";

    private String sql;

    public ResultSet queryDatabase(String lat, String lng, String stationType) {

        ResultSet resultSet = null;

        try{

            if(!(isNumeric(lat) || isNumeric(lng))){
                throw new NumberFormatException();
            }

            setSql(stationType);

            Connection connection = DriverManager.getConnection(url);
            double cos = Math.cos(Math.toRadians(Double.parseDouble(lat)));
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, Double.parseDouble(lat));
            statement.setDouble(2, Double.parseDouble(lat));
            statement.setDouble(3, cos);
            statement.setDouble(4, Double.parseDouble(lng));
            statement.setDouble(5, Double.parseDouble(lng));
            if(!stationType.equalsIgnoreCase("ALL")){
                statement.setString(6, stationType);
            }

            resultSet = statement.executeQuery();


        }  catch (NumberFormatException e) {
            throw new RuntimeException("Please make sure the latitude and longitude parameters are valid numeric values");
        } catch (Exception e){
            throw new RuntimeException("There was an error when trying to get data from the database\nPlease make sure you set the latitude, longitude type parameters and the database is formatted correct");
        }

        return resultSet;
    }

    private boolean isNumeric(String potentialNumber){
        try{
            Double.parseDouble(potentialNumber);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    private void setSql(String stationType){
        if(!stationType.equalsIgnoreCase("ALL")){
            stations = "WHERE StationType = ?";
            this.sql = "SELECT Name, City, Country, IATA, ICAO, Latitude, Longitude, Altitude, Timezone, DST, StationType, (((? - Latitude) * (? - Latitude)) + (? * ((? - Longitude) * (? - Longitude)))) AS DistanceMetric FROM stations " + stations + " ORDER BY DistanceMetric LIMIT 5;";
        } else {
            this.sql = "SELECT Name, City, Country, IATA, ICAO, Latitude, Longitude, Altitude, Timezone, DST, StationType, (((? - Latitude) * (? - Latitude)) + (? * ((? - Longitude) * (? - Longitude)))) AS DistanceMetric FROM stations " + stations + " ORDER BY DistanceMetric LIMIT 5;";
        }
    }
}
