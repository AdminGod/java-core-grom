package lessons.lesson5;

public class ArraysPractice {
    public static void main(String[] args) {
        int [] array = {-10, 0, 110, 555, 1000, -45, 0, 60, 10};
        System.out.println(maxElement(array));
        System.out.println(nCount(array, 0));
    }

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
}
