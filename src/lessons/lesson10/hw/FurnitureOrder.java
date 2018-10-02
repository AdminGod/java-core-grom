package lessons.lesson10.hw;

import java.util.Date;

public class FurnitureOrder extends Order{

    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        if(getBasePrice() > 500 && getCustomerOwned().getName() != "Тест" && checkCity(getShipFromCity())) {
            setDateConfirmed(new Date());
        }
    }
    // return true if acceptable
    private boolean checkCity(String cityName){
        String[] availableCities = {"Киев", "Львов"};
        boolean rule1 = false;
        for(String city : availableCities){
            if(cityName == city){
                rule1 = true;
                break;
            }
        }
        return rule1;
    }

    @Override
    public void calculatePrice() {
        double deliveryPrice;
        if(getBasePrice() <= 0){
            return;
        }
        if(getBasePrice() < 5000){
            deliveryPrice = (getBasePrice() * 0.05);
        }else {
            deliveryPrice = (getBasePrice() * 0.02);
        }
        setTotalPrice(deliveryPrice + getBasePrice());
    }
}
