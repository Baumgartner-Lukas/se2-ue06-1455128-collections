package trainTimetable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Station {
    private final String name;
    private List<Stop> stops;

    public Station(String name) {
        this.name = name;
        stops = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name;
    }

    public void addStop(Stop stop){
        stops.add(stop);
    }

    public String getStopsByTime(){
        StringBuilder stopsByTime = new StringBuilder();
        stopsByTime.append(String.format("Station: %s %n", name));
        Collections.sort(stops, Comparator.comparing(Stop::getTime));
        for(Stop s : stops){
            stopsByTime.append(String.format(" %s %n", s));
        }
        return String.valueOf(stopsByTime);
    }

    public String getStopsByPlatform(){
        StringBuilder stopsByPlatform = new StringBuilder();
        stopsByPlatform.append(String.format("Station: %s %n", name));
        Collections.sort(stops, Comparator.comparingInt(Stop::getPlatform));
        for(Stop s : stops){
            stopsByPlatform.append(String.format(" %s %n", s));
        }
        return String.valueOf(stopsByPlatform);
    }
}
