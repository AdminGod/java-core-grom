package finalProject.dao;

import finalProject.model.Hotel;

import java.io.File;
import java.util.ArrayList;

public class HotelDao extends Dao{

    public HotelDao() {
        validate(HotelDao.DBPATH, new File(HotelDao.DBPATH));
    }

    private final static String DBPATH = "E:\\MEGA\\PT\\java-core-grom_fixed\\src\\finalProject\\HotelDb.txt";

    public ArrayList<Hotel> findHotelByName (String hotelName){

        ArrayList<Hotel> result = new ArrayList<>();

        ArrayList<String> hotelsAsStrings = Dao.findByName(hotelName, HotelDao.DBPATH);
        if(hotelsAsStrings.size() > 0 ){
            return parseResponseFromDB(hotelsAsStrings);
        }
        return null;
    }

    public ArrayList<Hotel> findHotelByCity (String hotelName){

        ArrayList<String> hotelsAsStrings = Dao.findByParam(hotelName,3, HotelDao.DBPATH);
        if(hotelsAsStrings.size() > 0 ){
            return parseResponseFromDB(hotelsAsStrings);
        }

        return null;
    }

    private ArrayList<Hotel> parseResponseFromDB(ArrayList<String> response){
        ArrayList<Hotel> result = new ArrayList<>();
        for(String s : response){
            result.add(parseStringToHotel(s));
        }
        return result;
    }

    private Hotel parseStringToHotel(String string){
        String[] hotel = string.split(", ");
        return new Hotel(new Long(hotel[0]), hotel[1], hotel[2], hotel[3], hotel[4]);
    }
}
