package boardgame;



public class StartSquare extends Square {

	// constants

	public static final int pass_GO_VALUE = 200;

	// instance vars
	private double passGoValue;

	// constructors
	/**
	 * Default constructor
	 */
	public StartSquare() {

	}

	// methods

	/**
	 * 
	 * @return pass go value as a double
	 */
	public double getPassGoValue() {
		return passGoValue;
	}

	/**
	 * 
	 * @param passGoValue sets pass go Value
	 */
	public void setPassGoValue() {
		this.passGoValue = pass_GO_VALUE;
	}

	/**
	 * player class.increase current player balance by pass go value
	 */
	public static void LandOnStartSquare() {
		Game.getCurrentPlayer().setBalance(Game.getCurrentPlayer().getBalance()+ pass_GO_VALUE);
		Game.getCurrentPlayer().setPosition(Game.getCurrentPlayer().getPosition()-12);
		System.out.println("Passed GO collect: "+ pass_GO_VALUE+ "!");
		System.out.println("Well done " + Game.getCurrentPlayer().getName()
				+ " your new balance is: " + Game.getCurrentPlayer().getBalance());	

	}

	@Override
	public void displayAll() {
		System.out.println("Square Name                   : " + this.getSquareName());
		System.out.println("You have just recieved        :" + this.passGoValue);
		
	}
	
	

}

