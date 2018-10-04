package finalProject.controller;

import finalProject.model.Hotel;
import finalProject.service.HotelService;

import java.util.ArrayList;

public class HotelController {
    HotelService hotelService = new HotelService();

    public ArrayList<Hotel> findHotelByName (String hotelName){
        return hotelService.findHotelByName(hotelName);
    }

    public ArrayList<Hotel> findHotelByCity (String city){
        return hotelService.findHotelByCity(city);
    }
}
