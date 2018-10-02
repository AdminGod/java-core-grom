package lessons.lesson16;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String test = "someStringExample";
        System.out.println(test.isEmpty());
        System.out.println("".isEmpty());
        //System.out.println((new String()).isEmpty());
        System.out.println(test.length());
        System.out.println(test.charAt(2));

        String res = test.replace("me", "T");
        System.out.println(res);

        System.out.println(test.replaceAll("me", "T"));

        System.out.println(test);

        System.out.println(test.contains("mes"));//not error, nothing happen

        System.out.println(test);

        String phrase = "Hello there guys";
        System.out.println(Arrays.toString(phrase.split(" ")));
        //System.out.println(Arrays.toString(s1.split("e")));//remove delimetr in result

        System.out.println(" test a".trim());//remove spaces

        System.out.println(phrase.substring(5));
        System.out.println(phrase.substring(5, 10).trim());

        System.out.println(test.toUpperCase());
        System.out.println(test.toLowerCase());

        test.getBytes();
        test.intern();
        test.equals("eeee");

    }
}
