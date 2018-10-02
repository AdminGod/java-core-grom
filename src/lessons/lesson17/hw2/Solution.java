package lessons.lesson17.hw2;

public class Solution {

    public static void main(String[] args) {
        String test = "lksd5fx la5sdhaf kAdfbgdkf4jf d5s";
        System.out.println(maxWord(test));
        System.out.println(minWord(test));

    }

    public static String maxWord(String string) {
        String[] words = string.split(" ");
        String result = null;
        int length = 0;
        for (String word : words) {
            if (matched(word) && word.length() > length) {
                result = word;
                length = word.length();
            }
        }
        return result;
    }

    public static String minWord(String string) {
        String[] words = string.split(" ");
        String result = null;
        int length = Integer.MAX_VALUE;
        for (String word : words) {
            if (matched(word) && word.length() < length) {
                result = word;
                length = word.length();
            }
        }
        return result;
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

