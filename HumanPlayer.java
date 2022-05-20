//Student 1 full name: Jordan Lau
//Student 2 full name: Tim Mao
//==================================================

/**
 * The class <b>HumanPlayer</b> implements the interface Player, and is the class that controls the human's plays.
 * It has an important method, play(), that will print out instructions for the human to play.
 * Then, it will take in two ints that the human inputs and move a disk to/from the appropriate towers.
 * To do so, it must call the method play() from the class HanoiTowerGame.
 * Every time, it updates the gameState.
 * <p>
 * @author Jordan Lau
 * @author Tim Mao
 */

public class HumanPlayer implements Player {

    private int score;
    private int s;
    private int d;

    /** 
     * Constructor method that initializes a player of the game "The Tower Of Hanoi."
     * This constructor method has no formal parameters.
     * The player's score defaults to 0.
     */
    public HumanPlayer() {
        score = 0;
    }

    /**
    * This method will print out instructions for the human to play.
    * Then, it will keep taking in two ints that the human inputs and move a disk to/from the appropriate towers.
    * To do so, it must call the method play() from the class HanoiTowerGame.
    * Every time, it updates the gameState.
    * The loop breaks when the gameState is WINNING or LOSING.
    * @param game This represents a game of "The Tower of Hanoi" to play.
    */
    public void play(HanoiTowerGame game){
        System.out.println(game);
        System.out.println("Your goal is to move " + game.getDisks() + " disks from tower 1 to tower 3");
        System.out.println("Only one simple rule: no large disk on the top of a smaller one!");
        System.out.println("Enter the source and the destination towers each on a single line:");
        while (game.getGameState() == GameState.PLAYING){
            s = Integer.parseInt(Utils.console.readLine()) - 1;
            d = Integer.parseInt(Utils.console.readLine()) - 1;
            game.play(s, d);
        }
        
        if (game.getGameState() == GameState.WINNER){
            score++;
            System.out.println("You did it within the allowed number of moves!");
        } else {
            System.out.println("You finished the allowed number of moves!");
        }
        System.out.println("Your score is " + score);
        System.out.println("=================");
    }

    /**
     * This is a getter method.
     * It is included to obey the best practices of encapsulation.
     * It is called in the main method of the class HanoiTower to display/print out each player's score.
     * 
     * @return int This represents the player's score.
     */
    public int getScore(){
        return score;
    }

}