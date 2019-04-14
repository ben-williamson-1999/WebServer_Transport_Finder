package database.dao;

import location.model.LocationModel;

import java.util.List;

public interface LocationDao {

    List<LocationModel> getLocationModel(String lat, String lng);

}
