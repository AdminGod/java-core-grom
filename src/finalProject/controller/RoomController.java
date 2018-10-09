package finalProject.controller;

import finalProject.model.Filter;
import finalProject.model.Room;
import finalProject.service.RoomService;

import java.util.ArrayList;

public class RoomController {

    RoomService roomService = new RoomService();


    public ArrayList<Room> findRooms(Filter filter){
        return roomService.findRooms(filter);
    }



    public Room findRoomById(long id){
        return roomService.findRoomById(id);
    }
}
