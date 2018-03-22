package skipLists;

import java.util.ArrayList;
import java.util.Random;

/** The class that represents the flight database using a skip list */
public class FlightList {
	private FlightNode head;
	private FlightNode tail;
	private int height;
	private Random random;

	// FILL IN CODE: needs to store the head, the tail and the height of the skip
	// list

	/** Default constructor */
	public FlightList() {
		// FILL IN CODE
		FlightKey leftKey = new FlightKey("AAA", "", "","");
		FlightKey rightKey = new FlightKey("ZZZ", "", "", "");
		FlightNode left = new FlightNode(leftKey, null);
		FlightNode right = new FlightNode(rightKey,null);
		left.setNext(right);
		right.setPrev(left);
		head = left;
		tail = right;
		height = 0;
		random = new Random();

	}

	/**
	 * Constructor.
	 * Reads flight data from the file and inserts it into this skip list.
	 * @param filename the name of he file
	 */
	public FlightList(String filename) {
		// FILL IN CODE
	}

	/**
	 * Returns true if the node with the given key exists in the skip list,
	 * false otherwise. This method needs to be efficient.
	 * 
	 * @param key flight key
	 * @return true if the key is in the skip list, false otherwise
	 */
	public boolean find(FlightKey key) {
		// FILL IN CODE
		FlightNode current = head;
		while(current != tail){
			if(current.getNext().getKey().compareTo(key) > 0){
				if(current.getDown() == null) return false;
				current = current.getDown();
			}else if(current.getNext().getKey().compareTo(key) == 0){
				return true;
			}else {
				current = current.getNext();
			}

		}
		return false; // don't forget to change it
	}

	/**
	 * Insert a (key, value) pair to the skip list. Returns true if it was able
	 * to insert.
	 *
	 * @param key flight key
	 * @param data associated flight data
	 * @return true if insertion was successful
	 */
	public boolean insert(FlightKey key, FlightData data) {
		// FILL IN CODE
        //decide the new tower height
        int h = -1;
        do{
            h++;
        }while(random.nextBoolean());

        int dif = h - height;
        for(int i = 0; i < dif; i++) setNewLevel();

        int nowLevel = height;

        FlightNode[] flightNodes = new FlightNode[h + 1];
        int j = 0;
        FlightNode current = head;
        while(current != tail){
            if(current.getNext().getKey().compareTo(key) >= 0){
                if(nowLevel <= h){
                    flightNodes[j] = current;
                    j++;
                }
                if(current.getDown() == null) break;
                current = current.getDown();
                nowLevel--;
            }else {
                current = current.getNext();
            }
        }

        //build the tower
        FlightNode towerTop = new FlightNode(key, data);
        FlightNode prev = flightNodes[0];
        FlightNode next = prev.getNext();
        helpInsert(towerTop, prev, next);
        FlightNode up = towerTop;
        FlightNode down;
        for(int i = 1; i <= h; i++){
            FlightNode newNode = new FlightNode(key, data);
            prev = flightNodes[i];
            next = prev.getNext();
            helpInsert(newNode, prev, next);
            down = newNode;
            down.setUp(up);
            up.setDown(down);
            up = newNode;
        }
		return true; // don't forget to change it
	}

    public void setNewLevel(){
	    FlightNode newHead = new FlightNode(head);
	    FlightNode newTail = new FlightNode(tail);
	    newHead.setNext(newTail);
	    newTail.setPrev(newHead);
	    newHead.setDown(head);
	    head.setUp(newHead);
	    newTail.setDown(tail);
	    tail.setUp(newTail);
	    head = newHead;
	    tail = newTail;
	    height++;
    }

	public void helpInsert(FlightNode middle, FlightNode prev, FlightNode next){
		prev.setNext(middle);
		middle.setPrev(prev);
		middle.setNext(next);
		next.setPrev(middle);
	}

	/**
	 * Returns the list of nodes that are successors of a given key. Refer to
	 * the project pdf for a detailed description of the method.
	 * 
	 * @param key flight key
	 * @return successors of the given key
	 */
	public ArrayList<FlightNode> successors(FlightKey key) {
		ArrayList<FlightNode> arr = new ArrayList<FlightNode>();
		// FILL IN CODE

		return arr;
	}

	/**
	 * Returns the list of nodes that are predecessors of a given key
	 * (that corresponds to flights that are earlier than the given flight).
	 *  Refer to the project pdf for a detailed description of the method.
	 * 
	 * @param key flight key
	 * @return predecessors of the given key
	 */
	public ArrayList<FlightNode> predecessors(FlightKey key, int timeFrame) {
		ArrayList<FlightNode> arr = new ArrayList<FlightNode>();
		// FILL IN CODE
		return arr;

	}

	/**
	 * Prints the SkipList (prints the elements on all levels starting at the
	 * top. Each level should be printed on a separate line.
	 */
	public void print() {
        print(head);
	}

	public void print(FlightNode root){
	    FlightNode current = root;
	    current = current.getNext();
	    while(current.getKey() != tail.getKey()){
	        System.out.print(current.getKey().toString());
	        current = current.getNext();
        }
        System.out.println();
	    if(root.getDown() != null) print(root.getDown());
    }

	/**
	 * Outputs the SkipList to a file
	 *(prints the elements on all levels starting at the top.
	 * Each level should be printed on a separate line.
	 * @param filename the name of the file
	 */
	public void print(String filename) {
		// FILL IN CODE
	}

	/**
	 * Returns a list of nodes that have the same origin and destination cities
	 * and the same date as the key, with departure times within the given time
	 * frame of the departure time of the key.
	 *
	 * @param key flight key
	 * @param timeFrame interval of time
	 * @return list of flight nodes that have the same origin, destination and date
	 * as the key, and whose departure time is within a given timeframe
	 */
	public ArrayList<FlightNode> findFlights(FlightKey key, int timeFrame) {
		ArrayList<FlightNode> resFlights = new ArrayList<FlightNode>();
		// FILL IN CODE

		return resFlights;
	}

}
