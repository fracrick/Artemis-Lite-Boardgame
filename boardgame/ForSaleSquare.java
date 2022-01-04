/**
 * 
 */
package boardgame;

import java.util.Scanner;

/**
 * @author paulmellon
 *
 */
public class ForSaleSquare extends Square {

	// instamce vars
	private double squarePrice;
	private boolean isOwned;
	private String systemName;
	private String squareOwner;
	private int developments;
	private int majorDevelopments;
	private double developmentPrice;
	private double majorDevelopmentPrice;
	private double trainingCost;
	private double developmentPremium;
	private double majorDevelopmentPremium;
	private String description;

	// constructors
	/**
	 * Default constructor
	 */
	public ForSaleSquare() {

	}

	/**
	 * Constructor with args
	 * 
	 * @param squareName
	 * @param squarePrice
	 * @param isOwned
	 * @param systemName
	 * @param squareOwner
	 * @param developments
	 * @param majorDevelopments
	 * @param developmentPrice
	 * @param majorDevelopmentPrice
	 * @param trainingCost
	 * @param developmentPremium
	 * @param majorDevelopmentPremium
	 * @param description
	 */
	public ForSaleSquare(String squareName, double squarePrice, boolean isOwned, String systemName, String squareOwner,
			int developments, int majorDevelopments, double developmentPrice, double majorDevelopmentPrice,
			double trainingCost, double developmentPremium, double majorDevelopmentPremium, String description) {
		super(squareName);
		this.squarePrice = squarePrice;
		this.isOwned = isOwned;
		this.systemName = systemName;
		this.squareOwner = squareOwner;
		this.developments = developments;
		this.majorDevelopments = majorDevelopments;
		this.developmentPrice = developmentPrice;
		this.majorDevelopmentPrice = majorDevelopmentPrice;
		this.trainingCost = trainingCost;
		this.developmentPremium = developmentPremium;
		this.majorDevelopmentPremium = majorDevelopmentPremium;
		this.description = description;
	}

	public double getSquarePrice() {
		return squarePrice;
	}

	public void setSquarePrice(double squarePrice) {
		this.squarePrice = squarePrice;
	}

	public boolean isOwned() {
		return isOwned;
	}

	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getSquareOwner() {
		return squareOwner;
	}

	public void setSquareOwner(String squareOwner) {
		this.squareOwner = squareOwner;
	}

	public int getDevelopments() {
		return developments;
	}

	public void setDevelopments(int developments) {
		this.developments = developments;
	}

	public int getMajorDevelopments() {
		return majorDevelopments;
	}

	public void setMajorDevelopments(int majorDevelopments) {
		this.majorDevelopments = majorDevelopments;
	}

	public double getDevelopmentPrice() {
		return developmentPrice;
	}

	public void setDevelopmentPrice(double developmentPrice) {
		this.developmentPrice = developmentPrice;
	}

	public double getMajorDevelopmentPrice() {
		return majorDevelopmentPrice;
	}

	public void setMajorDevelopmentPrice(double majorDevelopmentPrice) {
		this.majorDevelopmentPrice = majorDevelopmentPrice;
	}

	public double getTrainingCost() {
		return trainingCost;
	}

	public void setTrainingCost(double trainingCost) {
		this.trainingCost = trainingCost;
	}

	public double getDevelopmentPremium() {
		return developmentPremium;
	}

	public void setDevelopmentPremium(double developmentPremium) {
		this.developmentPremium = developmentPremium;
	}

	public double getMajorDevelopmentPremium() {
		return majorDevelopmentPremium;
	}

