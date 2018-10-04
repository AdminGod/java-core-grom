package finalProject.service;

import finalProject.dao.HotelDao;
import finalProject.model.Hotel;

import java.util.ArrayList;

public class HotelService {

    HotelDao hotelDao = new HotelDao();

    public ArrayList<Hotel> findHotelByName(String hotelName){
        return hotelDao.findHotelByName(hotelName);
    }

    public ArrayList<Hotel> findHotelByCity(String city){
        return hotelDao.findHotelByCity(city);
    }
}
