

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 * class  ControllerTicTac manages  model and view and action listener lives 
 * @author Sonia Soleimani
 * @version 1.0
 * @since November 6, 2020
 */

public class ControllerTicTac {
	/**
	 * frame_X_Player and frame_O_Player  are   objects of class   FrameTicTac(View)
	 */
	FrameTicTac Frame;
	/**
	 * game is a object of class  Game (Model)
	 */
	/**
	 * row and col are row and column in my game
	 */


	String mark;
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	int col_target=5;
	int row_target=5;

	public int getCol_target() {
		return col_target;
	}

	public void setCol_target(int col_target) {
		this.col_target = col_target;
	}

	public int getRow_target() {
		return row_target;
	}

	public void setRow_target(int row_target) {
		this.row_target = row_target;
	}
	/**
	 * opponent is integer that turn or call the oppenet to play the game
	 */
	int opponent=2;
	String flag="No";

	int row;
	int col;


	

	/**
	 * Constructs a Controller by assign game and two fame and calling the action listener   
	 *@param frame_X_Player and frame_O_Player are objects of my frame
	 *@param game is a logic of my game and start the game
	 */
	public ControllerTicTac(String s,String mark1,String playerName) throws IOException {



		this.Frame=new FrameTicTac(s,mark1,playerName);	

		Frame.addCalcListener(new MyListener());


	}



	/**
	 * this is inner class is called   MyListener and implements the ActionListener
	 */
	class MyListener implements ActionListener {
		/**
		 * his method performs action by taking an event and also calling  helper method
		 */
		@Override
		public void actionPerformed(ActionEvent e) {




			if(e.getSource() == Frame.b1) {
				if(lock()) {
					setRow(0);
					setCol(0);
					setFlag("Yes");
					setAction("false");
				}



			}
			else if(e.getSource() == Frame.b2) {
				if(lock()) {
					setRow(0);
					setCol(1);
					setFlag("Yes");
					setAction("false");
				}
			}
			else if(e.getSource() == Frame.b3) {
				if(lock()) {
					setRow(0);
					setCol(2);
					setFlag("Yes");
					setAction("false");
				}
			}
			else if(e.getSource() == Frame.b4) {
				if(lock()) {
					setRow(1);
					setCol(0);
					setFlag("Yes");
					setAction("false");
				}
			}
			else if(e.getSource() == Frame.b5) {
				if(lock()) {
					setRow(1);
					setCol(1);
					setFlag("Yes");
					setAction("false");
				}
			}
			else if(e.getSource() == Frame.b6) {
				if(lock()) {
					setRow(1);
					setCol(2);
					setFlag("Yes");
					setAction("false");
				}
			}
			else if(e.getSource() == Frame.b7) {
				if(lock()) {
					setRow(2);
					setCol(0);
					setFlag("Yes");
					setAction("false");
				}
			}
			else if(e.getSource() == Frame.b8) {
				if(lock()) {
					setRow(2);
					setCol(1);
					setFlag("Yes");
					setAction("false");
				}
			}
			else if(e.getSource() == Frame.b9) {
				if(lock()) {
					setRow(2);
					setCol(2);
					setFlag("Yes");
					setAction("false");
				}
			}
		}
	}

	public void markOpponentMove(String mark,int row,int col) {

		if(row==0 && col==0) {
			Frame.b1.setText(mark);
		}
		else if(row==0 && col==1) {
			Frame.b2.setText(mark);
		}
		else if(row==0 && col==2) {
			Frame.b3.setText(mark);
		}
		else if(row==1 && col==0) {
			Frame.b4.setText(mark);
		}
		else if(row==1 && col==1) {
			Frame.b5.setText(mark);
		}
		else if(row==1 && col==2) {
			Frame.b6.setText(mark);
		}
		else if(row==2 && col==0) {
			Frame.b7.setText(mark);
		}
		else if(row==2 && col==1) {
			Frame.b8.setText(mark);
		}
		else if(row==2 && col==2) {
			Frame.b9.setText(mark);
		}

	} 



	public boolean moving() {
		if(flag.equals("Yes")) {

			return true;
		}
		return false;
	}



	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}




	String action ="false";
	public boolean lock() {
		if(action.equals("true")) {
			return true;
		}
		return false;
	}

	public void setAction(String action) {
		this.action = action;
	}


}

