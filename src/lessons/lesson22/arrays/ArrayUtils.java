package lessons.lesson22.arrays;

import java.util.Arrays;

public class ArrayUtils {

    public static int maxElement(int [] arr){
        int max = arr[0];
        for(int el : arr){
            if(el>max){
                max = el;
            }
        }
        return max;
    }

    public static int nCount (int [] arr, int n){
        int count = 0;

        for(int el : arr){
            if(el == n){
                count++;
            }
        }
        return count;
    }

    public static int[] sortAscending(int [] array){
        int [] sorted_Arr = array.clone();
        Arrays.sort(sorted_Arr);
        return sorted_Arr;
    }

    public static int[] sortDescending(int [] array){
        int [] arr_temp = sortAscending(array);
        int len = arr_temp.length;
        int counter = len-1;
        int [] arr = new int [len];
        for(int i = 0; i < len; i++){
            arr[counter] = arr_temp[i];
            counter--;
        }
        return arr;
    }
}
