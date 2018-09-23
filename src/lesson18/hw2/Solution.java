package lesson18.hw2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbers("            ")));
        System.out.println(Arrays.toString(findNumbers(" ")));
        System.out.println(Arrays.toString(findNumbers("")));
        System.out.println(Arrays.toString(findNumbers("asdf 4 23 gfs 213")));
        System.out.println(Arrays.toString(findNumbers("asdf asdf asdf gfs sfg")));
        System.out.println(Arrays.toString(findNumbers("2 245 2345 245 24 5")));
    }

    public static int[] findNumbers(String text){
        if(text != null && text != ""){
            String [] words = text.split(" ");
            int intAmount = 0;

            for (String word : words){
                if(isNumber(word)) {
                    intAmount++;
                }
            }
            int[] result = new int[intAmount];
            int position = 0;

            for (String word : words){
                if (isNumber(word)) {
                    result[position] = Integer.parseInt(word);
                    position++;
                }else {
                    System.out.println("not number");
                }
            }
            return result;
        }
        return null;
    }
    private static boolean isNumber (String word){
        char [] chars = word.toCharArray();
        for(char i : chars){
            if(!Character.isDigit(i)){
                return false;
            }
        }
        return true;
    }
}
