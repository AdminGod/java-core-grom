package lessons.lesson8.hw_1;

import java.util.Arrays;

public class Arithmetic {
    boolean check(int [] arr){
        Arrays.sort(arr);
        if(arr[0] + arr[arr.length-1] > 100){
            return true;
        }
        return false;
    }
}
