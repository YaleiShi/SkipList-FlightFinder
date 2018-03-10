package skipLists;

import java.util.ArrayList;

/** The class that represents the flight database using a skip list */
public class FlightList {

	// FILL IN CODE: needs to store the head, the tail and the height of the skip
	// list

	/** Default constructor */
	public FlightList() {
		// FILL IN CODE

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
		return false; // don't forget to change it
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
		// FILL IN CODE
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
