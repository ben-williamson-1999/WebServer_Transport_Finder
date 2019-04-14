package json;

import location.model.LocationModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.List;

public class JsonArrayCreator {

    public JSONArray createJsonFromModel(List<LocationModel> listOfLocationModel) {

        JSONArray array = new JSONArray();

        for(LocationModel locationModel : listOfLocationModel){
            JSONObject object = new JSONObject();

            // country
            object.put("country", locationModel.getCountry());
            // iata
            if(!(locationModel.getIata().equals(""))){
                object.put("iata", locationModel.getIata());
            }
            // dst
            if(!(locationModel.getDst() == null)){
                object.put("dst", locationModel.getDst());
            }
            // city
            object.put("city", locationModel.getCity());
            // timezone
            object.put("timezone", locationModel.getTimeZone());
            // name
            object.put("name", locationModel.getName());
            // icao
            if(!(locationModel.getIcao() == null)){
                object.put("icao", locationModel.getIcao());
            }
            // latlng
            JSONObject latlng = new JSONObject();
            latlng.put("latitude", String.valueOf(locationModel.getLatitudeAndLongitude().getLatitude()));
            latlng.put("longitude", String.valueOf(locationModel.getLatitudeAndLongitude().getLongitude()));
            object.put("location",latlng);
            // type
            object.put("type", locationModel.getType());

            array.add(object);
        }

        return array;
    }
}
