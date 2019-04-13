package database.dao.impl;

import database.dao.LocationDao;
import location.model.LocationModel;

public class StationDao implements LocationDao {

    private final static String STATION_TYPE = "station";

    @Override
    public LocationModel getLocationModel(String lat, String lng) {
        return null;
    }

}
