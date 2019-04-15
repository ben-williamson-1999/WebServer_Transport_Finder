import database.builder.provider.DaoProvider;
import database.dao.LocationDao;
import json.JsonArrayCreator;
import location.model.LocationModel;
import org.json.simple.JSONArray;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.notFound;
import static spark.Spark.port;

public class App {

    public static void main(String[] args){
        System.setProperty("com.spark.shaded.eclipse.jetty.LEVEL", "OFF");

        port(8080);

        get("/stations", (request, response) -> {

            try{
                LocationDao locationDao = new DaoProvider().getDao(request.queryParams("type"));

                List<LocationModel> listOfLocationModels = locationDao.getLocationModel(request.queryParams("latitude"), request.queryParams("longitude"));

                JSONArray jsonArray = new JsonArrayCreator().createJsonFromModel(listOfLocationModels);

                response.raw().addHeader("Content-Type", "application/json");
                response.raw().addHeader("Access-Control-Allow-Methods", "GET");
                response.raw().addHeader("Access-Control-Allow-Origin", "*");

                return jsonArray;

            } catch (Exception e){
                return "Please make sure you set the latitude, longitude and type parameters";
            }

        });

        notFound("404 Not Found");
    }

}

