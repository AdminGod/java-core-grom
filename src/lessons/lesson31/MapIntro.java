package lessons.lesson31;

import java.util.HashMap;
import java.util.Map;

public class MapIntro {
    public static void main(String[] args) {
        /**
        Map<String, Building> map = new HashMap<>();
        Building building1 = new Building("school...", 5);
        Building building2 = new Building("school2...", 7);

        map.put("School_1", building1);
        map.put("School_2", building2);
        System.out.println(map);

        System.out.println(map.keySet());

        System.out.println(map.values());

        System.out.println(map.get("School_1"));
        System.out.println(map.get("School_1222"));

        map.remove("School_2");

        System.out.println(map);

        map.put(null, building1);
        */
        System.out.println(countSymbols("hello world"));
        System.out.println(countWords("hello hwe h hello"));

    }

    public static Map<Character, Integer> countSymbols (String text){
        Map<Character, Integer> result = new HashMap<>();

        char[] chars = text.toCharArray();

        for (char ch : chars){
            if(!result.containsKey(ch)){
                result.put(ch, 0);
            }
            int newAmount = result.get(ch) + 1;
            result.put(ch, newAmount);
        }
        return result;
    }

    public static Map<String, Integer> countWords (String text){
        Map<String, Integer> result = new HashMap<>();

        String[] words = text.split(" ");

        for (String word : words){
            if(word.length() < 2){
                continue;
            }
            if (!result.containsKey(word)){
                result.put(word, 0);
            }
            int newAmount = result.get(word) + 1;
            result.put(word, newAmount);
        }
        return result;
    }
}
