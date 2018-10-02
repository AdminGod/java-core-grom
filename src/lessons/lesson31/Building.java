package lessons.lesson31;

public class Building {
    private String adress;
    private int floors;

    public Building(String adress, int floors) {
        this.adress = adress;
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Building{" +
                "adress='" + adress + '\'' +
                ", floors=" + floors +
                '}';
    }
}
