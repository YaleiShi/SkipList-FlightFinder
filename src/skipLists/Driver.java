package skipLists;

import java.util.Hashtable;
import java.util.TreeSet;

public class Driver {

    public static void main(String[] args) {
        FlightKey fk1 = new FlightKey("SFO", "JFK", "03/15/2018", "08:15");
        FlightKey fk2 = new FlightKey("SFP", "JFK", "03/15/2018", "08:15");
        FlightKey fk3 = new FlightKey("SFO", "JFL", "03/15/2018", "08:15");
        FlightKey fk4 = new FlightKey("SFO", "JFK", "03/16/2018", "08:15");
        FlightKey fk5 = new FlightKey("SFO", "JFK", "03/15/2019", "08:19");
        FlightKey fk6 = new FlightKey("SFO", "JFL", "03/15/2020", "08:19");
        FlightKey fk7 = new FlightKey("SFP", "JFK", "04/15/2018", "08:19");

        TreeSet<FlightKey> ts = new TreeSet<>();
        ts.add(fk1);
        ts.add(fk2);
        ts.add(fk3);
        ts.add(fk4);
        ts.add(fk5);
        ts.add(fk6);
        ts.add(fk7);

        for(FlightKey fk: ts){
            fk.toString();
        }
    }
}
