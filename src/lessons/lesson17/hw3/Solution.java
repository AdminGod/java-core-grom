package lessons.lesson17.hw3;

public class Solution {

    public static void main(String[] args) {
        String test1 = "lksdfx la5sdhaf kAdfbgdkf4jf d5s";
        String test2 = "ss s  ssss ss ss ss aAs  aAa      aAs    aAs aa aAs ss ss ";
        System.out.println(mostCountedWord(test1));
        System.out.println(mostCountedWord(test2));
        System.out.println(mostCountedWord(""));
        System.out.println(mostCountedWord(null));

    }

    public static String mostCountedWord(String string) {
        if (string == null) {
            return null;
        }
        String[] words = getWords(string);
        if (words == null) {
            return null;
        }
        //count repeated words
        String result = words[0];
        int counted = 1;
        for (String word_1 : words) {
            int temp_counter = 0;
            for (String word_2 : words) {
                if (word_1.equals(word_2)) {
                    temp_counter++;
                }
            }
            if (temp_counter > counted) {
                result = word_1;
                counted = temp_counter;
            }
        }
        return result;
    }

    private static String[] getWords(String string) {
        String tempResult = "";
        if (string != null) {
            String[] words = string.split(" ");
            for (String word : words) {
                if (matched(word) && word.length() > 0) {
                    tempResult += word + ";";
                }
            }
        }
        if (tempResult.length() > 0) {
            return tempResult.split(";");
        }
        return null;
    }

    private static boolean matched(String word) {
        if (word != null && word.length() > 0) {
            char[] symbols = word.toLowerCase().toCharArray();
            for (char c : symbols) {
                if (!Character.isLetter(c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}