	public void setMajorDevelopmentPremium(double majorDevelopmentPremium) {
		this.majorDevelopmentPremium = majorDevelopmentPremium;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void displayAll() {
		System.out.println("Square Name                   : " + this.getSquareName());
		System.out.println("Owner                         : " + this.getSquareOwner());
		System.out.println("Description                   :" + this.getDescription());
		System.out.println("Price: " + this.getSquarePrice() + " Cost of Development :" + this.getDevelopmentPrice()
				+ " Cost of Major Development: " + this.getMajorDevelopmentPrice());
		System.out.println("Training increase per Development: " + this.getMajorDevelopmentPremium()
				+ " Training increase per major Development :" + this.getMajorDevelopmentPremium());
		System.out.println("Currently built here are:    Number of Developments:" + this.getDevelopments()
				+ "   Number of Major Developments: " + this.getMajorDevelopments());

	}

	/**
	 * How to purchase square
	 */
	public static void purchaseSquare() {
		String userResponse;
		Scanner scanner = new Scanner(System.in);
		if (Game.getCurrentPlayer().getBalance() > Game.getSquareLandedOn().getSquarePrice()) {
			System.out.println("Would you like to buy the square?");
			userResponse = scanner.nextLine();
			if (userResponse.equalsIgnoreCase("Y")) {
				Game.getSquareLandedOn().setSquareOwner(Game.getCurrentPlayer().getName());
				Game.getSquareLandedOn().setOwned(true);
				Game.getCurrentPlayer()
						.setBalance(Game.getCurrentPlayer().getBalance() - Game.getSquareLandedOn().getSquarePrice());
				System.out.println("Well done " + Game.getCurrentPlayer().getName() + " your new balance is: "
						+ Game.getCurrentPlayer().getBalance());
			} else if (userResponse.equalsIgnoreCase("N")) {
				System.out.println("Square not purchased");
			}
		}

	}

	public static void createDeveleopment() {

		String userResponse;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to develop the Squares you own? Press Y to develop, N to end turn");
		userResponse = scanner.nextLine();
		if (userResponse.equalsIgnoreCase("y")) {
			for (int loop = 0; loop < Game.squares.length; loop++) {

				if (Game.squares[0].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[1].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[2].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())

						&& Game.squares[0].getDevelopments() < 3
						&& Game.getCurrentPlayer().getBalance() > Game.squares[0].getDevelopmentPrice()) {
					Game.squares[0].setDevelopments(Game.squares[0].getDevelopments() + 1);
					Game.squares[0].setTrainingCost(Game.squares[0].getTrainingCost()
							+ Game.squares[0].getDevelopments() * Game.squares[0].getDevelopmentPremium());
					Game.getCurrentPlayer()
							.setBalance(Game.getCurrentPlayer().getBalance() - Game.squares[0].getDevelopmentPrice());
					System.out.println("Well done " + Game.getCurrentPlayer().getName()
							+ " you have created 1 development on " + Game.squares[0].getSquareName()
							+ " and your new balance is: " + Game.getCurrentPlayer().getBalance());
					break;

				} else if (Game.squares[0].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[1].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[2].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[1].getDevelopments() < 3
						&& Game.getCurrentPlayer().getBalance() > Game.squares[1].getDevelopmentPrice()) {
					Game.squares[1].setDevelopments(Game.squares[1].getDevelopments() + 1);
					Game.squares[1].setTrainingCost(Game.squares[1].getTrainingCost()
							+ Game.squares[1].getDevelopments() * Game.squares[1].getDevelopmentPremium());
					Game.getCurrentPlayer()
							.setBalance(Game.getCurrentPlayer().getBalance() - Game.squares[1].getDevelopmentPrice());
					System.out.println("Well done " + Game.getCurrentPlayer().getName()
							+ " you have created 1 development on " + Game.squares[1].getSquareName()
							+ " and your new balance is: " + Game.getCurrentPlayer().getBalance());
					break;
				} else if (Game.squares[0].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[1].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[2].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[2].getDevelopments() < 3
						&& Game.getCurrentPlayer().getBalance() > Game.squares[2].getDevelopmentPrice()) {
					Game.squares[2].setDevelopments(Game.squares[2].getDevelopments() + 1);
					Game.squares[2].setTrainingCost(Game.squares[2].getTrainingCost()
							+ Game.squares[2].getDevelopments() * Game.squares[2].getDevelopmentPremium());
					Game.getCurrentPlayer()
							.setBalance(Game.getCurrentPlayer().getBalance() - Game.squares[2].getDevelopmentPrice());
					System.out.println("Well done " + Game.getCurrentPlayer().getName()
							+ " you have created 1 development on " + Game.squares[2].getSquareName()
							+ " and your new balance is: " + Game.getCurrentPlayer().getBalance());
					break;
				} else if (Game.squares[3].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[4].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[5].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[3].getDevelopments() < 3
						&& Game.getCurrentPlayer().getBalance() > Game.squares[3].getDevelopmentPrice()) {
					Game.squares[3].setDevelopments(Game.squares[3].getDevelopments() + 1);
					Game.squares[3].setTrainingCost(Game.squares[3].getTrainingCost()
							+ Game.squares[3].getDevelopments() * Game.squares[3].getDevelopmentPremium());
					Game.getCurrentPlayer()
							.setBalance(Game.getCurrentPlayer().getBalance() - Game.squares[3].getDevelopmentPrice());
					System.out.println("Well done " + Game.getCurrentPlayer().getName()
							+ " you have created 1 development on " + Game.squares[3].getSquareName()
							+ " and your new balance is: " + Game.getCurrentPlayer().getBalance());
					break;

				} else if (Game.squares[3].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[4].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[5].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[4].getDevelopments() < 3
						&& Game.getCurrentPlayer().getBalance() > Game.squares[4].getDevelopmentPrice()) {
					Game.squares[4].setDevelopments(Game.squares[4].getDevelopments() + 1);
					Game.squares[4].setTrainingCost(Game.squares[4].getTrainingCost()
							+ Game.squares[4].getDevelopments() * Game.squares[4].getDevelopmentPremium());
					Game.getCurrentPlayer()
							.setBalance(Game.getCurrentPlayer().getBalance() - Game.squares[4].getDevelopmentPrice());
					System.out.println("Well done " + Game.getCurrentPlayer().getName()
							+ " you have created 1 development on " + Game.squares[4].getSquareName()
							+ " and your new balance is: " + Game.getCurrentPlayer().getBalance());
					break;

				} else if (Game.squares[3].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[4].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[5].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[5].getDevelopments() < 3
						&& Game.getCurrentPlayer().getBalance() > Game.squares[5].getDevelopmentPrice()) {
					Game.squares[5].setDevelopments(Game.squares[5].getDevelopments() + 1);
					Game.squares[5].setTrainingCost(Game.squares[5].getTrainingCost()
							+ Game.squares[5].getDevelopments() * Game.squares[5].getDevelopmentPremium());
					Game.getCurrentPlayer()
							.setBalance(Game.getCurrentPlayer().getBalance() - Game.squares[5].getDevelopmentPrice());
					System.out.println("Well done " + Game.getCurrentPlayer().getName()
							+ " you have created 1 development on " + Game.squares[5].getSquareName()
							+ " and your new balance is: " + Game.getCurrentPlayer().getBalance());
					break;
				} else if (Game.squares[6].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[7].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[6].getDevelopments() < 3
						&& Game.getCurrentPlayer().getBalance() > Game.squares[6].getDevelopmentPrice()) {
					Game.squares[6].setDevelopments(Game.squares[6].getDevelopments() + 1);
					Game.squares[6].setTrainingCost(Game.squares[6].getTrainingCost()
							+ Game.squares[6].getDevelopments() * Game.squares[6].getDevelopmentPremium());
					Game.getCurrentPlayer()
							.setBalance(Game.getCurrentPlayer().getBalance() - Game.squares[6].getDevelopmentPrice());
					System.out.println("Well done " + Game.getCurrentPlayer().getName()
							+ " you have created 1 development on " + Game.squares[6].getSquareName()
							+ " and your new balance is: " + Game.getCurrentPlayer().getBalance());
					break;
				} else if (Game.squares[6].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[7].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[7].getDevelopments() < 3
						&& Game.getCurrentPlayer().getBalance() > Game.squares[6].getDevelopmentPrice()) {
					Game.squares[7].setDevelopments(Game.squares[7].getDevelopments() + 1);
					Game.squares[7].setTrainingCost(Game.squares[7].getTrainingCost()
							+ Game.squares[7].getDevelopments() * Game.squares[7].getDevelopmentPremium());
					Game.getCurrentPlayer()
							.setBalance(Game.getCurrentPlayer().getBalance() - Game.squares[7].getDevelopmentPrice());
					System.out.println("Well done " + Game.getCurrentPlayer().getName()
							+ " you have created 1 development on " + Game.squares[7].getSquareName()
							+ " and your new balance is: " + Game.getCurrentPlayer().getBalance());
					break;

				} else if (Game.squares[8].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[9].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[8].getDevelopments() < 3
						&& Game.getCurrentPlayer().getBalance() > Game.squares[8].getDevelopmentPrice()) {
					Game.squares[8].setDevelopments(Game.squares[8].getDevelopments() + 1);
					Game.squares[8].setTrainingCost(Game.squares[8].getTrainingCost()
							+ Game.squares[8].getDevelopments() * Game.squares[8].getDevelopmentPremium());
					Game.getCurrentPlayer()
							.setBalance(Game.getCurrentPlayer().getBalance() - Game.squares[8].getDevelopmentPrice());
					System.out.println("Well done " + Game.getCurrentPlayer().getName()
							+ " you have created 1 development on " + Game.squares[8].getSquareName()
							+ " and your new balance is: " + Game.getCurrentPlayer().getBalance());
					break;
				} else if (Game.squares[8].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[9].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
						&& Game.squares[9].getDevelopments() < 3
						&& Game.getCurrentPlayer().getBalance() > Game.squares[9].getDevelopmentPrice()) {
					Game.squares[9].setDevelopments(Game.squares[9].getDevelopments() + 1);
					Game.squares[9].setTrainingCost(Game.squares[9].getTrainingCost()
							+ Game.squares[9].getDevelopments() * Game.squares[9].getDevelopmentPremium());
					Game.getCurrentPlayer()
							.setBalance(Game.getCurrentPlayer().getBalance() - Game.squares[9].getDevelopmentPrice());
					System.out.println("Well done " + Game.getCurrentPlayer().getName()
							+ " you have created 1 development on " + Game.squares[9].getSquareName()
							+ " and your new balance is: " + Game.getCurrentPlayer().getBalance());
					break;
					// tweaked this
				} else if (Game.squares[loop].getDevelopments() == 3 && Game.squares[loop].getMajorDevelopments() < 1) {

					if ((Game.squares[loop].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
							&& Game.getCurrentPlayer().getBalance() > Game.squares[loop].getDevelopmentPrice())) {
						Game.squares[loop].setMajorDevelopments(Game.squares[loop].getMajorDevelopments() + 1);
						Game.squares[loop].setTrainingCost(Game.squares[loop].getTrainingCost()
								+ (Game.squares[loop].getDevelopments() * Game.squares[loop].getDevelopmentPremium())
								+ (Game.squares[loop].getMajorDevelopments()
										* Game.squares[loop].getMajorDevelopmentPremium()));
						Game.getCurrentPlayer().setBalance(
								Game.getCurrentPlayer().getBalance() - Game.squares[loop].getMajorDevelopmentPrice());

						// needs tidied up so to show the actual square they have created a major
						// development on.
						System.out.println("Well done " + Game.getCurrentPlayer().getName()
								+ " you have created 1 Major development on " + Game.squares[loop].getSquareName()
								+ " and your new balance is: " + Game.getCurrentPlayer().getBalance());
						break;
					} else if (Game.squares[0].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
					&& Game.squares[1].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
					&& Game.squares[2].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName()) && Game.squares[0].getMajorDevelopments()==1 &&
					Game.squares[1].getMajorDevelopments()==1 && Game.squares[2].getMajorDevelopments()==1) {
						System.out.println("System 1 is fully developed and ready for launch");
						break;
					} else if (Game.squares[3].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
					&& Game.squares[4].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
					&& Game.squares[5].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName()) && Game.squares[3].getMajorDevelopments()==1 &&
					Game.squares[4].getMajorDevelopments()==1 && Game.squares[5].getMajorDevelopments()==1) {
						System.out.println("System 2 is fully developed and ready for launch");
						break;
					} else if (Game.squares[6].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
					&& Game.squares[7].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
					&& Game.squares[6].getMajorDevelopments()==1 && Game.squares[7].getMajorDevelopments()==1) {
						System.out.println("System 3 is fully developed and ready for launch");
						break;
					} else if (Game.squares[8].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
							&& Game.squares[9].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
							&& Game.squares[8].getMajorDevelopments()==1 && Game.squares[9].getMajorDevelopments()==1) {
								System.out.println("System 4 is fully developed and ready for launch");
								break;
							} 

					
					
					
					
					
					/**
					 * } else if (Game.squares[loop].getDevelopments() == 3
						&& Game.squares[loop].getMajorDevelopments() == 1) {
					System.out.println(Game.getCurrentPlayer()
							+ " you have already created major developments on all the squares in your systems.. the other players must create Major developments on all their systems before Artemis is ready to launch");
				}
					 */
				
			}
		}
			
