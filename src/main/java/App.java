import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.port;

public class App {

    public static void main(String[] args){
        System.setProperty("com.spark.shaded.eclipse.jetty.LEVEL","OFF");

        port(8080);

        get("/test", new Route(){

            @Override
            public Object handle(Request request, Response response) throws Exception {

                String lat = request.queryParams("latitude");
                String lng = request.queryParams("longitude");
                String type = request.queryParams("type");

                return lat + " " + lng + " " + type;
            }
        });
    }
}
