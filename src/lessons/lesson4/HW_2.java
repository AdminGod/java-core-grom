package lessons.lesson4;

public class HW_2 {
    public static void main(String[] args) {
        short a = 2;
        short b = 127;
        int n = 17;
        System.out.println(findDivCount(a, b, n));
    }


    public static int findDivCount(short a, short b, int n){
        int temp = 0;
        for (int i = a; i <= b; i++){
            if(i % n == 0){
                temp ++;
            }
        }
        return (int) temp;
    }

}
