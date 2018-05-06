import trainTimetable.Stop;
import trainTimetable.Train;

public  class Main {
    public static void main(String[] args){
        Train test = new Train("Bemp");
        test.addStop(new Stop("TestStop"));

        System.out.println(test);
    }
}
