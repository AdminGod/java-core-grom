package finalProject;

import java.text.ParseException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws ParseException {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(list1);
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        list1.add("some text1");
        list1.add("some text2");
        list1.add("some text3");
        System.out.println(list1.toString());
        ArrayList<String> list3 = new ArrayList<>(list1);
        list1.remove("some text2");
        System.out.println(list1.toString());
        System.out.println(list3.toString());
        System.out.println(String.join("\r\n", list3));

    }

    static class T{};

    static class T1 extends T{
        String param1;
        String param2;

        public T1(String param1, String param2) {
            this.param1 = param1;
            this.param2 = param2;
        }

        @Override
        public String toString() {
            return "T1{" +
                    "param1='" + param1 + '\'' +
                    ", param2='" + param2 + '\'' +
                    '}';
        }
    }

    static class T2 extends T{
        String param1;
        String param2;
        String param3;


        public T2(String param1, String param2, String param3) {
            this.param1 = param1;
            this.param2 = param2;
            this.param3 = param3;
        }

        @Override
        public String toString() {
            return "T2{" +
                    "param1='" + param1 + '\'' +
                    ", param2='" + param2 + '\'' +
                    ", param3='" + param3 + '\'' +
                    '}';
        }
    }
}
