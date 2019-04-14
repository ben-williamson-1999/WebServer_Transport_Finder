import database.builder.provider.DaoProvider;
import database.dao.LocationDao;
import json.JsonArrayCreator;
import location.model.LocationModel;
import org.json.simple.JSONArray;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.port;

public class App {

    public static void main(String[] args){
        System.setProperty("com.spark.shaded.eclipse.jetty.LEVEL", "OFF");

        port(8080);

        get("/stations", (request, response) -> {

            LocationDao locationDao = new DaoProvider().getDao(request.queryParams("type"));

            List<LocationModel> listOfLocationModels = locationDao.getLocationModel(request.queryParams("latitude"), request.queryParams("longitude"));

            JSONArray jsonArray = new JsonArrayCreator().createJsonFromModel(listOfLocationModels);

            return jsonArray;
        });
    }

}
