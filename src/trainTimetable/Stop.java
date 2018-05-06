package trainTimetable;

public class Stop implements Comparable{
    private final String name;

    public Stop(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Stop){
            Stop stop = (Stop) o;
            return this.name.compareTo(stop.name);
        }else return -1;
    }

    @Override
    public String toString() {
        return "Stop: " + name;
    }
}
