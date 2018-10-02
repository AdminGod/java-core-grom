package lessons.lesson29;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        useHashSet();


    }

    private static HashSet<Order> useHashSet(){
        HashSet<Order> hashSet = new HashSet<>();

        Order o1 = new Order(1, 20, "USD", "Phone", "user1");
        Order o2 = new Order(2, 20, "USD", "Phone", "user2");
        Order o3 = new Order(3, 20, "USD", "Phone", "user3");
        Order o4 = new Order(4, 20, "USD", "Phone", "user4");
        Order o5 = new Order(5, 20, "USD", "Phone", "user5");
        Order o6 = new Order(6, 20, "USD", "Phone", "user6");

        hashSet.add(o1);
        hashSet.add(o2);
        hashSet.add(o3);
        hashSet.add(o4);
        hashSet.add(o5);
        hashSet.add(o6);

        System.out.println(hashSet);
        hashSet.remove(o6);
        System.out.println(hashSet);

        Object[] orders = hashSet.toArray();

        System.out.println(Arrays.deepToString(orders));

        System.out.println(hashSet.size());

        //retain

        HashSet<Order> hs = new HashSet<>();

        hs.add(o1);
        hs.add(o2);
        hs.add(o3);

        System.out.println(hashSet);
        System.out.println(hs);
        hashSet.retainAll(hs);
        System.out.println(hashSet);
        System.out.println(hs);

        hashSet.add(o5);
        hashSet.add(o6);
        return hashSet;
    }
}
