package trainTimetable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Station implements Comparable<Station>{
    private final String name;
    private List<Stop> stops;

    public Station(String name) {
        this.name = name;
        stops = new ArrayList<>();
    }

    public void addStop(Stop stop){
        stops.add(stop);
    }

    public List<Stop> getStopsByTime(){
        stops.sort(Comparator.comparing(Stop::getTime));
        return stops;
    }

    public List<Stop> getStopsByPlatform(){
        stops.sort(Comparator.comparingInt(Stop::getPlatform));
        return stops;
    }

    public List<Train> getAllTrainsForStation(){
        List<Train> trains = new ArrayList<>();
        for(Stop stop : stops){
            if(stop.getStation().getName().equals(this.name)){
                trains.add(stop.getTrain());
            }
        }
        trains.sort(Comparator.comparing(Train::getName));
        return trains;
    }

    @Override
    public int compareTo(Station other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Station){
            Station other = (Station) obj;
            return this.name.equals(other.name)
                    && this.stops.equals(other.stops);
        }
        return false;
    }

    @Override
    public String toString() {
        return  name;
    }

    String getName() {
        return name;
    }
}
