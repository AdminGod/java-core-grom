package finalProject.dao;

import finalProject.model.Filter;
import finalProject.model.Room;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RoomDao extends Dao{

    private final static String DBPATH = "E:\\MEGA\\PT\\java-core-grom_fixed\\src\\finalProject\\RoomDb.txt";

    public RoomDao() {
        validate(RoomDao.DBPATH, new File(RoomDao.DBPATH));
    }

    public ArrayList<Room> findRooms(Filter filter){
        ArrayList<Room> allRooms = parseResponseFromDB(Dao.getAll(DBPATH));
        ArrayList<Room> result = new ArrayList<>();
        for(Room room : allRooms){
            if(filter.getNumberOfGuests() == room.getNumberOfGuests() && Math.abs(filter.getPrice() - room.getPrice()) <= 100 &&
               filter.isBreakfastIncluded() == room.isBreakfastIncluded() && filter.isPetsAllowed() == room.isPetsAllowed() &&
               (filter.getDateAvailableFrom().equals(room.getDateAvailableFrom()) || filter.getDateAvailableFrom().after(room.getDateAvailableFrom())) &&
               filter.getCountry().equals(room.getHotel().getCountry()) && filter.getCity().equals(room.getHotel().getCity())){
                result.add(room);
            }
        }
        return result;
    }

    public Room findRoomById (Long id){
        ArrayList<String> roomsAsStrings = Dao.findByParam(id.toString(),0, RoomDao.DBPATH);
        if(roomsAsStrings.size() > 0 ){
            return parseResponseFromDB(roomsAsStrings).get(0);
        }
        return null;
    }

    private ArrayList<Room> parseResponseFromDB(ArrayList<String> response){
        ArrayList<Room> result = new ArrayList<>();
        for(String s : response){
            Room room = parseStringToRoom(s);
            if(room != null) {
                result.add(room);
            }
        }
        return result;
    }

    private Room parseStringToRoom(String string){
        String[] hotel = string.split(", ");
        HotelDao hotelDao = new HotelDao();
        Room room;
        try {
            room = new Room(new Long(hotel[0]), Integer.parseInt(hotel[1]), Double.parseDouble(hotel[2]), Boolean.parseBoolean(hotel[3]), Boolean.parseBoolean(hotel[4]), new SimpleDateFormat("dd-MM-yyyy").parse(hotel[5]), hotelDao.findHotelById(Long.parseLong(hotel[6])));
        } catch (ParseException e) {
            room = null;
        }
        return room;
    }
}
