//Student 1 full name: Jordan Lau
//Student 2 full name: Tim Mao
//==================================================



/**
 * The interface <b> Player </b> represents a Player who can play the game, "The Tower of Hanoi."
 * It has an implementation, the class HumanPlayer, that is used to represent each Human playing the game.
 * <p>
 * @author Jordan Lau
 * @author Tim Mao
 */

public interface Player {
    void play(HanoiTowerGame game);
    int getScore();
}