package trainTimetable;

import java.util.Iterator;
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
    public String getFirstStop() {
        return String.format(" %s %n  %s", name, stops.first());
    }

    /**
     * Gets the destination Trainstation (sorted by time -> the latest)
     *
     * @return the destination Trainstation
     */
    public String getLastStop() {
        return String.format(" %s %n  %s", name, stops.last());
    }

    /**
     * Gets all stops of the train (sorted from earliest to latest)
     *
     * @return the set of stops
     */
    public String getAllStops() {
        StringBuilder allStops = new StringBuilder();
        allStops.append(String.format("%s %n", name));
        for(Stop s : stops){
            allStops.append(String.format(" %s %n", s));
        }
        return String.valueOf(allStops);
    }

    /**
     * Gets all stop from a given Stop (from earliest to latest)
     *
     * @param from name of the Stop from where the other stops are returned
     * @return a set of Stops from the given Stop
     */
    public String getStopsFrom(String from) {
        Iterator<Stop> itr = stops.iterator();
        StringBuilder stopsFrom = new StringBuilder();
        stopsFrom.append(String.format("Connections from %s %n", from));
        while(itr.hasNext()){
            Stop s = itr.next();
            if(s.getStation().getName().equals(from)){
                while(itr.hasNext()){
                    Stop stop = itr.next();
                    stopsFrom.append(String.format(" %s %n", stop));
                }
            }
        }
        return String.valueOf(stopsFrom);
    }

    @Override
    public String toString() {
        return "Train: " + name + '\n' +
                "   Stops" + stops;
    }
}
