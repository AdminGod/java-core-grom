package lessons.lesson7;

import lessons.lesson6.Order;

import java.util.Date;

public class DemoHomeWork {
    public static void main(String[] args) {
        Order o1 = createOrder();
        o1.checkPrice();
        o1.confirmOrder();
        o1.isValidType();
        Order o2 = createOrderAndCallMethods();
        o2.isValidType();
        o2.confirmOrder();
        o2.checkPrice();
    }
    public static Order createOrder(){
        Order order = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
        return order;
    }
    public static Order createOrderAndCallMethods(){
        Order order = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        return order;
    }
}
