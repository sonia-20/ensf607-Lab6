package Server;
/**
 * The Class Referee.
 * @author Sonia Soleimani
 * @version 1.0
 * @since November 6, 2020
 */
public class Referee {
	

	/**
	 *  two object form class of Player as member variables
	 */
	private Player xPlayer, oPlayer;
	/**
	 *  one object form class of board as a member variable
	 */
	private Board board;


	/**
	 * Constructs a Referee object as a default
	 */
	public Referee() {

	}

	/**
	 * this function is presenting the setting opponent for the game
	 * and after that display the board,
	 * and at the end it starts the game with xPlayer
	 */
	public void runTheGame() {
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		board.display();
		xPlayer.play();

	}


	/**
	 * Sets the value of board to the specified value.
	 */

	public void setBoard(Board board) {
		this.board = board;
	}
	/**
	 * Sets the value of xPlayer to the specified value.
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}
	/**
	 * Sets the value of oPlayer to the specified value.
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}



}
