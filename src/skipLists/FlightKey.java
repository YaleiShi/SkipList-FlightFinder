package skipLists;

/**
 * Represents the key in the FlightNode. Stores origin, destination, date and
 * time. Implements Comparable<FlightKey>.
 */
public class FlightKey implements Comparable<FlightKey> {
	// Each key is a tuple: origin, destination, date, time
	// FILL IN CODE

	/**
     *  FlightKey constructor
	 * @param or origin
	 * @param dest destination
	 * @param date date
	 * @param time time
	 */
    public FlightKey(String or, String dest, String date, String time) {
		// FILL IN CODE

	}

	/**
     * FlightKey - copy constructor
	 * @param other the other FlightKey
	 */
	public FlightKey(FlightKey other) {
		// FILL IN CODE

	}

	// FILL IN CODE: Write getters for origin, destination, date and time

	/**
     * Compares a given flight key with the one given as a parameter.
	 * @param other
     * @return -1, if this key is < other, > -1 if the opposite, and 0 if equal.  </>
	 */
	public int compareTo(FlightKey other) {
		// FILL IN CODE
		return 0; // don't forget to change it
	}

	/**
     * Returns a string representation of the key
	 * @return String
	 */
	public String toString() {
		// FILL IN CODE
		return ""; // don't forget to change it
	}
}
