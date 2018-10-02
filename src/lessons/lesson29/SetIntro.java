package lessons.lesson29;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetIntro {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("firstStr");
        System.out.println(set);
        set.add("111");
        set.add("aaa");
        set.add("sdfgaaa");
        set.add("aaa");
        System.out.println(set);

        Set<File> files = new HashSet<>();

        File f1 = new File("test1.txt", 100);
        File f2 = new File("home.txt", 178);
        File f3 = new File("home.txt", 178);

        files.add(f1);
        files.add(f2);
        files.add(f3);

        System.out.println(files);

    }
}
