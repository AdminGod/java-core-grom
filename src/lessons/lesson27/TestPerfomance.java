package lessons.lesson27;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class TestPerfomance {

    public static void main(String[] args) {
        testAddMethod();
        testRemoveMethod();
        testGetMethod();
    }
    private static void testAddMethod(){
        ArrayList<String> arrayList = new ArrayList<>();

        Date start = new Date();

        for (int i = 0; i < 100_000; i++){
            arrayList.add(i, String.valueOf(i));
        }

        Date finish = new Date();

        System.out.println("add array list: " + (finish.getTime() - start.getTime()));

        LinkedList<String> linkedList = new LinkedList<>();

        Date start1 = new Date();

        for (int i = 0; i < 100_000; i++){
            linkedList.add(i, String.valueOf(i));
        }

        Date finish1 = new Date();

        System.out.println("add linked list: " + (finish1.getTime() - start1.getTime()));
    }

    private static void testRemoveMethod(){
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 100_000; i++){
            arrayList.add(i, String.valueOf(i));
        }
        Date start = new Date();

        for (int i = 0; i < 90_000; i++){
            arrayList.remove(10000);
        }

        Date finish = new Date();

        System.out.println("remove array list: " + (finish.getTime() - start.getTime()));

        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 100_000; i++){
            linkedList.add(i, String.valueOf(i));
        }

        Date start1 = new Date();

        for (int i = 0; i < 90_000; i++){
            linkedList.remove(10000);
        }

        Date finish1 = new Date();

        System.out.println("remove linked list: " + (finish1.getTime() - start1.getTime()));
    }

    private static void testGetMethod(){
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 100_000; i++){
            arrayList.add(i, String.valueOf(i));
        }
        Date start = new Date();

        for (int i = 0; i < 100_000; i++){
            arrayList.get(50000);
        }

        Date finish = new Date();

        System.out.println("get array list: " + (finish.getTime() - start.getTime()));

        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 100_000; i++){
            linkedList.add(i, String.valueOf(i));
        }

        Date start1 = new Date();

        for (int i = 0; i < 100_000; i++){
            linkedList.get(50000);
        }

        Date finish1 = new Date();

        System.out.println("get linked list: " + (finish1.getTime() - start1.getTime()));
    }
}
