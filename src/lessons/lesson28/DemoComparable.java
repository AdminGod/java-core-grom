package lessons.lesson28;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class DemoComparable {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, "test", "zzz", true, new Date());
        Capability capability2 = new Capability(1005, "test", "zzz", true, new Date());
        Capability capability3 = new Capability(900, "test", "zzz", true, new Date());
        Capability capability4 = new Capability(500, "test", "zzz", true, new Date());
        Capability capability5 = new Capability(600, "test", "zzz", true, new Date());

        Set<Capability> set = new TreeSet<>();

        set.add(capability1);
        set.add(capability2);
        set.add(capability3);
        set.add(capability4);
        set.add(capability5);

        System.out.println(set);
    }
}
