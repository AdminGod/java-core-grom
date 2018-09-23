package lesson18.hw1;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbers(" ")));
        System.out.println(Arrays.toString(findNumbers("")));
        System.out.println(Arrays.toString(findNumbers("asdf 4 23 gfs 213")));
        System.out.println(Arrays.toString(findNumbers("asdf asdf asdf gfs sfg")));
        System.out.println(Arrays.toString(findNumbers("2 245 2345 245 24 5")));
    }

    public static int[] findNumbers(String text){
        if(text != null){
            String [] words = text.split(" ");
            int intAmount = 0;
            for (String word : words){
                try{
                    Integer.parseInt(word);
                    intAmount++;
                }catch (Exception e){

                }
            }
            int[] result = new int[intAmount];
            int position = 0;
            for (String word : words){
                try{
                    Integer.parseInt(word);
                    result[position] = Integer.parseInt(word);
                    position++;
                }catch (Exception e){
                    System.out.println("not a number");
                }
            }
            return result;
        }
        return null;
    }
}
