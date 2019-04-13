package database.dao.impl;

import database.dao.LocationDao;
import location.model.LocationModel;

public class AllLocationsDao implements LocationDao {

    private final static String AIRPORT_TPYE = "airport";

    @Override
    public LocationModel getLocationModel(String lat, String lng) {
        return null;
    }

}
