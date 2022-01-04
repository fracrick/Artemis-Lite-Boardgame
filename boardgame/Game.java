/**
 * 
 */
package boardgame;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import boardgame.ForSaleSquare;

/**
 * @author Paul Mellon
 *
 */
public class Game {

	public static final int STARTING_BALANCE = 8000;

	public static final int STARTING_POSITION = 0;

	private static Player currentPlayer, playerOne, playerTwo, playerThree, playerFour;

	public static SortedSet<String> systemsOwned = new TreeSet<>();

	private static Player p1 = new Player(null, STARTING_BALANCE, false, STARTING_POSITION);
	private static Player p2 = new Player(null, STARTING_BALANCE, false, STARTING_POSITION);
	private static Player p3 = new Player(null, STARTING_BALANCE, false, STARTING_POSITION);
	private static Player p4 = new Player(null, STARTING_BALANCE, false, STARTING_POSITION);

	public static Boolean takeOff = false;

	private static int playerTurn = 1;

	private static ForSaleSquare SquareLandedOn = null;

	public static StartSquare startsquare = new StartSquare();

	public static BlankSquare blanksquare = new BlankSquare();

	public static ForSaleSquare system1A = new ForSaleSquare("System 1 A", 100, false, "System 1 A", "NotYet", 0, 0, 10,
			100, 20, 10, 100, "System 1 A description");

	public static ForSaleSquare system1B = new ForSaleSquare("System 1 B", 100, false, "System 1 B", "NotYet", 0, 0, 10,
			100, 20, 10, 100, "System 1 B description");

	public static ForSaleSquare system1C = new ForSaleSquare("System 1 C", 100, false, "System 1 C", "NotYet", 0, 0, 10,
			100, 20, 10, 100, "System 1 C description");

	public static ForSaleSquare system2A = new ForSaleSquare("System 2 A", 200, false, "System 2 A", "NotYet", 0, 0, 20,
			200, 40, 20, 200, "System 2 A description");

	public static ForSaleSquare system2B = new ForSaleSquare("System 2 B", 200, false, "System 2 B", "NotYet", 0, 0, 20,
			200, 40, 20, 200, "System 2 B description");

	public static ForSaleSquare system2C = new ForSaleSquare("System 2 C", 200, false, "System 2 C", "NotYet", 0, 0, 20,
			200, 40, 20, 200, "System 2 C description");

	public static ForSaleSquare system3A = new ForSaleSquare("System 3 A", 50, false, "System 3 A", "NotYet", 0, 0, 5,
			50, 10, 10, 150, "System 3 A description");

	public static ForSaleSquare system3B = new ForSaleSquare("System 3 B", 50, false, "System 3 B", "NotYet", 0, 0, 5,
			50, 10, 10, 150, "System 3 B description");

	public static ForSaleSquare system4A = new ForSaleSquare("System 4 A", 500, false, "System 4 A", "NotYet", 0, 0, 50,
			400, 100, 10, 400, "System 4 A description");

	public static ForSaleSquare system4B = new ForSaleSquare("System 4 B", 500, false, "System 4 B", "NotYet", 0, 0, 50,
			400, 100, 10, 400, "System 4 B description");

	public static ForSaleSquare[] squares = { system1A, system1B, system1C, system2A, system2B, system2C, system3A,
			system3B, system4A, system4B };

	public static void main(String[] args) {

		// set players

		setCurrentPlayer(p1);
		setPlayerOne(p1);
		setPlayerTwo(p2);
		setPlayerThree(p3);
		setPlayerFour(p4);

		// welcome message

		System.out.println("Welcome to Atremis light, we hope you arent afraid of heights");

		// get player names
		getAllPlayerNames();

		System.out.println(currentPlayer.getName());
		System.out.println(playerTwo.getName());
		System.out.println(playerThree.getName());
		System.out.println(playerFour.getName());
		Scanner scanner = new Scanner(System.in);
		String userInput;

		do {
			checkTurn();
			System.out.println(
					"Would " + currentPlayer.getName() + " like to roll the dice ? Press y to roll or Press n to quit");
			userInput = scanner.nextLine();
			if (userInput.equalsIgnoreCase("y")) {
				System.out.println(getPlayerTurn());
				currentPlayerTakeTurn();
				// turnEnd();
				// checkTurn();

			} else {
				System.out.println(
						"Would you like to quit: Press y to quit" + "\nWe will miss you  " + currentPlayer.getName());
				userInput = scanner.nextLine();
				if (userInput.equalsIgnoreCase("y")) {
					// currentPlayer.setBankrupt(true);
					currentPlayer.setBalance(0);
					System.out.println(currentPlayer.getBalance());
					break;
				}
			}
			turnEnd();
			checkTurn();
			checkTakeOff();

		} while (currentPlayer.getBalance() > 0 && playerOne.getBalance() > 0 && playerTwo.getBalance() > 0
				&& playerThree.getBalance() > 0 && playerFour.getBalance() > 0 && takeOff != true);
		System.out.println("Game over");

	}

