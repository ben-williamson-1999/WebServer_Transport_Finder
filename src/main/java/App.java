import database.builder.provider.DaoProvider;
import database.dao.LocationDao;
import json.JsonArrayCreator;
import location.model.LocationModel;
import org.json.simple.JSONArray;

import static spark.Spark.get;
import static spark.Spark.port;

public class App {

    public static void main(String[] args){
        System.setProperty("com.spark.shaded.eclipse.jetty.LEVEL", "OFF");

        port(8080);

        get("/stations", (request, response) -> {

            LocationDao locationDao = new DaoProvider().getDao(request.queryParams("type"));

            LocationModel locationModel = locationDao.getLocationModel(request.queryParams("latitude"), request.queryParams("longitude"));

            JSONArray jsonArray = new JsonArrayCreator().createJsonFromModel(locationModel);

            return jsonArray;
        });
    }

    /*
     *
     *  need create a new dao depending on the type
     *  then retrieve the data using a prepared java sql statement.
     *  then create a new json creator from the data
     *
     */

}
