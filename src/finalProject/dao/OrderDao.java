package finalProject.dao;

import finalProject.Utils;
import finalProject.model.Order;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class OrderDao extends Dao{

    private final static String DBPATH = "E:\\MEGA\\PT\\java-core-grom_fixed\\src\\finalProject\\OrderDb.txt";

    public OrderDao() {
        validate(OrderDao.DBPATH, new File(OrderDao.DBPATH));
    }

    public void bookRoom(Order order){
        order.setId(Dao.generateID(OrderDao.DBPATH));

        ArrayList<String> allOrdersAsString = Dao.getAll(OrderDao.DBPATH);

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
    }

}