	/**
	 * 
	 * @return
	 */
	public static ForSaleSquare getSquareLandedOn() {
		return SquareLandedOn;
	}

	/**
	 * @param holder
	 */
	public static void setSquareLandedOn(ForSaleSquare SquareLandedOn) {
		Game.SquareLandedOn = SquareLandedOn;
	}

	/**
	 * @return the currentPlayer
	 */
	public static Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * @param currentPlayer
	 */
	public static void setCurrentPlayer(Player currentPlayer) {
		Game.currentPlayer = currentPlayer;
	}

	/**
	 * @return the currentPlayer
	 */
	public static Player getPlayerTwo() {
		return playerTwo;
	}

	/**
	 * @param currentPlayer
	 */
	public static void setPlayerTwo(Player PlayerTwo) {
		playerTwo = PlayerTwo;
	}

	/**
	 * @return the currentPlayer
	 */
	public static Player getPlayerThree() {
		return playerThree;
	}

	/**
	 * @param currentPlayer
	 */
	public static void setPlayerThree(Player PlayerThree) {
		playerThree = PlayerThree;
	}

	/**
	 * @return the currentPlayer
	 */
	public static Player getPlayerFour() {
		return playerFour;
	}

	/**
	 * @param currentPlayer
	 */
	public static void setPlayerFour(Player PlayerFour) {
		playerFour = PlayerFour;
	}

	public static void SquareLanded(ForSaleSquare[] squares, StartSquare startSquare, BlankSquare blankSquare) {
		switch (currentPlayer.getPosition()) {
		case 0:
			startSquare.displayAll();
			setSquareLandedOn(null);
			break;
		case 1:
			blankSquare.displayAll();
			setSquareLandedOn(null);
			break;
		case 2:
			squares[0].displayAll();
			setSquareLandedOn(squares[0]);
			break;
		case 3:
			squares[1].displayAll();
			setSquareLandedOn(squares[1]);
			break;
		case 4:
			squares[2].displayAll();
			setSquareLandedOn(squares[2]);
			break;
		case 5:
			squares[3].displayAll();
			setSquareLandedOn(squares[3]);
			break;
		case 6:
			squares[4].displayAll();
			setSquareLandedOn(squares[4]);
			break;
		case 7:
			squares[5].displayAll();
			setSquareLandedOn(squares[5]);
			break;
		case 8:
			squares[6].displayAll();
			setSquareLandedOn(squares[6]);
			break;
		case 9:
			squares[7].displayAll();
			setSquareLandedOn(squares[7]);
			break;
		case 10:
			squares[8].displayAll();
			setSquareLandedOn(squares[8]);
			break;
		case 11:
			squares[9].displayAll();
			setSquareLandedOn(squares[9]);
			break;

		}

	}

	public static void turnEnd() {
		if (currentPlayer.equals(p1)) {
			p1 = currentPlayer;
			p2 = playerTwo;
			p3 = playerThree;
			p4 = playerFour;
			System.out.println("Turn one over ");
		} else if (currentPlayer.equals(p2)) {
			p2 = currentPlayer;
			p1 = playerOne;
			p3 = playerThree;
			p4 = playerFour;
			System.out.println("Turn 2 over ");
		} else if (currentPlayer.equals(p3)) {
			p3 = currentPlayer;
			p2 = playerTwo;
			p1 = playerOne;
			p4 = playerFour;
			System.out.println("Turn 3 over ");
		} else {
			p4 = currentPlayer;
			p2 = playerTwo;
			p3 = playerThree;
			p1 = playerOne;
			System.out.println("Turn 4 over ");
		}
		switch (currentPlayer.getPosition()) {
		case 3:
			squares[1] = SquareLandedOn;
			break;
		case 4:
			squares[2] = SquareLandedOn;
			break;
		case 5:
			squares[3] = SquareLandedOn;
			break;
		case 6:

			squares[4] = SquareLandedOn;
			break;
		case 7:
			squares[5] = SquareLandedOn;
			break;
		case 8:
			squares[6] = SquareLandedOn;
			break;
		case 9:
			squares[7] = SquareLandedOn;
			break;
		case 10:
			squares[8] = SquareLandedOn;
			break;
		case 11:
			squares[9] = SquareLandedOn;
			break;

		}

	}

