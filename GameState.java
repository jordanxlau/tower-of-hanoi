//Student 1 full name: Jordan Lau
//Student 2 full name: Tim Mao
//==================================================


/**
 * The enum <b> GameState </b> represents the state of a game of "The Tower Of Hanoi."
 * It has 3 states, PLAYING, LOSER, or WINNER.
 * PLAYING means the game is still playing.
 * WINNER means the player has won the game.
 * LOSER means the player has lost the game.
 * After every call of the method checkWinner() (within the method play() of the class HanoiTowerGame), the gameState is updated.
 * <p>
 * @author Jordan Lau
 * @author Tim Mao
 */

public enum GameState {
    PLAYING,
    LOSER,
    WINNER
}