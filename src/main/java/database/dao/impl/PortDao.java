package database.dao.impl;

import database.connection.DatabaseConnectionManager;
import database.dao.LocationDao;
import location.model.LocationModel;
import location.model.converter.Converter;

import java.util.List;

public class PortDao implements LocationDao {

    private final static String PORT_TPYE = "port";

    @Override
    public List<LocationModel> getLocationModel(String lat, String lng) {
        DatabaseConnectionManager manager = new DatabaseConnectionManager();
        List<LocationModel> modelList = new Converter().convert(manager.queryDatabase(lat, lng, PORT_TPYE));
        return modelList;
    }
}
