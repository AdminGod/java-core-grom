package lessons.lesson8.advertises;

import java.util.Date;

public class Ad extends BaseEntity{

    int price;
    Date dateCreated;

    public Ad(long id, int price) {
        super(id);
        this.price = price;
        this.dateCreated = dateCreated;
    }

    void publishAd(){
        //some logic
    }
}
