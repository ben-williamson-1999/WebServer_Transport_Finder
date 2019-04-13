package database.builder.provider;

import database.dao.LocationDao;
import database.dao.impl.AirportDao;
import database.dao.impl.AllLocationsDao;
import database.dao.impl.PortDao;
import database.dao.impl.StationDao;

public class DaoProvider {

    public LocationDao getDao(String runnerType){
        if(runnerType == null){
            return null;
        }
        if(runnerType.equalsIgnoreCase("STATION")){
            return new StationDao();
        } else if (runnerType.equalsIgnoreCase("AIRPORT")){
            return new AirportDao();
        } else if (runnerType.equalsIgnoreCase("PORT")){
            return new PortDao();
        } else if (runnerType.equalsIgnoreCase("ALL")){
            return new AllLocationsDao();
        } else {
            return null;
        }

    }

}
