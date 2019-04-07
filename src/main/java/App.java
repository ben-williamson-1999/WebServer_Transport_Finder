package database;

import static spark.Spark.port;

public class HelloWorld {

    public static void main(String[] args){
        System.setProperty("com.spark.shaded.eclipse.jetty.LEVEL","OFF");

        port(8080);


    }
}
