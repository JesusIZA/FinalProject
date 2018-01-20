package sbitneva.services.common;

import sbitneva.dao.BasicDao;
import sbitneva.dao.ComfortLevelDao;
import sbitneva.dao.DaoFactory;
import sbitneva.entity.ComfortLevel;

import java.sql.SQLException;
import static sbitneva.dao.ComfortLevelDao.*;

public class ShowServicesService {

    private ShowServicesService(){

    }

    public static ShowServicesService getShowTicketsService() {
        return showTicketsService;
    }

    private static ShowServicesService showTicketsService = new ShowServicesService();

    public ComfortLevel getServices(int comfortLevelId) {
        ComfortLevel comfortLevel = null;
        ComfortLevelDao comfortLevelDao = DaoFactory.getComfortLevelDao();
        BasicDao basicDao = DaoFactory.getBasicDao();
        try{
            String clName = basicDao.getNameById(GET_COMFORT_LEVEL_NAME, comfortLevelId);
            if(clName !=null){
                comfortLevel = new ComfortLevel();
                comfortLevel.setComfortLevelId(comfortLevelId);
                comfortLevel.setComfortLevelName(clName);
                comfortLevel.setServices(comfortLevelDao.getComfortLevelInfo(comfortLevelId));
            }

        } catch(SQLException e) {

        }
        return comfortLevel;
    }
}
