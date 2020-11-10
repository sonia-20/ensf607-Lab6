
package Server;


/**
 * The Class Board.
 * @author Sonia Soleimani
 * @version 1.0
 * @since November 6, 2020
 */
public class Board implements Constants {
	/**
	 * multi-dimentional array with type char for creating a board game.
	 */
	private char theBoard[][];
	/**
	 * after marking, this value count the numbers of mark. 
	 */
	private int markCount;



	/**
	 * Constructs a board object that that create multi-dimentional array 
	 * called the board with 4 rows and 4 cols.
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * marking the board game
	 * @param row object's theBoard
	 * @param column object's theBoardh
	 *@return board with marking
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * Compares mark count with the specified supplied values.
	 *
	 *@return if it is true that it means it is full

	 **/
	public boolean isFull() {
		return markCount == 9;
	}


	/**
	 * Compares xWINS with the specified supplied values.
	 * @param LETTER_X
	 * @return true if the LETTER_X  matches the supplied values.
	 * Otherwise returns false.
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}


	/**
	 * Compares oWins with the specified supplied values.
	 * @param LETTER_X
	 * @return true if the LETTER_X  matches the supplied values.
	 * Otherwise returns false.
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * display method with calling helper methods (displayColumnHeaders and addHyphens, addspace) 
	 *to show the board game
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * Compares person's information with the specified supplied values.
	 * @param row object's theBoard
	 * @param column object's theBoard
	 * @param mark the board object's markCount
	 *and at end it increment the variable markcount.
	 */

	public void addMark(int row, int col, char mark) {

		theBoard[row][col] = mark;
		markCount++;
	}
	/**
	 * for starting the new game we call this method
	 *
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * checking the winner method
	 * taking taype char argument called mark
	 * 
	 * it has three local variable
	 *@return result, the winner
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}


		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}
	public int smartRandom(int rowNew,int colNew,char mark) {
		int row=0;
		int col=0;
		int result=0;
		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (row==rowNew && col==colNew ) {
					if (getMark(row, col) != mark)
						row_result = 1;
				}
				else if (getMark(row, col) != mark)
				row_result = 0;
				
			if (row_result != 0)
				result = 1;
		}


		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (row==rowNew && col==colNew ) {
					if (getMark(row, col) != mark)
						col_result = 1;
				}
					else if (getMark(row, col) != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (row==rowNew && row==colNew ) {
					if (getMark(row, row) != mark)
						diag1Result = 1;
				}
					else if (getMark(row, row) != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (row==rowNew && 2-row==colNew ) {
					if (getMark(row, 2 - row) != mark)
						diag2Result = 1;
				}
				else if (getMark(row, (2 - row)) != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 *  this is helper method that help the display method
	 *
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 *  this is helper method that help the display method
	 *
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * this is helper method that help the display method
	 *
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
	/**
	 * this function checks if the place is full aske the player to chose another one
	 */
	public boolean checkAvailability(int row, int column) {
	
		if(theBoard[row][column]=='O'||theBoard[row][column]=='X') {
			return true;
		}

		return false;
	}


	
}
