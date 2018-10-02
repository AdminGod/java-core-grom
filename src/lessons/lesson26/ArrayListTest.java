package lessons.lesson26;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {

    public static void main(String[] args) {
        useList();
    }

    public static ArrayList<Order> useList(){
        ArrayList<Order> list = new ArrayList<>();
        ArrayList<Order> anotherList = new ArrayList<>();

        Order order1 = new Order(1, 100, "test1", "zzz");
        Order order2 = new Order(2, 100, "test2", "zzz");
        Order order3 = new Order(3, 100, "test3", "zzz");
        Order order4 = new Order(4, 100, "test4", "zzz");
        Order order5 = new Order(5, 100, "test5", "zzz");

        list.add(order1);
        list.add(order1);
        list.add(1, order2);

        System.out.println(list.toString());

        list.remove(order1);
        list.remove(0);
        System.out.println(list.toString());

        anotherList.add(order3);
        anotherList.add(order4);
        anotherList.add(order5);

        System.out.println(anotherList.toString());

        list.addAll(anotherList);
        System.out.println(list.toString());

        ArrayList<Order> subListTest = new ArrayList<>(list.subList(1, (list.size())));
        System.out.println(subListTest.toString());

        System.out.println(subListTest.contains(order4));

        Object[] ordersArr = anotherList.toArray();
        System.out.println(Arrays.deepToString(ordersArr));

        subListTest.clear();

        System.out.println(subListTest.toString());

        ArrayList<Order> result = new ArrayList<>();
        result.add(order1);
        result.add(order2);
        result.add(order3);
        result.add(order4);
        result.add(order5);
        return result;
    }
}
