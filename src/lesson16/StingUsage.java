package lesson16;

public class StingUsage {
    public static void main(String[] args) {
        String s1 = "someString";
        String s2 = s1 + "_end";

        System.out.println(s2);

        char ch1 = 't';
        char ch2 = 'o';

        char [] chars = {ch1, ch2};

        String res = new String(chars);
        System.out.println(res);

        String string = new String("hello there");
        System.out.println(string);
    }
}
