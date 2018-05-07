package trainTimetable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Stop implements Comparable<Stop> {
    private final Train train;
    private final Station station;
    private final int platform;
    private final LocalTime time;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public Stop(Train train, Station station, int platform, String time) {
        this.train = train;
        this.station = station;
        this.platform = platform;
        this.time = LocalTime.from(formatter.parse(time));
    }

    @Override
    public int compareTo(Stop other){
        int compare = this.time.compareTo(other.time);
        if(compare == 0){
            compare = this.platform - other.platform;
        }
        return compare;
    }

    Station getStation() {
        return station;
    }

    LocalTime getTime(){
        return time;
    }

    int getPlatform() {
        return platform;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Stop){
            Stop other = (Stop) obj;
            return this.train.equals(other.train)
                    && this.station.equals(other.station)
                    && this.time.equals(other.time)
                    && this.platform == other.platform;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + time + " " + station.toString() + "(" + platform + ")";
    }
}
