package skipLists;

/**
 * Represents the key in the FlightNode. Stores origin, destination, date and
 * time. Implements Comparable<FlightKey>.
 */
public class FlightKey implements Comparable<FlightKey> {
	// Each key is a tuple: origin, destination, date, time
	// FILL IN CODE
	private String origin;
	private String dest;
	private String date;
	private String time;

	/**
     *  FlightKey constructor
	 * @param or origin
	 * @param dest destination
	 * @param date date
	 * @param time time
	 */
    public FlightKey(String or, String dest, String date, String time) {
		// FILL IN CODE
		this.origin = or;
		this.dest = dest;
		this.date = date;
		this.time = time;
	}

	/**
     * FlightKey - copy constructor
	 * @param other the other FlightKey
	 */
	public FlightKey(FlightKey other) {
		// FILL IN CODE
		this.origin = other.origin;
		this.dest = other.dest;
		this.date = other.date;
		this.time = other.time;
	}

	// FILL IN CODE: Write getters for origin, destination, date and time

	/**
	 * the setters
	 * @param origin
	 */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

	/**
	 * the getters
	 * @return
	 */
	public String getOrigin() {
		return origin;
	}

	public String getDest() {
		return dest;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	/**
     * Compares a given flight key with the one given as a parameter.
	 * @param other
     * @return -1, if this key is < other, > -1 if the opposite, and 0 if equal.  </>
	 */
	public int compareTo(FlightKey other) {
		// FILL IN CODE
		if(this.origin.compareTo(other.origin) < 0) return -1;
		if(this.origin.compareTo(other.origin) > 0) return 1;

		if(this.dest.compareTo(other.dest) < 0) return -1;
		if(this.dest.compareTo(other.dest) > 0) return 1;

		if(this.date.compareTo(other.date) < 0) return -1;
		if(this.date.compareTo(other.date) > 0) return 1;

		if(this.time.compareTo(other.time) < 0) return -1;
		if(this.time.compareTo(other.time) > 0) return 1;

		return 0; // don't forget to change it
	}

	/**
     * Returns a string representation of the key
	 * @return String
	 */
	public String toString() {
		// FILL IN CODE
		return "(" + origin + "," + dest + "," + date + "," + time + ")"; // don't forget to change it
	}
}