			System.out.println("Would you like to create another development on the systems you own? Press Y and enter to continue developing, N and enter to end turn.");
			String userResponse2;
			userResponse2 = scanner.nextLine();
			if (userResponse2.equalsIgnoreCase("y")) {
				for (int loop = 0; loop < Game.squares.length; loop++) {
				
			    if (Game.squares[0].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
					&& Game.squares[1].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
					&& Game.squares[2].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName()) && Game.squares[0].getMajorDevelopments()!=1 ||
					Game.squares[1].getMajorDevelopments()!=1 || Game.squares[2].getMajorDevelopments()!=1) {
			    	createDeveleopment();
			    	break;
						
					} else if (Game.squares[3].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
					&& Game.squares[4].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
					&& Game.squares[5].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName()) && Game.squares[3].getMajorDevelopments()!=1 ||
					Game.squares[4].getMajorDevelopments()!=1 || Game.squares[5].getMajorDevelopments()!=1) {
						createDeveleopment();
						break;
						
					} else if (Game.squares[6].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
					&& Game.squares[7].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
					&& Game.squares[6].getMajorDevelopments()!=1 || Game.squares[7].getMajorDevelopments()!=1) {
						createDeveleopment();
						break;
					} else if (Game.squares[8].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
							&& Game.squares[9].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
							&& Game.squares[8].getMajorDevelopments()!=1 || Game.squares[9].getMajorDevelopments()!=1) {
						createDeveleopment();
								break;
							}  else if (Game.squares[0].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
									&& Game.squares[1].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
									&& Game.squares[2].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName()) && Game.squares[0].getMajorDevelopments()==1 &&
									Game.squares[1].getMajorDevelopments()==1 && Game.squares[2].getMajorDevelopments()==1) {
										System.out.println("System 1 is fully developed and ready for launch");
										break;
									} else if (Game.squares[3].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
									&& Game.squares[4].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
									&& Game.squares[5].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName()) && Game.squares[3].getMajorDevelopments()==1 &&
									Game.squares[4].getMajorDevelopments()==1 && Game.squares[5].getMajorDevelopments()==1) {
										System.out.println("System 2 is fully developed and ready for launch");
										break;
									} else if (Game.squares[6].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
									&& Game.squares[7].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
									&& Game.squares[6].getMajorDevelopments()==1 && Game.squares[7].getMajorDevelopments()==1) {
										System.out.println("System 3 is fully developed and ready for launch");
										break;
									} else if (Game.squares[8].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
											&& Game.squares[9].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
											&& Game.squares[8].getMajorDevelopments()==1 && Game.squares[9].getMajorDevelopments()==1) {
												System.out.println("System 4 is fully developed and ready for launch");
												break;
											} 
				
				}
				}
			}
	}
	


	/**
	 * How to develop square, ie build development/major development
	 */

}

// while (userResponse.equalsIgnoreCase("Y"));
