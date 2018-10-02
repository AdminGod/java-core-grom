package lessons.lesson4;

public class HW_3 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(2.3/0.2);
        System.out.println(sum1(1, Integer.MAX_VALUE));
        System.out.println(sum2(1, Integer.MAX_VALUE));
        //Sys.out.println(compareSums(-1, Integer.MAX_VALUE, 5,8));//+5+6+7+8=26 || 6+7+8+9 = 30

    }

    public static boolean compareSums (int a, int b, int c, int d){
        return true;//sum(a, b) > sum(c, d);
    }

    public static long sum1(int a, int b){
        return (long)(a+b)*(b-a+1)/2;
    }

    public static long sum2(int a, int b){
        long sum = 0;
        for(long i = a; i <= b; i++){
            sum += i;
            if (i == Integer.MAX_VALUE){
                break;
            }
        }

        return sum;
    }

}
