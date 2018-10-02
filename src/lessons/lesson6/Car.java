package lessons.lesson6;

public class Car {
    public int price;
    public int yearOfManufacturing;
    public String color;
    public String ownerName;
    public double weight;
    public int horsePower;

    public Car(int price, int yearOfManufactoring, String ownerName) {
        this.price = price;
        this.yearOfManufacturing = yearOfManufactoring;
        this.ownerName = ownerName;
    }

    public void startRun(){
        System.out.println("I am running....");
    }

    public void stopRun(){
        System.out.println("I am stopping....");
    }

    public void changeOwner(String newOqnerName){
        ownerName = newOqnerName;
    }
/***
    private class Test{

    }
*/
}
