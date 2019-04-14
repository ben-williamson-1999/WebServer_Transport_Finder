package database.dao.impl;

import database.connection.DatabaseConnectionManager;
import database.dao.LocationDao;
import location.model.LocationModel;
import location.model.converter.Converter;

import java.util.List;

public class AirportDao implements LocationDao {

    private final static String AIRPORT_TPYE = "airport";

    @Override
    public List<LocationModel> getLocationModel(String lat, String lng) {
        DatabaseConnectionManager manager = new DatabaseConnectionManager();
        List<LocationModel> modelList = new Converter().convert(manager.queryDatabase(lat, lng, AIRPORT_TPYE));
        return modelList;
    }

}
