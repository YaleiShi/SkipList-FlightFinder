package skipLists;

import java.util.Hashtable;
import java.util.TreeSet;

public class Driver {

    public static void main(String[] args) {
        FlightKey fk1 = new FlightKey("SF1", "JFK", "03/15/2018", "08:15");
        FlightKey fk2 = new FlightKey("SF2", "JFK", "03/15/2018", "08:15");
        FlightKey fk3 = new FlightKey("SF3", "JFL", "03/15/2018", "08:15");
        FlightKey fk4 = new FlightKey("SF4", "JFK", "03/16/2018", "08:15");
        FlightKey fk5 = new FlightKey("SF5", "JFK", "03/15/2019", "08:19");
        FlightKey fk6 = new FlightKey("SF6", "JFL", "03/15/2020", "08:19");
        FlightKey fk7 = new FlightKey("SF7", "JFK", "04/15/2018", "08:19");

        FlightNode fn1 = new FlightNode(fk1, null);
        FlightNode fn2 = new FlightNode(fk2, null);
        FlightNode fn3 = new FlightNode(fk3, null);
        FlightNode fn4 = new FlightNode(fk4, null);
        FlightNode fn5 = new FlightNode(fk5, null);
        FlightNode fn6 = new FlightNode(fk6, null);
        FlightNode fn7 = new FlightNode(fk7, null);

        FlightList fl = new FlightList();
        fl.insert(fk1, null);
        fl.insert(fk2, null);
        fl.insert(fk3, null);
        fl.insert(fk4, null);
        fl.insert(fk5, null);
        fl.insert(fk6, null);
        fl.insert(fk7, null);

        fl.print();
    }
}
