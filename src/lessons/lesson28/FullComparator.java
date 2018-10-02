package lessons.lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        if(o1 == null){
            return 1;
        }
        if(o2 == null){
            return -1;
        }
        if(!o1.getChannelName().equals(o2.getChannelName())){
            return o1.getChannelName().compareTo(o2.getChannelName());
        }
        if(!o1.getFingerPrint().equals(o2.getFingerPrint())){
            return o1.getFingerPrint().compareTo(o2.getFingerPrint());
        }
        if(!o1.getDateCreated().toString().equals(o2.getDateCreated().toString())){
            return o1.getDateCreated().toString().compareTo(o2.getDateCreated().toString());
        }
        return 0;
    }
}
