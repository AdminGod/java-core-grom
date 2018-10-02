package lessons.lesson8.hw_1;

public class Demo {
    public static void main(String[] args) {
        int [] arr = {11,54, 6541, 2, 67, 0};
        Adder adder = new Adder();
        System.out.println(adder.add(2147483600, 100));
        System.out.println(adder.check(arr));

    }
}
