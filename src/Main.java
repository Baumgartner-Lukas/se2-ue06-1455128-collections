import trainTimetable.Station;
import trainTimetable.Stop;
import trainTimetable.Train;

public  class Main {
    public static void main(String[] args){
        Train westbahn = new Train("Westbahn");
        Train oebb = new Train("ÖBB");
        Station amstetten = new Station("Amstetten");
        Stop wAmstetten = new Stop(westbahn, amstetten, 2, "07:01");
        Stop oAmstetten = new Stop(oebb, amstetten, 1, "06:59");

        westbahn.addStop(wAmstetten);
        westbahn.addStop(oAmstetten);

        System.out.println(westbahn);
    }
}
