package lessons.lesson2;

public class SumOfNumbers {
    public static void main(String[] args) {
        long i = 0;
        long a = 0;
        while (i <= 10000000){
            a += i;
            i++;
        }
        System.out.println(a);
    }
}
