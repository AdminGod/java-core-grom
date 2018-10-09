package finalProject.service;

import finalProject.dao.RoomDao;
import finalProject.model.Filter;
import finalProject.model.Room;

import java.util.ArrayList;

public class RoomService {

    RoomDao roomDao = new RoomDao();

    public ArrayList<Room> findRooms(Filter filter){
        return roomDao.findRooms(filter);
    }
}
