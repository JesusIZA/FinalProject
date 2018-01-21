package sbitneva.services.ship.admin;

import org.apache.log4j.Logger;
import sbitneva.dao.DaoFactory;
import sbitneva.dao.TicketDao;

import java.sql.SQLException;

public class ApplyDiscountService {

    private static Logger log = Logger.getLogger(ApplyDiscountService.class.getName());

    private static ApplyDiscountService applyDiscountService = new ApplyDiscountService();

    private ApplyDiscountService() {

    }

    public static ApplyDiscountService getApplyDiscountService() {
        return applyDiscountService;
    }

    public boolean setDiscount(int ticketId, int discount) {
        boolean result = false;
        if ((discount >= 0) && (discount <= 99)) {
            TicketDao ticketDao = DaoFactory.getTicketDao();
            try {
                int n = ticketDao.updateDiscount(ticketId, discount);
                if (n == 1) {
                    result = true;
                }
            } catch (SQLException e) {
                log.error(e.getClass().getSimpleName() + " : " + e.getMessage());
            }
        }
        return result;
    }
}
