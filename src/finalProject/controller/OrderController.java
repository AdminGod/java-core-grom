package finalProject.controller;

import finalProject.model.Hotel;
import finalProject.model.Order;
import finalProject.model.Room;
import finalProject.model.User;
import finalProject.service.HotelService;
import finalProject.service.OrderService;
import finalProject.service.RoomService;
import finalProject.service.UserService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OrderController {

    OrderService orderService = new OrderService();

    RoomService roomService = new RoomService();
    UserService userService = new UserService();
    HotelService hotelService = new HotelService();

    public void bookRoom(long roomId, long hotelId, long userId){
        User user = userService.getUserById(userId);
        Hotel hotel = hotelService.findHotelById(hotelId);
        Room room = roomService.findRoomById(roomId);

        Date dateFrom = room.getDateAvailableFrom();

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(dateFrom);

        int duration = 3;
        calendar.add(Calendar.DATE, duration);

        Date dateTo = calendar.getTime();

        Order order = new Order(user, room, dateFrom, dateTo, duration*room.getPrice());

        orderService.bookRoom(order);

    }

}
