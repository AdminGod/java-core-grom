package finalProject.service;

import finalProject.dao.OrderDao;
import finalProject.model.Order;

public class OrderService {

    OrderDao orderDao = new OrderDao();

    public void bookRoom(Order order){
        orderDao.bookRoom(order);
    }

    public void cancelReservation(long roomId, long userId) {
        orderDao.cancelReservation(roomId, userId);
    }
}
