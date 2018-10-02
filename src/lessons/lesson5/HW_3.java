package lessons.lesson5;

import java.util.Arrays;

public class HW_3 {
    public static void main(String[] args) {
        int [] arr = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11};
        System.out.println(uniqueCount(arr));
    }

    static  int uniqueCount(int [] arr){
        int [] cloneArr = arr.clone();
        Arrays.sort(cloneArr);
        int counter = 1;
        int temp = cloneArr[0];
        for(int i = 1; i < cloneArr.length; i++){
            if(temp == cloneArr[i]){
                continue;
            }
            temp = cloneArr[i];
            counter++;
        }

        return counter;
    }
}