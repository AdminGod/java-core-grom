package lessons.lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
        int a = 0;
        for (int i = 0; i <= 1000; i++){
            a += i;
        }
        a++;
        int b = a%1234;
        int c = (a-b)/1234;

        System.out.println(b > c);
    }
}
