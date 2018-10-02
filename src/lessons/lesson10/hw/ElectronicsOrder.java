package lessons.lesson10.hw;

import java.util.Date;

public class ElectronicsOrder extends Order{

    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        //Arrays.asList(availableCities).contains(getShipFromCity());
        if(checkCity(getShipToCity()) && getBasePrice() > 100 && getCustomerOwned().getGender() == "Женский" && checkCity(getShipFromCity())){
            setDateConfirmed(new Date());
        }
    }
    // return true if acceptable
    private boolean checkCity(String cityName){
        String[] availableCities = {"Киев", "Одесса", "Харьков", "Днепр"};
        for(String city : availableCities){
            if(city == cityName){
                return true;
            }
        }
        return false;
    }

    @Override
    public void calculatePrice() {
        double totalPrice;
        double deliveryPrice;
        double sale = 0;
        String[] aceptableCities = {"Киев", "Одесса"};
        boolean rule1 = false;
        for(String city : aceptableCities){
            if(city == getShipToCity()){
                rule1 = true;
                break;
            }
        }
        if(rule1 != true){
            deliveryPrice = (getBasePrice()*0.15);
        }else {
            deliveryPrice = (getBasePrice()*0.10);
        }
        if(getBasePrice() > 1000){
            sale = ((getBasePrice() + deliveryPrice)*0.05);
        }
        totalPrice = getBasePrice() + deliveryPrice - sale;
        setTotalPrice(totalPrice);
    }
}
