/**
 * 
 */
package boardgame;

/**
 * @author paulmellon
 *
 */
public class BlankSquare extends Square {

	
	// constructor
	public BlankSquare() {
		
	}
	
	public BlankSquare(String squareName) {
		super(squareName);
	}
	
	@Override
	public void displayAll() {
		System.out.println("Square Name                   : " + this.getSquareName());
	
	}
}
