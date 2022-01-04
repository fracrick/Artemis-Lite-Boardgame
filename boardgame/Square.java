/**
 * 
 */
package boardgame;

/**
 * @author Paul Mellon
 *
 */
public abstract class Square {
	// instance vars 
	/**
	 * 
	 */
	private String squareName;

	/**
	 * Default constructor
	 */
	public Square() {
		// TODO Auto-generated constructor stub
	}

	public Square(String squareName) {
		this.squareName = squareName;
	}

	/**
	 * @return the squareName
	 */
	public String getSquareName() {
		return squareName;
	}

	/**
	 * @param squareName
	 *            
	 */
	public void setSquareName(String squareName) {
		this.squareName = squareName;
	}
	
	public void displayAll() {
		System.out.println("Square Name: " + this.squareName);
		
	}
	
	
	

}


