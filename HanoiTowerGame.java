//Student 1 full name: Jordan Lau
//Student 2 full name: Tim Mao
//==================================================



/**
 * The class <b> HanoiTowerGame </b> represents a game of "The Tower Of Hanoi."
 * It keeps track of each of the 3 towers using an array of linked stacks of size 3.
 * This stack, called towerValues, is made up of the reference type Integer.
 * It also keeps track of the number of moves made and the maximum number of moves.
 * <p>
 * @author Jordan Lau
 * @author Tim Mao
 */

import java.lang.Math;

public class HanoiTowerGame {

	private Stack[] towerValues; //This will point to the array of three towers
	private int level;
	private int disks;
	private int maxLevels;
	private GameState gameState;

	/** 
	 * Constructor method that initializes a game of "The Tower Of Hanoi."
	 * This constructor method has no formal parameters, the number of disks defaults to 3.
	 * The method also initializes 3 disks, in order, on the first tower. The other towers are empty.
	 */
	public HanoiTowerGame(){
		towerValues = new LinkedStack[3];
		
		towerValues[0] = new LinkedStack();
		for (int i = 3; i > 0; i--)
			towerValues[0].push(i);
		towerValues[1] = new LinkedStack();
		towerValues[2] = new LinkedStack();
		
		level = 0;
		disks = 3;
		maxLevels = 2*((int)Math.pow(2,disks) -1);
		gameState = GameState.PLAYING;
	}

	/** 
	 * Constructor method that initializes a game of "The Tower Of Hanoi."
	 * This constructor method has 1 formal parameter, the number of disks.
	 * The method also initializes n disks, in order, on the first tower. The other towers are empty.
	 * @param disks The number of disks to be initialized on the first tower.
	 */
	public HanoiTowerGame(int disks){
		towerValues = new LinkedStack[3];
		
		towerValues[0] = new LinkedStack();
		for (int i = disks; i > 0; i--)
			towerValues[0].push(i);
		towerValues[1] = new LinkedStack();
		towerValues[2] = new LinkedStack();
		
		level = 0;
		this.disks = disks;
		maxLevels = 2*((int)Math.pow(2,disks) -1);
		gameState = GameState.PLAYING;
	}

	// all methods should be documented: purpose of the method, input, output
	// and where it is used in the assignment

	/**
	 * This is a getter method.
	 * It is included simply to obey the best practices of encapsulation.
	 * It is not called anywhere in this implementation of the game "The Tower Of Hanoi."
	 * 
	 * @return int This returns the number of disks in play in a game.
	 */ 
	public int getDisks(){
		return disks;
	}

	/**
	 * This is a getter method.
	 * It is included simply to obey the best practices of encapsulation.
	 * It is not called anywhere in this implementation of the game "The Tower Of Hanoi."
	 * 
	 * @return int This returns the number of moves that have been made in a game.
	 */ 
	public int getLevel(){//
		return level;
	}

	/**
	 * This is a getter method.
	 * It is included simply to obey the best practices of encapsulation.
	 * It is not called anywhere in this implementation of the game "The Tower Of Hanoi."
	 * 
	 * @return int This returns the maximum number of moves that can be made before losing a game.
	 */ 
	public int maxLevels(){
		return maxLevels;
	}

	/**
	 * This is a getter method.
	 * It is included simply to obey the best practices of encapsulation.
	 * It is not called anywhere in this implementation of the game "The Tower Of Hanoi."
	 * 
	 * @return GameState This returns the state of the game (PLAYING, WINNER, LOSER).
	 */ 
	public GameState getGameState(){
		return gameState;
	}

	/**
	 * This is a getter method.
	 * It is included simply to obey the best practices of encapsulation.
	 * It is not called anywhere in this implementation of the game "The Tower Of Hanoi."
	 * @param i This represents the tower for which we wish to know the number of disks. Should be 0-2 as these are the valid indexes of the array.
	 * 
	 * @return int This returns the number of disks on the tower (number, i).
	 */ 
	public int getDisksAtTower(int i){
		return towerValues[i].size();
	} 

