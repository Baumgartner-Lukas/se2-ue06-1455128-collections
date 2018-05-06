package trainTimetable;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private final String name;
    private List<Stop> stops;

    public Station(String name) {
        this.name = name;
        stops = new ArrayList<>();
    }
}
