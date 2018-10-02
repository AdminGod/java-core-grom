package lessons.lesson28;

import java.util.ArrayList;
import java.util.Date;

public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, "test", "zzz", true, new Date());
        Capability capability2 = new Capability(1005, "test", "zzz", false, new Date());
        Capability capability3 = new Capability(600, "test", "zzz", true, new Date());
        Capability capability4 = new Capability(700, "test", "zzz", false, new Date());

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);
        capabilities.add(null);

        capabilities.sort(new DateComparator());

        System.out.println(capabilities);
    }
}
