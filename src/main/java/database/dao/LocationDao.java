package database.dao;

import location.model.LocationModel;

public interface LocationDao {

    public LocationModel getLocationModel(String lat, String lng);

}
