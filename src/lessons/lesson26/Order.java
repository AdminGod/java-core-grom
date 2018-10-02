package lessons.lesson26;

import java.util.Objects;

public class Order {

    private long id;
    private int price;                                                      
    private String itemName;
    private String shopIdentificator;

    public Order() {
    }

    public Order(long id, int price, String itemName, String shopIdentificator) {
        this.id = id;
        this.price = price;
        this.itemName = itemName;
        this.shopIdentificator = shopIdentificator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getShopIdentificator() {
        return shopIdentificator;
    }

    public void setShopIdentificator(String shopIdentificator) {
        this.shopIdentificator = shopIdentificator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                price == order.price &&
                Objects.equals(itemName, order.itemName) &&
                Objects.equals(shopIdentificator, order.shopIdentificator);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, price, itemName, shopIdentificator);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", itemName='" + itemName + '\'' +
                ", shopIdentificator='" + shopIdentificator + '\'' +
                '}';
    }
}
