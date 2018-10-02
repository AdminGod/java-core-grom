package lessons.lesson8.advertises;

public class HouseAd extends Ad {
    String ownerName;
    String adress;
    double squeare;
    int floors;

    public HouseAd(long id, int price, String adress, double squeare, int floors) {
        super(id, price);
        this.adress = adress;
        this.squeare = squeare;
        this.floors = floors;
    }

    boolean checkOwnerOfAdd() {
        Owners owners = new Owners();

        for (String owner : owners.owners) {
            if (ownerName == owner) {
                return true;
            }
        }
        return false;
    }
}
