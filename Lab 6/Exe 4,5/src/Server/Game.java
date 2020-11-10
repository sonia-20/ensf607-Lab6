package Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * The Class Game:model of program.
 * @author Sonia Soleimani
 * @version 1.0
 * @since November 6, 2020
 */
public class Game implements Constants,Runnable{
	/**
	 * theBoard is  a object of class  Board
	 */
	Board theBoard;
	/**
	 * theRef is  a object of class  Referee
	 */
	private Referee theRef;
	/**
	 * xPlayer and oPlayer  are   objects of class Player
	 */
	Player xPlayer, oPlayer;
	/**
	 * stdin is  a object of class  BufferedReader
	 */
	BufferedReader stdin;
	/**
	 * X and O  are  string that use them for naming
	 */
	String X,O;
	PrintWriter xOut;
	BufferedReader xIn;
	PrintWriter oOut;
	BufferedReader oIn;

	private Socket socketX;
	private Socket socketO;

	/**
	 * Constructs a Game by constructing the board and creating the player and also
	 * Referee and calling some functions to help the constructor for example getting the name of the player or set player and set the board   
	 */
	public Game(Socket playerX, Socket playerO, String X,String O ) throws IOException {



		theBoard  = new Board();
		this.X=X;
		this.O=O;
		xPlayer = create_player (X, LETTER_X, theBoard, stdin);


		oPlayer = create_player (O, LETTER_O, theBoard, stdin);


		theRef = new Referee();
		theRef.setBoard(theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);

		appointReferee(theRef);

		socketX = playerX;
		socketO = playerO;
		xIn = new BufferedReader(new InputStreamReader(socketX.getInputStream()));
		xOut = new PrintWriter((socketX.getOutputStream()), true);

		oIn = new BufferedReader(new InputStreamReader(socketO.getInputStream()));
		oOut = new PrintWriter((socketO.getOutputStream()), true);

	}










	/**
	 * this function run the game 
	 * @param r is a object of classes referee
	 * @throws IOException
	 */

	public void appointReferee(Referee r) throws IOException {
		theRef = r;
		theRef.runTheGame();
	}



	
	/**
	 * this function takes four argument and 
	 * set the board and return the result 
	 * @param name is a name of player
	 * @param mark is the sign of the player
	 * @param board 
	 * @param stdin
	 * @return
	 * @throws IOException
	 */
	public Player  create_player(String name, char mark, Board board, BufferedReader stdin)throws IOException {

		Player result=new Player(name, mark);
		result.setBoard(board);
		return result;
	}






	@Override
	public void run() {

		int opponent=1;


		while(!theBoard.xWins() && !theBoard.oWins() && !theBoard.isFull()) {
			try {
				if (opponent==1) {
					getxOut().println("PLAY");
					getoOut().println("WAIT");


					int	row = Integer.parseInt(getxIn().readLine());
					int	col = Integer.parseInt(getxIn().readLine()) ;

					while(true) {

						if(!theBoard.checkAvailability(row, col)) {
							theBoard.addMark(row, col,'X');
							theBoard.display();
							oPlayer.getOpponent().play();

							getxOut().println("X");
							getoOut().println(row+"X"+col);
							break;
						}
						else {
							getxOut().println("false");
							row = Integer.parseInt(getxIn().readLine());
							col = Integer.parseInt(getxIn().readLine()) ;
						}
					}
					opponent = 2;
				}

				else if (opponent==2){
					getxOut().println("WAIT");
					getoOut().println("PLAY");

					int row = Integer.parseInt(getoIn().readLine());
					int col = Integer.parseInt(getoIn().readLine()) ;

					while(true) {

						if(!theBoard.checkAvailability(row, col)) {

							theBoard.addMark(row, col,'O');
							theBoard.display();
							oPlayer.getOpponent().play();

							getxOut().println(row+"O"+col);
							getoOut().println("O");
							break;
						}
						else {
							getoOut().println("false");
							row = Integer.parseInt(getoIn().readLine());
							col = Integer.parseInt(getoIn().readLine()) ;
						}
					}
					opponent = 1;
				}
			}  catch (IOException e) {
				e.printStackTrace();
			}
		}
			getxOut().println("END");
			getoOut().println("END");

			if (theBoard.xWins()) {
				getxOut().println("--- "+X+"  Wins!!! ---");
				getoOut().println("--- "+X+"  Wins!!! ---");
			}
			else if (theBoard.oWins()) {
				getxOut().println("--- "+O+"  Wins!!! ---");
				getoOut().println("--- "+O+"  Wins!!! ---");
			}
			else {
				getxOut().println("The game ended in a tie!");
				getoOut().println("The game ended in a tie!");
			}	
		

	}








	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////



	public PrintWriter getxOut() {
		return xOut;
	}

	public void setxOut(PrintWriter xOut) {
		this.xOut = xOut;
	}

	public BufferedReader getxIn() {
		return xIn;
	}

	public void setxIn(BufferedReader xIn) {
		this.xIn = xIn;
	}

	public PrintWriter getoOut() {
		return oOut;
	}

	public void setoOut(PrintWriter oOut) {
		this.oOut = oOut;
	}

	public BufferedReader getoIn() {
		return oIn;
	}


	public void setoIn(BufferedReader oIn) {
		this.oIn = oIn;
	}


}


