package Server;
import java.util.Scanner;

/**
 *  This class represents class player for Tic-Tac-Toe game.
 * @author Sonia Soleimani
 * @version 1.0
 * @since November 6, 2020
 */
public class Player {
	/**
	 * name is a  string that name of the player
	 */
	String name;
	/**
	 * theBoard is  a object of class  Board
	 */
	public Board board;
	/**
	 * opponent is  a object of class  Player
	 */
	public Player opponent;
	/**
	 * mark is a  char that is the sign of the player
	 */
	char mark;
	/**
	 * Constructs a player by taking a name and char 
	 * @param name
	 * @param mark
	 */
	public Player(String name, char mark) {

		this.name=name;
		this.setMark(mark);

	}


	/**
	 * it is kind of abstract just i put this here because of testing my program alongside of the frame to see what in happen in my console
	 */
	public  void play() {

	}
	/**
	 * it is kind of abstract just i put this here because of testing my program alongside of the frame to see what in happen in my console
	 */
	public void makeMove(){

	}



	/**
	 * it is an instance method to set the board
	 * @param theboard
	 */

	public void setBoard(Board theboard) {
		this.board = theboard;
	}
	/**
	 * it is an instance method to get the board
	 * @return
	 */

	public Board getBoard() {
		return board;
	}

	/**
	 *  it is an instance method to set the opponent
	 * @param opponent
	 */
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	/**
	 * it is an instance method to get the name
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * it is an instance method to set the name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * it is an instance method to get the opponent
	 * @return
	 */
	public Player getOpponent() {
		return opponent;
	}
	/**
	 * it is an instance method to get the mark
	 * @return
	 */
	public char getMark() {
		return mark;
	}

	/**
	 * it is an instance method to set the mark
	 * @param name
	 */

	public void setMark(char mark) {
		this.mark = mark;
	}

}
