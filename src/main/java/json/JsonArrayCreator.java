package json;

import location.model.LocationModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.List;

public class JsonArrayCreator {

    public JSONArray createJsonFromModel(List<LocationModel> listOfLocationModel) {

        JSONArray array = new JSONArray();

        for(LocationModel locationModel : listOfLocationModel){
            try{
                JSONObject object = new JSONObject();

                object.put("name", locationModel.getName());

                object.put("city", locationModel.getCity());

                object.put("country", locationModel.getCountry());

                if(!(locationModel.getIata().equals(""))){
                    object.put("iata", locationModel.getIata());
                }

                if(!(locationModel.getIcao().equals(""))){
                    object.put("icao", locationModel.getIcao());
                }

                JSONObject latlng = new JSONObject();
                latlng.put("latitude", String.valueOf(locationModel.getLatitudeAndLongitude().getLatitude()));
                latlng.put("longitude", String.valueOf(locationModel.getLatitudeAndLongitude().getLongitude()));
                latlng.put("altitude", String.valueOf(locationModel.getLatitudeAndLongitude().getAltitude()));
                object.put("location",latlng);

                object.put("timezone", locationModel.getTimeZone());

                if(!(locationModel.getDst() == null)){
                    object.put("dst", locationModel.getDst());
                }

                object.put("type", locationModel.getType());

                array.add(object);

            } catch (Exception e){
                throw new RuntimeException("There was an error when creating to JSON Array\nPlease make sure you set the latitude, longitude type parameters and the database is formatted correct");
            }

        }
        return array;
    }
}
