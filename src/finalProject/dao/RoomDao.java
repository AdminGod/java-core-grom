package finalProject.dao;

import java.io.File;

public class RoomDao extends Dao{

    private final static String DBPATH = "E:\\MEGA\\PT\\java-core-grom_fixed\\src\\finalProject\\RoomDb.txt";

    public RoomDao() {
        validate(RoomDao.DBPATH, new File(RoomDao.DBPATH));
    }
}
