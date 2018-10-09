package finalProject.controller;

import finalProject.model.Order;
import finalProject.service.HotelService;
import finalProject.service.OrderService;
import finalProject.service.RoomService;
import finalProject.service.UserService;

public class OrderController {

    OrderService orderService = new OrderService();

    RoomService roomService = new RoomService();
    UserService userService = new UserService();
    HotelService hotelService = new HotelService();

    public void bookRoom(Order order){
        if(order.getDateFrom().before(order.getRoom().getDateAvailableFrom())){
            System.out.println("Error! The room is not available at current period. You are trying to book from \"" + order.getDateFrom().toString() +
                    "\" but room is available from \"" + order.getRoom().getDateAvailableFrom() + ". Please, try choose another period.");
        }
        orderService.bookRoom(order);
    }

}
