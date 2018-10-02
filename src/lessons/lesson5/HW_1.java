package lessons.lesson5;

import java.util.Arrays;

public class HW_1 {
    public static void main(String[] args) {
        int [] arr = {1, 55, 22, 3215, 99, 0, 511, 3};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sortAscending(arr)));
        System.out.println(Arrays.toString(sortDescending(arr)));
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
