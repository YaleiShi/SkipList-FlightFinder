package skipLists;

/**
 * The class that represents a node in a flight skip list. 
 * Contains the key of type FlightKey and the data of type FlightData. 
 * Also stores the following pointers to FlightNode(s): next, down, prev and up.
 */
public class FlightNode {

	// FILL IN CODE, declare instance variables (make them private)
	private FlightKey key;
	private FlightData data;
	private FlightNode next;
	private FlightNode down;
	private FlightNode prev;
	private FlightNode up;

	/**
     * Copy constructor for FlightNode
	 * @param node FlightNode
	 */
	public FlightNode(FlightNode node) {
		// FILL IN CODE
		this.key = node.key;
		this.key = node.key;
		this.next = node.next;
		this.down = node.down;
		this.prev = node.prev;
		this.up = node.up;

	}

	/**
     * FlightNode Constructor
	 * @param key flight key
	 * @param data fight daya
	 */
	public FlightNode(FlightKey key, FlightData data) {
		// FILL IN
		this.key = key;
		this.data = data;
		this.next = null;
		this.down = null;
		this.up = null;
		this.prev = null;
	}

	// FILL IN CODE: write getters and setters for all private


	public void setKey(FlightKey key) {
		this.key = key;
	}

	public void setData(FlightData data) {
		this.data = data;
	}

	public void setNext(FlightNode next) {
		this.next = next;
	}

	public void setDown(FlightNode down) {
		this.down = down;
	}

	public void setPrev(FlightNode prev) {
		this.prev = prev;
	}

	public void setUp(FlightNode up) {
		this.up = up;
	}

	public FlightData getData() {
		return data;
	}

	public FlightNode getNext() {
		return next;
	}

	public FlightNode getPrev() {
		return prev;
	}

	public FlightNode getDown() {
		return down;
	}

	public FlightNode getUp() {
		return up;
	}

	/**
     * A getter for the key
	 * @return key
	 */
	public FlightKey getKey() {
		// FILL IN CODE
		return key; // don't forget to change it
	}

}
