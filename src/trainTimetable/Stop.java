package trainTimetable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Stop implements Comparable {
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
    public int compareTo(Object o) {
        //ToDo: Compare Time first, if eqaul compare platform
        if (o instanceof Stop) {
            Stop stop = (Stop) o;
            return this.time.compareTo(stop.time);
        } else return -1;
    }

    @Override
    public String toString() {
        return "" + time + " " + station.toString() + "(" + platform + ")";
    }
}
