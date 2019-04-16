package location.model.converter;

import location.model.LatitudeAndLongitude;
import location.model.LocationModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public List<LocationModel> convert(ResultSet rs) {

        List<LocationModel> modelList = new ArrayList<>();

        try{
            while(rs.next()){

                LocationModel model = new LocationModel()
                        .setName(rs.getString("Name"))
                        .setType(rs.getString("StationType"))
                        .setLatitudeAndLongitude(new LatitudeAndLongitude(rs.getString("Latitude"), rs.getString("Longitude"), rs.getString("Altitude")))
                        .setCity(rs.getString("City"))
                        .setCountry(rs.getString("Country"))
                        .setTimeZone(rs.getString("Timezone"));
                try{
                    model.setIata(rs.getString("IATA"));
                } catch (Exception e){}
                try{
                    model.setIcao(rs.getString("ICAO"));
                } catch (Exception e){}
                try{
                    model.setDst(rs.getString("DST"));
                } catch (Exception e){}

                modelList.add(model);

            }
        } catch (NumberFormatException e){
            throw new RuntimeException("Please make sure the latitude and longitude parameters are valid numeric values");
        } catch (Exception e){
            throw new RuntimeException("Cant convert database data to location\nPlease make sure you set the latitude, longitude type parameters and the database is formatted correct");
        }

        return modelList;
    }
}
