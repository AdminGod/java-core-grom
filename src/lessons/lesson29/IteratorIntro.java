package lessons.lesson29;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorIntro {
    public static void main(String[] args) {
        Set<File> files = new HashSet<>();

        File f1 = new File("test1.txt", 100);
        File f2 = new File("home.txt", 178);
        File f3 = new File("home333.txt", 178);

        files.add(f1);
        files.add(f2);
        files.add(f3);

        Iterator<File> fileIterator = files.iterator();

        while(fileIterator.hasNext()) {
            System.out.println(fileIterator.next().getFileName());
        }
    }
}
