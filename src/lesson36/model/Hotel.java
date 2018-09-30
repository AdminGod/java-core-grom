package lesson36.model;

import lesson36.model.BaseModel;

public class Hotel extends BaseModel {

    private String name;
    private String country;
    private String city;
    private String street;

    public Hotel(long id, String name, String country, String city, String street) {
        super(id);
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }
}
