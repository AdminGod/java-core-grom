package lessons.lesson5;

import java.util.Arrays;

public class FirstArray {
    public static void main(String[] args) {
        int [] arr = new int [5];
        arr[1] = 321;
        arr[3] = 123;
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
        //Sys.out.println(arr[5]);//error  ArrayIndexOutOfBoundsException
    }
}
