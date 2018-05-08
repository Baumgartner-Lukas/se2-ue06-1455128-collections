package trainTimetable;

import java.util.Comparator;

public class StopComparator implements Comparator<Stop> {
    @Override
    public int compare(Stop s1, Stop s2) {
        int compare = s1.getStation().getName().compareTo(s2.getStation().getName());
        if(compare == 0){
            compare = s1.getTrain().getName().compareTo(s2.getTrain().getName());
        }
        return compare;
    }
}
