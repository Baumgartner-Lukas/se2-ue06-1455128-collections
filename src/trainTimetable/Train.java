package trainTimetable;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Train{
    private final String name;
    private TreeSet<Stop> stops;

    public Train(String name) {
        this.name = name;
        this.stops = new TreeSet<>(new StopComparator()); // ???
    }

    /**
     * Adds a new Stop to the Treeset stops.
     * Sorts the stops by time (earliest first)
     *
     * @param newStop
     */
    public void addStop(Stop newStop) {
        stops.add(newStop);
    }

    /**
     * Gets the origin Trainstation (sorted by time -> the earliest)
     *
     * @return the origin Trainstation
     */
    public Stop getFirstStop() {
        return stops.first();
    }

    /**
     * Gets the destination Trainstation (sorted by time -> the latest)
     *
     * @return the destination Trainstation
     */
    public Stop getLastStop() {
        return stops.last();
    }

    /**
     * Gets all stops of the train (sorted from earliest to latest)
     *
     * @return the set of stops
     */
    public Set<Stop> getAllStops() {
        return stops;
    }

    /**
     * Gets all stop from a given Stop (from earliest to latest)
     *
     * @param from name of the Stop from where the other stops are returned
     * @return a set of Stops from the given Stop
     */
    public Set<Stop> getStopsFrom(String from) {
        Iterator<Stop> itr = stops.iterator();
        TreeSet<Stop> stopsFrom = new TreeSet<>();
        //StringBuilder stopsFrom = new StringBuilder();
        //stopsFrom.append(String.format("Connections from %s %n", from));
        while (itr.hasNext()) {
            Stop s = itr.next();
            if (s.getStation().getName().equals(from)) {
                while (itr.hasNext()) {
                    stopsFrom.add(itr.next());
                }
            }
        }
        return stopsFrom;
    }


    @Override
    public String toString() {
        return "  " + name;
    }

    String getName() {
        return name;
    }

}
