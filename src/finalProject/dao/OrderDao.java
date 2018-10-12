package finalProject.dao;

import finalProject.Utils;
import finalProject.model.Order;
import finalProject.model.Room;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class OrderDao extends Dao{

    private final static String DBPATH = "E:\\MEGA\\PT\\java-core-grom_fixed\\src\\finalProject\\OrderDb.txt";

    RoomDao roomDao  = new RoomDao();

    public OrderDao() {
        validate(OrderDao.DBPATH, new File(OrderDao.DBPATH));
    }

    public void bookRoom(Order order){
        order.setId(Dao.generateID(OrderDao.DBPATH));

        String userId = Long.toString(order.getUser().getId());
        //param: 1 - number of column with userId in orderDb.txt
        ArrayList<String> ordersByUserId = Dao.findByParam(userId, 1, OrderDao.DBPATH);
        if(ordersByUserId.size() > 0){
            System.out.println("Error. This user already booked a room");
            return;
        }

        String roomId = Long.toString(order.getRoom().getId());
        //param: 2 - number of column with roomId in orderDb.txt
        ArrayList<String> ordersByRoomId = Dao.findByParam(roomId, 2, OrderDao.DBPATH);
        if(ordersByRoomId.size() > 0){
            for(String s : ordersByRoomId){
                String [] params = s.split(", ");
                if(params.length <= 0) {
                    continue;
                }
                Date orderDateFrom = Utils.StringToDate(params[3]);
                if (order.getDateFrom().equals(orderDateFrom)){
                    System.out.println("The current room " + order.getRoom().getId() + " has already booked.");
                    return;
                }

            }
        }
        Dao.save(order.toString(), OrderDao.DBPATH);
        Room room = roomDao.findRoomById(Long.parseLong(roomId));
        room.setDateAvailableFrom(order.getDateTo());
        Dao.update(room.toString(), OrderDao.DBPATH);
    }

    public void cancelReservation(long roomId, long userId) {

        ArrayList<String> allOrders = Dao.getAll(OrderDao.DBPATH);
        ArrayList<String> backUp = new ArrayList<>(allOrders);
        Date newDateFrom = new Date();
        for(String s : allOrders){
            //param: 1 - user id, param: 2 - room id;
            String [] params = s.split(", ");

            if(params.length <= 0) {
                continue;
            }
            Utils.StringToDate(params[3]);
            if(roomId == Long.parseLong(params[2]) && userId == Long.parseLong(params[1])){
                allOrders.remove(s);
                break;
            }
        }
        if(allOrders.size() == backUp.size()){
            System.out.println("Error! The order with current parameters not found. Room id: " + roomId + "; user id: " + userId);
            return;
        }
        String oldDB = String.join("\r\n", backUp);
        String newDB = String.join("\r\n", allOrders);
        Dao.update(oldDB, newDB, false, OrderDao.DBPATH);
        //todo update the date in room
        Room room = roomDao.findRoomById(roomId);
        room.setDateAvailableFrom(newDateFrom);
        Dao.update(room.toString(), OrderDao.DBPATH);
        System.out.println("Reservation was canceled");
    }

}
