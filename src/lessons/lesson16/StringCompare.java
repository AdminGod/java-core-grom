package lessons.lesson16;

import java.util.Arrays;

public class StringCompare {
    public static void main(String[] args) {
        System.out.println(new String("abc") == new String("abc"));
        System.out.println(new String("abc").equals(new String("abc")));
        System.out.println("abc" == "abc");
        System.out.println("Abc".equals("abc"));

        String s1 = "test";
        String s2 = "test";

        System.out.println(s1 == s2);

        //intern add string to String pule

        String s3 = new String("pppp");
        String s4 = "pppp";
        System.out.println(s3 == s4);
        s3 = s3.intern();
        System.out.println(s3 == s4);

        //getBytes - return string as an array of bytes which we can transfer through the network in the future adn then return back to String;
        String s5 = "testStringVar";
        System.out.println(Arrays.toString(s5.getBytes()));
        System.out.println(new String(s5.getBytes()));

    }
}
