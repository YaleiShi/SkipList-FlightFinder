package skipLists;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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

		try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
			String line = reader.readLine();
			while(line != null){
				String[] words = line.split(" ");
				FlightKey newKey = new FlightKey(words[0], words[1], words[2], words[3]);
				FlightData newData = new FlightData(words[4], Double.parseDouble(words[5]));
				insert(newKey, newData);
				line = reader.readLine();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}

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
		while(current.getKey() != tail.getKey()){
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
        while(current.getKey() != tail.getKey()){
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
		FlightKey max = new FlightKey(key);
		max.setTime("24:00");
		FlightNode current = head;
		while(current.getKey() != tail.getKey()){
			if(current.getNext().getKey().compareTo(key) > 0){
				if(current.getDown() == null) break;
				current = current.getDown();
			}else {
				current = current.getNext();
			}
		}

		//we hit the bottom
		while(current.getKey() != tail.getKey()){
			if(current.getKey().compareTo(max) > 0) break;
			if(current.getKey().compareTo(key) > 0) arr.add(current);
			current = current.getNext();
		}
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
		FlightKey min = new FlightKey(key);
		String time = key.getTime();
		int hour = Integer.parseInt(time.substring(0,2));
		int minHour = hour - timeFrame;
		String minTime;
		if(minHour < 10){
			minTime = "0" + minHour + time.substring(2);
		}else {
			minTime = minHour + time.substring(2);
		}
		min.setTime(minTime);
		FlightNode current = tail;
		while(current.getKey() != head.getKey()){
			if(current.getPrev().getKey().compareTo(key) < 0){
				if(current.getDown() == null) break;
				current = current.getDown();
			}else {
				current = current.getPrev();
			}
		}

		//we hit the bottom
		while(current.getKey() != head.getKey()){
			if(current.getKey().compareTo(min) < 0) break;
			if(current.getKey().compareTo(key) < 0) arr.add(current);
			current = current.getPrev();
		}
        Collections.reverse(arr);
        return arr;

	}

	/**
	 * Prints the SkipList (prints the elements on all levels starting at the
	 * top. Each level should be printed on a separate line.
	 */
	public void print() {
        System.out.println(toString(head));
	}

	public String toString(FlightNode root){
	    FlightNode current = root;
	    current = current.getNext();
	    String s = "";
	    while(current.getKey() != tail.getKey()){
	        s = s + current.getKey().toString();
	        current = current.getNext();
        }
        s = s + "\n";
	    if(root.getDown() != null) s = s + toString(root.getDown());
	    return s;
    }

	/**
	 * Outputs the SkipList to a file
	 *(prints the elements on all levels starting at the top.
	 * Each level should be printed on a separate line.
	 * @param filename the name of the file
	 */
	public void print(String filename) {
		// FILL IN CODE
		try(PrintWriter pw = new PrintWriter(filename)){
			pw.write(toString(head));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
		String time = key.getTime();
		int hour = Integer.parseInt(time.substring(0, 2));
		String minute = time.substring(2);
		int maxHour = hour + timeFrame;
		int minHour = hour - timeFrame;
		String max;
		if(maxHour < 10){
			max = "0" + maxHour + minute;
		}else {
			max = maxHour + minute;
		}
		String min;
		if(minHour < 10){
			min = "0" + minHour + minute;
		}else {
			min = minHour + minute;
		}
		FlightKey maxKey = new FlightKey(key);
		FlightKey minKey = new FlightKey(key);
		maxKey.setTime(max);
		minKey.setTime(min);

		//search begin
		FlightNode current = head;
		while(current.getKey() != tail.getKey()){
			if(current.getNext().getKey().compareTo(minKey) > 0){
				if(current.getDown() == null) break;
				current = current.getDown();
			}else {
				current = current.getNext();
			}
		}

		//we hit the bottom
		while(current.getKey() != tail.getKey()){
			if(current.getKey().compareTo(maxKey) > 0) break;
			if(current.getKey().compareTo(minKey) > 0) resFlights.add(current);
			current = current.getNext();
		}
		for(FlightNode node: resFlights){
		    System.out.println(node.getKey().toString());
        }
		return resFlights;
	}

}
