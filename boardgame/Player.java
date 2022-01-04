package boardgame;


import java.util.Random;
import java.util.Scanner;


/**
 * @author Fra
 *
 */
public class Player implements IDiceRoll {

	
	private String name;
	
	private double balance;
	private boolean bankrupt;
	private int position;
	// position correlates to the index of the arrayList which contains the various
	// squares that can be landed on

	/**
	 * default constructor
	 */
	public Player() {

	}

	public Player(String name, int balance, boolean bankrupt, int position) {
		super();
		this.name = name;
		this.balance = balance;
		this.setBankrupt(bankrupt);
		this.position = position;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public int rollDice() {
		int total = 0;
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press any key and enter to roll dice..");
		scanner.next();
		total = random.nextInt(12)+1;
		if(total ==1) {
			total+=1;
		}
		System.out.println(this.getName() + " rolled a " + total);

		return total;
	}

	

	public void displayAll() {
		System.out.println("Player Name:       "+ this.name);
		System.out.println("Balance:           "+ this.balance);
		System.out.println("Position on board: "+ this.getPosition());

	}

	public double returnBalance() {
		System.out.println("Player " + this.getName() + " has a balance of: " + this.getBalance());
		
			return this.getBalance();
		}
		

	public int movePosition() {

		int updatedPosition;
		updatedPosition = this.getPosition() + rollDice();

		return updatedPosition;
	}
	
	// or 
	
	public int incrementPosition() {
		int incrementedPosition;
		
		incrementedPosition = this.position+=rollDice();
		return incrementedPosition;
	}
	
	/**
	 * @author Fra @author Paul mellon
	 */
	public static void payTrainingFee() {
		Scanner scanner= new Scanner(System.in);
		String userinput;
		
		System.out.println("You have landed on your oponents system and are required to pay the training fee");
		
		// Game.getCurrentPlayer().setBalance(Game.getCurrentPlayer().getBalance()-Game.getSquareLandedOn().getTrainingCost());
		
		
			System.out.println("Please pass control to : " +Game.getSquareLandedOn().getSquareOwner());       // +Game.getPlayerTwo().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" Hello "+ Game.getSquareLandedOn().getSquareOwner()+  
					" Would you like to accept the rent from: "+Game.getCurrentPlayer().getName()+ " Enter Y/N ");
			userinput=scanner.nextLine();
			if (userinput.equalsIgnoreCase("Y")) {
				Game.getCurrentPlayer().setBalance(Game.getCurrentPlayer().getBalance()-Game.getSquareLandedOn().getTrainingCost());
				System.out.println(Game.getCurrentPlayer().getName()+" your new balance is: "+ Game.getCurrentPlayer().getBalance());
				//Game.getSquareLandedOn().getSquareOwner().  
				if (Game.getSquareLandedOn().getSquareOwner().equalsIgnoreCase(Game.getPlayerOne().getName())) {
					Game.getPlayerOne().setBalance(Game.getPlayerOne().getBalance()+Game.getSquareLandedOn().getTrainingCost());
					System.out.println(Game.getPlayerOne().getName()+" your new balance is: "+Game.getPlayerOne().getBalance());
				} else if (Game.getSquareLandedOn().getSquareOwner().equalsIgnoreCase(Game.getPlayerTwo().getName())) {
					Game.getPlayerTwo().setBalance(Game.getPlayerTwo().getBalance()+Game.getSquareLandedOn().getTrainingCost());
					System.out.println(Game.getPlayerTwo().getName()+" your new balance is: "+Game.getPlayerTwo().getBalance());
				} else if (Game.getSquareLandedOn().getSquareOwner().equalsIgnoreCase(Game.getPlayerThree().getName())) {
					Game.getPlayerThree().setBalance(Game.getPlayerThree().getBalance()+Game.getSquareLandedOn().getTrainingCost());
					System.out.println(Game.getPlayerThree().getName()+" your new balance is: "+Game.getPlayerThree().getBalance());
				} else if (Game.getSquareLandedOn().getSquareOwner().equalsIgnoreCase(Game.getPlayerFour().getName())) {
					Game.getPlayerFour().setBalance(Game.getPlayerFour().getBalance()+Game.getSquareLandedOn().getTrainingCost());
					System.out.println(Game.getPlayerFour().getName()+" your new balance is: "+Game.getPlayerFour().getBalance());
				
				// if elses for showing new balances
			
				}
			}
		
	}

	public boolean isBankrupt() {
		return bankrupt;
	}

	public void setBankrupt(boolean bankrupt) {
		this.bankrupt=bankrupt;
	
	}
	}
