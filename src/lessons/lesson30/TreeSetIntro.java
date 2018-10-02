package lessons.lesson30;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetIntro {
    public static void main(String[] args) {
        Set<File> files = new TreeSet<>();

        File f1 = new File("test1.txt", 100);
        File f2 = new File("home.txt", 178);
        File f3 = new File("home333.txt", 125);

        files.add(f1);
        files.add(f2);
        files.add(f3);

        System.out.println(files);
    }
}