	public static void currentPlayerTakeTurn() {
		System.out.println(currentPlayer.getName() + " it is your turn");
		currentPlayer.setPosition(currentPlayer.rollDice() + currentPlayer.getPosition());
		if (currentPlayer.getPosition() > 12) {
			StartSquare.LandOnStartSquare();
		}
		SquareLanded(squares, startsquare, blanksquare);

		if (currentPlayer.getPosition() != 0 && currentPlayer.getPosition() != 1) {

			for (ForSaleSquare square : squares) {

				/**
				 * if(square.isOwned()==true) { systemsOwned.add(square.getSquareName()); }
				 */

				if (square.getSquareOwner().equalsIgnoreCase(p1.getName())
						|| square.getSquareOwner().equalsIgnoreCase(p2.getName())
						|| square.getSquareOwner().equalsIgnoreCase(p3.getName())
						|| square.getSquareOwner().equalsIgnoreCase(p4.getName())) {
					systemsOwned.add(square.getSquareName());
				}

				System.out.printf("%s is owned by %s\n", square.getSquareName(), square.getSquareOwner());
			}

		}

		if (getSquareLandedOn() != null) {
			if (getSquareLandedOn().getSquareOwner().equalsIgnoreCase("NotYet")) {
				ForSaleSquare.purchaseSquare();

			} else if (getSquareLandedOn().getSquareOwner().equalsIgnoreCase(getCurrentPlayer().getName())
					&& ((Game.squares[0].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
							&& Game.squares[1].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
							&& Game.squares[2].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())))) {
				ForSaleSquare.createDeveleopment();
			} else if (getSquareLandedOn().getSquareOwner().equalsIgnoreCase(getCurrentPlayer().getName())
					&& ((Game.squares[3].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
							&& Game.squares[4].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
							&& Game.squares[5].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())))) {
				ForSaleSquare.createDeveleopment();

			} else if (getSquareLandedOn().getSquareOwner().equalsIgnoreCase(getCurrentPlayer().getName())
					&& ((Game.squares[6].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
							&& Game.squares[7].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())))) {
				ForSaleSquare.createDeveleopment();

			} else if (getSquareLandedOn().getSquareOwner().equalsIgnoreCase(getCurrentPlayer().getName())
					&& (Game.squares[8].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName())
							&& Game.squares[9].getSquareOwner().equalsIgnoreCase(Game.getCurrentPlayer().getName()))) {
				ForSaleSquare.createDeveleopment();
			} else if (getSquareLandedOn() == null) {
				System.out.println("Blank square do nothing");
			} else if (getSquareLandedOn().getSquareOwner().equalsIgnoreCase(getCurrentPlayer().getName())) {
				System.out.println("You own this square but not the whole system");
			} else {
				Player.payTrainingFee();
			}
		}
		
		setPlayerTurn(getPlayerTurn() + 1);

	}

	public static void requestCurrentPlayerName() {

		Scanner scanner = new Scanner(System.in);
		System.out.printf("What is the first players name?\t");
		currentPlayer.setName(scanner.nextLine());
		if (currentPlayer.getName().trim().equals("")) {
			System.out.println("Invalid input");
			requestCurrentPlayerName();
		}
		checkTurn();

	}

	public static void requestPlayerTwoName() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("\nOkay %s, and what is the second players name? ", currentPlayer.getName());
		currentPlayer.setName(scanner.nextLine());
		if (currentPlayer.getName().trim().equals("")) {
			System.out.println("Invalid input");
			requestPlayerTwoName();
		}
		if (currentPlayer.getName().equalsIgnoreCase(p2.getName())) {
			System.out.println("Names cannot be the same. Please try again.");

			currentPlayer.setName("");

			requestPlayerTwoName();
		}

		checkTurn();

	}

	public static void requestPlayerThreeName() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("\nOkay %s, and what is the third players name? ", p2.getName());
		currentPlayer.setName(scanner.nextLine());
		if (currentPlayer.getName().trim().equals("")) {
			System.out.println("Invalid input");
			requestPlayerThreeName();
		}
		if (currentPlayer.getName().equalsIgnoreCase(p1.getName())
				|| currentPlayer.getName().equalsIgnoreCase(p2.getName())) {
			System.out.println("Names cannot be the same. Please try again");

			currentPlayer.setName("");

			requestPlayerThreeName();
		}

		checkTurn();

	}

	public static void requestPlayerFourName() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("\nOkay %s, and what is the fourth players name? ", p3.getName());
		currentPlayer.setName(scanner.nextLine());
		if (currentPlayer.getName().trim().equals("")) {
			System.out.println("Invalid input");
			requestPlayerFourName();
		}
		if (currentPlayer.getName().equalsIgnoreCase(p1.getName())
				|| currentPlayer.getName().equalsIgnoreCase(p2.getName())
				|| currentPlayer.getName().equalsIgnoreCase(p3.getName())) {
			System.out.println("Names cannot be the same. Please try again");

			currentPlayer.setName("");

			requestPlayerFourName();
		}

		checkTurn();
		System.out.printf("\nHello %s, let's begin Artemis Lite.\n", p4.getName());
	}

	public static void checkTurn() {

		switch (getPlayerTurn()) {
		case 1:
			currentPlayer = p1;
			break;
		case 2:
			currentPlayer = p2;
			break;
		case 3:
			currentPlayer = p3;
			break;
		case 4:
			currentPlayer = p4;
			break;
		default:
			if (getPlayerTurn() > 4) {
				setPlayerTurn(1);
			}
			break;

		}

	}

	public static void turnStart() {
		if (getPlayerTurn() == 1 && getPlayerTurn() == 5 && getPlayerTurn() == 9 && getPlayerTurn() == 13
				&& getPlayerTurn() == 17 && getPlayerTurn() == 21 && getPlayerTurn() == 25 && getPlayerTurn() == 29
				&& getPlayerTurn() == 33 && getPlayerTurn() == 37 && getPlayerTurn() == 41) {
			currentPlayer = p1;
			playerTwo = p2;
			playerThree = p3;
			playerFour = p4;
		} else if (getPlayerTurn() == 2 && getPlayerTurn() == 6 && getPlayerTurn() == 10 && getPlayerTurn() == 14
				&& getPlayerTurn() == 18 && getPlayerTurn() == 22 && getPlayerTurn() == 26 && getPlayerTurn() == 30
				&& getPlayerTurn() == 34 && getPlayerTurn() == 38 && getPlayerTurn() == 42) {
			currentPlayer = p2;
			playerTwo = p1;
			playerThree = p3;
			playerFour = p4;
		} else if (getPlayerTurn() == 3 && getPlayerTurn() == 6 && getPlayerTurn() == 10 && getPlayerTurn() == 14
				&& getPlayerTurn() == 18 && getPlayerTurn() == 22 && getPlayerTurn() == 27 && getPlayerTurn() == 31
				&& getPlayerTurn() == 35 && getPlayerTurn() == 39 && getPlayerTurn() == 43) {
			currentPlayer = p3;
			playerTwo = p2;
			playerThree = p1;
			playerFour = p4;
		} else {
			currentPlayer = p4;
			playerTwo = p2;
			playerThree = p3;
			playerFour = p1;
		}

	}

	public static void turnStart2() {
		if (getPlayerTurn() % 2 == 0 && getPlayerTurn() != 6 && getPlayerTurn() != 12 && getPlayerTurn() != 18
				&& getPlayerTurn() != 24 && getPlayerTurn() != 30 && getPlayerTurn() != 10 && getPlayerTurn() != 20
				&& getPlayerTurn() != 40 && getPlayerTurn() != 50 && getPlayerTurn() != 60 && getPlayerTurn() != 70
				&& getPlayerTurn() != 80 && getPlayerTurn() != 90 && getPlayerTurn() != 100) {
			playerTwo = p2;
			playerThree = p3;
			playerFour = p4;
		} else if (getPlayerTurn() % 3 == 0 && getPlayerTurn() != 15 && getPlayerTurn() != 30 && getPlayerTurn() != 45
				&& getPlayerTurn() != 60 && getPlayerTurn() != 90 && getPlayerTurn() != 135 && getPlayerTurn() != 180) {
			currentPlayer = p2;
			playerTwo = p1;
			playerThree = p3;
			playerFour = p4;
		} else if (getPlayerTurn() % 5 == 0) {
			currentPlayer = p3;
			playerTwo = p2;
			playerThree = p1;
			playerFour = p4;
		} else {
			currentPlayer = p4;
			playerTwo = p2;
			playerThree = p3;
			playerFour = p1;
		}

	}

	public static void getAllPlayerNames() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("What is the first players name?");
		currentPlayer.setName(scanner.nextLine());
		if (currentPlayer.getName().trim().equals("")) {
			System.out.println("Invalid input");
			getAllPlayerNames();
		}
		System.out.printf("\nOkay %s, and what is the second players name? ", currentPlayer.getName());
		playerTwo.setName(scanner.nextLine());
		if (playerTwo.getName().trim().equals("")) {
			System.out.println("Invalid input");
			getAllPlayerNames();
		}
		if (currentPlayer.getName().equalsIgnoreCase(playerTwo.getName())) {
			System.out.println("Names cannot be the same. Please try again.");

			playerTwo.setName("");
			getAllPlayerNames();
		}
		System.out.printf("\nOkay %s, and what is the third players name? ", currentPlayer.getName());
		playerThree.setName(scanner.nextLine());
		if (playerThree.getName().trim().equals("")) {
			System.out.println("Invalid input");
			getAllPlayerNames();
		}
		if (playerThree.getName().equalsIgnoreCase(currentPlayer.getName())
				|| playerThree.getName().equalsIgnoreCase(playerTwo.getName())) {
			System.out.println("Names cannot be the same. Please try again");

			currentPlayer.setName("");
			getAllPlayerNames();

		}
		System.out.printf("\nOkay %s, and what is the fourth players name? ", currentPlayer.getName());
		playerFour.setName(scanner.nextLine());
		if (playerFour.getName().trim().equals("")) {
			System.out.println("Invalid input");
			getAllPlayerNames();
		}
		if (playerFour.getName().equalsIgnoreCase(currentPlayer.getName())
				|| playerFour.getName().equalsIgnoreCase(playerTwo.getName())
				|| playerFour.getName().equalsIgnoreCase(playerThree.getName())) {
			System.out.println("Names cannot be the same. Please try again");

			currentPlayer.setName("");
			getAllPlayerNames();
		}
	}

	public static Player getPlayerOne() {
		return playerOne;
	}

	public static void setPlayerOne(Player playerOne) {
		Game.playerOne = playerOne;
	}

	public static int getPlayerTurn() {
		return playerTurn;
	}

	public static void setPlayerTurn(int playerTurn) {
		Game.playerTurn = playerTurn;
	}

	
	/**
	 * public static void checkTakeOff() {

		takeOff = false;

		for (ForSaleSquare squares : Game.squares) {
			if (squares.getMajorDevelopments() > 1) {
				takeOff = true;
				System.out.println(
						"Congratuations team you have completed the artemtis Project, take off to the moon will take off in ");
				for (int loop = 10; loop > 0; loop--) {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(loop);
				}
				System.out.println("TakeOff!!!");

			}

		}

	}
	 */
	
	
	
	  
	  public static void checkTakeOff() {

		takeOff = false;

		if (system1A.getMajorDevelopments() == 1 && system1B.getMajorDevelopments() == 1
				&& system1C.getMajorDevelopments() == 1 && system1C.getMajorDevelopments() == 1
				&& system1C.getMajorDevelopments() == 1 && system2A.getMajorDevelopments() == 1
				&& system1C.getMajorDevelopments() == 1 && system2B.getMajorDevelopments() == 1
				&& system2B.getMajorDevelopments() == 1 && system2C.getMajorDevelopments() == 1
				&& system2B.getMajorDevelopments() == 1 && system3A.getMajorDevelopments() == 1
				&& system2B.getMajorDevelopments() == 1 && system3B.getMajorDevelopments() == 1
				&& system2B.getMajorDevelopments() == 1 && system4A.getMajorDevelopments() == 1
				&& system4B.getMajorDevelopments() == 1) {
		
			takeOff = true;
			System.out.println(
					"Congratuations team you have completed the artemtis Project, take off to the moon will take off in ");
			for (int loop = 10; loop > 0; loop--) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(loop);
			}
			System.out.println("TakeOff!!!");

			
			
			
		}
		
					

	}
	



}