	/**
	 * This method will play a player's move by moving a disk from a source tower to a destination tower.
	 * This method will print out "Invalid move!!" if
	 * the source tower is empty, either parameter is not between 0-2 inclusive, or the destination tower's highest disk is smaller than the source's.
	 * It is called every move within the method play() of the class HumanPlayer.
	 * @param s Represents the source tower. Should be 0-2 as these are the valid indexes of the array.
	 * @param d Represents the destination tower. Should be 0-2 as these are the valid indexes of the array.
	 */ 
	public void play(int s, int d){
		if (s > 2 || d > 2 || s < 0 || d < 0)//if you choose a tower that doesn't exist
			System.out.println("Invalid move!!");
		else {
			Stack source = towerValues[s];
			Stack destination = towerValues[d];
				
			if (source.size() == 0)//if the source tower is empty
				System.out.println("There is/are no disk/'s at tower " + (s + 1) + "!!");
			else {
				if (destination.size() != 0 && (Integer) source.peek() > (Integer) destination.peek())//if the destination tower's disk is smaller
					System.out.println("Invalid move!! ");
				else {//move is valid
					destination.push(source.peek());
					source.pop();
					level++;
					this.checkWinner();}}
			System.out.print(this);
			System.out.println("Moves played " + level + "\t" + "Max " + maxLevels);
			if (gameState == GameState.PLAYING)
				System.out.println("Enter the source and the destination towers each on a single line:");}
	}

	/**
	 * This method will check if a player has won or lost the game, an update the field gameState accordingly.
	 * This method does not return anything and has no formal parameters.
	 * It is called within the method play() of the class HanoiTowerGame after any valid move is made.
	 */ 
	public void checkWinner(){
		if (gameState == GameState.PLAYING){
			if (towerValues[2].size() == disks)
				gameState = GameState.WINNER;
			else if (level >= maxLevels)
				gameState = GameState.LOSER;
		}
	}
	
	/**
	 * This is a private helper method.
	 * It is called within the method printTower() of the class HanoiTowerGame (this class).
	 * @param len Represents the size of a given disk to be printed.
	 * 
	 * @return String This returns a String with the correct number of dashes, given a size, len, of a disk.
	 */ 
	private String diskToString(int len){
		String result = "";
		for (int i = 0; i < len; i++){
			result += "-";
		}
		return result;
	}
	
	/**
	 * This is a private helper method.
	 * It is called within the method toString() of the class HanoiTowerGame (this class).
	 * @param num Represents the number of the tower to be returned. Should be 0-2.
	 * 
	 * @return String This returns a String that represents each tower, where each line is one disk.
	 */ 
	private String printTower(int num){
		String result = "";
		LinkedStack tempStack = new LinkedStack();
		
		int s = towerValues[num].size();//number of disks in tower

		if (s != disks)
			for (int i = 1; i <= disks - s; i++) //for the num of empty spaces there are
				result += Utils.NEW_LINE;
		
		if (s > 0) {
			for (int i = 0; i < s; i++){
				tempStack.push((Integer) towerValues[num].peek());//looks at the top disk, puts it in a temp stack
				result += diskToString((Integer) towerValues[num].pop());//takes the top disk out and makes a visual disk of it, adds it to result
				result += Utils.NEW_LINE;//next line down
			}
			for (int i = 0; i < s; i++)
				towerValues[num].push(tempStack.pop());//puts everything back into the original tower
		}
		
		return "Tower " + (num + 1) + Utils.NEW_LINE + result;
	}

	/**
	 * This is the toString method.
	 * Each disk is represented by a series of dashes, with one dash per size of the disk.
	 * An empty spot in the tower will be represented as an empty line.
	 * This method is called in the play() method of the HumanPlayer class before each move is made.
	 * 
	 * @return String This returns a String representing the game. It has each of the 3 towers, with each disk of each tower on a different line.
	 */ 
	public String toString(){
		return printTower(0) + printTower(1) + printTower(2);
	}
	
}