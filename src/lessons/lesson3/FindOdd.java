package lessons.lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int number = 0;
        int flag;
        for (int i = 0; i <= 1000; i++){
            if(i%2 == 1){
                number += i;
                System.out.println("Found");
            }
        }
        if(number * 5 > 5000){
            System.out.println("Bigger");
        }else {
            System.out.println("Smaller");
        }
    }
}
