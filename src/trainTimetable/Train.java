package trainTimetable;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Train {
    private final String name;
    private TreeSet<Stop> stops;

    public Train(String name) {
        this.name = name;
        this.stops = new TreeSet<>();
    }

    /**
     * Adds a new Stop to the Treeset stops.
     * Sorts the stops by time (earliest first)
     * @param newStop
     */
    public void addStop(Stop newStop){
        stops.add(newStop);
    }

    /**
     * Gets the origin Trainstation (sorted by time -> the earliest)
     * @return the origin Trainstation
     */
    public Stop getFirstStop(){
        return stops.first();
    }

    /**
     * Gets the destination Trainstation (sorted by time -> the latest)
     * @return the destination Trainstation
     */
    public Stop getLastStop(){
        return stops.last();
    }

    /**
     * Gets all stops of the train (sorted from earliest to latest)
     * @return the set of stops
     */
    public Set<Stop> getAllStops(){
        return stops;
    }

    /**
     * Gets all stop from a given Stop (from earliest to latest)
     * @param from name of the Stop from where the other stops are returned
     * @return a set of Stops from the given Stop
     */
    public Set<Stop> getStopsFrom(String from){
        //ToDo
        return null;

    }

    @Override
    public String toString() {
        return "Train: " + name + '\n' +
                "   Stops" + stops;
    }
}
