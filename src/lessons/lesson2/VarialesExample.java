package lessons.lesson2;

public class VarialesExample {
    public static void main(String[] args) {
        byte a = 100;
        short b = 20000;
        int c = 3222;
        long g = 320;

        double d = 3.231564;
        float f = 32.2145163f;

        char cc1 = 'd';
        char cc2 = '\u0001';
        boolean bb = true;
        //declaration:

        int aaa;

        //initialization:
        aaa = 312123;

        aaa = 32132131;

        int a1 = 100;
        int a2 = 30;

        System.out.println(a1 / a2);
        System.out.println(a1 % a2);

        while (a1 > 0) {
            System.out.println(a1);
            a1 += 10000;
        }
        do {
            System.out.println(a1);
        } while (a1 < 0);
    }
}
