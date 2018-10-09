package finalProject.dao;

import finalProject.model.Order;

import java.io.File;

public class OrderDao extends Dao{

    private final static String DBPATH = "E:\\MEGA\\PT\\java-core-grom_fixed\\src\\finalProject\\OrderDb.txt";

    public OrderDao() {
        validate(OrderDao.DBPATH, new File(OrderDao.DBPATH));
    }

    public void bookRoom(Order order){
        Dao.save(order.toString(), OrderDao.DBPATH);
    }
}
