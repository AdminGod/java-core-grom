package lessons.lesson17.hw1;

public class Solution {
    public static void main(String[] args) {
        String test = "       test      test  ";

    }

    private static boolean matched(String word) {
        if (word != null && word.length() > 0) {
            char[] symbols = word.toLowerCase().toCharArray();
            String regEx = "abcdefghijklmnopqrstuvwxyz";
            for (char c : symbols) {
                //if(regEx.indexOf(c) == -1){
                if (!Character.isLetter(c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
