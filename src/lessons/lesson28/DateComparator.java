package lessons.lesson28;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        if(o1 == null){
            return 1;
        }
        if(o2 == null){
            return -1;
        }
        if(o1.getDateCreated().getTime() < o2.getDateCreated().getTime()){
            return -1;
        }else if(o1.getDateCreated().getTime() > o2.getDateCreated().getTime()){
            return 1;
        }
        return 0;
    }
}
