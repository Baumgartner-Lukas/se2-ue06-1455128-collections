import trainTimetable.Station;
import trainTimetable.Stop;
import trainTimetable.TimeTable;
import trainTimetable.Train;

public class Main {
    public static void main(String[] args) {
        TimeTable timeTable = new TimeTable();

        Station wien = new Station("Wien");
        Station stpoelten = new Station("St. Poelten");
        Station amstetten = new Station("Amstetten");
        Station stvalentin = new Station("St. Valentin");
        Station linz = new Station("Linz");
        Station wels = new Station("Wels");

        Train westbahn = new Train("Westbahn");
        Train oebb = new Train("OEBB");

        Stop westWien = new Stop(westbahn, wien, 1, "06:00");
        Stop westStpoelten = new Stop(westbahn, stpoelten, 2, "06:30");
        Stop westAmstetten = new Stop(westbahn, amstetten, 1, "07:00");
        Stop westLinz = new Stop(westbahn, linz, 7, "07:30");
        Stop westWels = new Stop(westbahn, wels, 3, "08:00");

        Stop oebbWien = new Stop(oebb, wien, 1, "06:01");
        Stop oebbStpoelten = new Stop(oebb, stpoelten, 1, "06:30");
        Stop oebbAmstetten = new Stop(oebb, amstetten, 2, "07:00");
        Stop oebbStValentin = new Stop(oebb, stvalentin, 1, "07:15");
        Stop oebbLinz = new Stop(oebb, linz, 8, "07:29");
        Stop oebbWels = new Stop(oebb, wels, 3, "07:59");

        timeTable.addStop(oebbWien);
        timeTable.addStop(oebbWels);
        timeTable.addStop(oebbWels);

        westbahn.addStop(westAmstetten);
        westbahn.addStop(westLinz);
        westbahn.addStop(westStpoelten);
        westbahn.addStop(westWels);
        westbahn.addStop(westWien);

        oebb.addStop(oebbAmstetten);
        oebb.addStop(oebbLinz);
        oebb.addStop(oebbStpoelten);
        oebb.addStop(oebbStValentin);
        oebb.addStop(oebbWels);
        oebb.addStop(oebbWien);

        wien.addStop(westWien);
        wien.addStop(oebbWien);
        stpoelten.addStop(westStpoelten);
        stpoelten.addStop(oebbStpoelten);
        amstetten.addStop(westAmstetten);
        amstetten.addStop(oebbAmstetten);
        stvalentin.addStop(oebbAmstetten);
        linz.addStop(westLinz);
        linz.addStop(oebbLinz);
        wels.addStop(westWels);
        wels.addStop(oebbAmstetten);

        System.out.println("Get first stop");
        System.out.printf(westbahn.getFirstStop() + "%n");

        System.out.println("Get last stop");
        System.out.printf(westbahn.getLastStop() + "%n");

        System.out.println("Get all stops");
        westbahn.getAllStops().forEach(System.out::println);

        System.out.println("Get stops from Amstetten");
        westbahn.getStopsFrom("Amstetten").forEach(System.out::println);

        System.out.println("Get stops of station by platform");
        linz.getStopsByPlatform().forEach(System.out::println);

        System.out.println("Get stops of station by time");
        linz.getStopsByTime().forEach(System.out::println);

        System.out.println("Get all trains for this station");
        wien.getAllTrainsForStation().forEach(System.out::println);
    }
}
