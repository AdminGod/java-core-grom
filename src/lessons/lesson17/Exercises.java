package lessons.lesson17;

import java.util.Arrays;

public class Exercises {
    public static void main(String[] args) {
        String test = "There is Test something new or jot sdf sdf sdf word Test op or";

        System.out.println(deleteDuplicates(test));

        System.out.println(Arrays.toString(countDuplicates(test, new String[]{"or", "some", "test"})));

        String str = "Today is good day... Hello";

        System.out.println(replace(str, "is", "that"));
        System.out.println(replace(str, "o", " "));
        System.out.println(replace(str, "To", "PPPP"));
        System.out.println(replace(str, "lo", "X"));
    }

    public static String deleteDuplicates(String input){
        //find duplicates
        //remove duplicates
        String words[] = input.split(" ");
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if(words[i].equals(words[j])){
                    words[j] = "";
                }
            }
        }

        String res = "";
        for(String word : words){
            res += word;
            if(!word.isEmpty()){
                res += " ";
            }
        }
        return res;
    }

    public static int[] countDuplicates(String input, String[] words){
        String strings [] = input.split(" ");

        int res[] = new int[words.length];

        for(String string : strings){
            for(int i = 0; i < words.length; i++){
                if(string.equals(words[i])){
                    res[i]++;
                }
            }
        }
        return res;
    }

    public static String replace(String input, String target, String replacement){
        //find where we is possible a replace
        //check replace
        //if ok >> replace

        int [] indexes = findStartIndexes(input.toCharArray(), target.charAt(0));

        if(indexes.length == 0){
            return input;
        }

        for(int index : indexes){
            if(checkReplace(input, target, index)){
                return replace (input, target, replacement, index);
            }
        }

        return input;
    }

    private static String replace (String input, String target, String replacement, int index){
        char [] startPartOfString = new char[index];
        //safe part of string before our target in original string
        for(int i = 0; i < index; i++){
            startPartOfString[i] = input.toCharArray()[i];
        }

        char [] endPartOfString = new char[input.length() - startPartOfString.length - target.length()];

        char[] inputAsArray = input.toCharArray();//our input as a char arr

        //for(int i = 0, j = startPartOfString.length + target.length(); i < endPartOfString.length && j < input.length(); i++, j++){
        for(int position = 0, j = startPartOfString.length + target.length();position < endPartOfString.length; position++, j++){
            endPartOfString[position] = inputAsArray[j];
        }

        return new String(startPartOfString) + replacement + new String(endPartOfString);
    }

    private static int[] findStartIndexes(char[] inputChars, char beginningChar){
        int count = 0;
        for(char ch: inputChars){
            if(ch == beginningChar){
                count++;
            }
        }

        int [] indexes = new int[count];

        int in = 0;

        int index = 0;

        for(char ch : inputChars){
            if(ch == beginningChar){
                indexes[in] = index;
                in++;
            }
            index++;
        }
        return indexes;
    }

    private static boolean checkReplace(String input, String target, int index){
        char[] inputChars = input.toCharArray();
        char[] replaceChars = target.toCharArray();

        for (int i = 0; i < replaceChars.length && index < inputChars.length; i++, index++){
            if(replaceChars[i] != inputChars[index]){
                return false;
            }
        }
        return true;
    }

}
