

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

/**
 *   class  FrameTicTac creates a GUI for  Tic Tac game
 * @author Sonia Soleimani
 * @version 1.0
 * @since November 6, 2020
 */
public class FrameTicTac extends JFrame{


	/**
	 * b1, b2,b3, b4,b5,b6, b7,b8 and b9 are the button for Tic Tac Game
	 */
	JButton b1, b2,b3, b4,b5,b6, b7,b8,b9;
	/**
	 * boxMessage, boxName and boxMark  are a text area 
	 */
	private JTextArea boxMessage, boxName,boxMark;
	/**
	 * buttonsPanel, messagePanel and player(i.e. name of the player) Panel are  the panel for this GUI  
	 */
	private JPanel buttonsPanel,messagePanel,playerPanel;
	/**
	 * titleLabel, markLabel and nameLabel are label for this GUI  
	 */
	private JLabel titleLabel,markLabel,nameLabel;
	/**
	 * mark is a sign
	 */
	//	char mark;
	/**
	 * mark1 is a sign just for my JTectArea
	 */
	String mark1;


	/**
	 * Constructs a Frame object that that create a grid Layout  
	 *  and call other panels to complete the frame and the end closing
	 *@param s - name of the GUI
	 *@param mark and mark1 are the same and sign of the player
	 *@param playerName is name of the player
	 */
	public FrameTicTac (String s,String mark1,String playerName) throws IOException {
		super(s);
		//		this.mark=mark;
		this.mark1=mark1;

		setLayout (new GridLayout(2,2,20,20));

		buttonsPanel();
		messagePanel();
		playerPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700, 400);

		setBoxName(playerName);
		setBoxMark(mark1);
	}

	/**
	 * the following method, create a panel just for buttons in the West-North of my original
	 * layout. the layout for this panel is grid layout 
	 * at the end, I add this panel to my original panel
	 */
	public void buttonsPanel() {

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout( new GridLayout(3,3,10,10));


		b1 = new JButton ("");
		b2 = new JButton ("");
		b3 = new JButton ("");
		b4 = new JButton ("");
		b5 = new JButton ("");
		b6 = new JButton ("");
		b7 = new JButton ("");
		b8 = new JButton ("");
		b9 = new JButton ("");


		buttonsPanel.add(b1);
		buttonsPanel.add(b2);
		buttonsPanel.add(b3);
		buttonsPanel.add(b4);
		buttonsPanel.add(b5);
		buttonsPanel.add(b6);
		buttonsPanel.add(b7);
		buttonsPanel.add(b8);
		buttonsPanel.add(b9);


		getContentPane().add( buttonsPanel);   

	}
	/**
	 * the following method, is a helper that add my button to listener
	 */
	public void addCalcListener (ActionListener listenForCalcButton) {

		b1.addActionListener(listenForCalcButton);
		b2.addActionListener(listenForCalcButton);
		b3.addActionListener(listenForCalcButton);
		b4.addActionListener(listenForCalcButton);
		b5.addActionListener(listenForCalcButton);
		b6.addActionListener(listenForCalcButton);
		b7.addActionListener(listenForCalcButton);
		b8.addActionListener(listenForCalcButton);
		b9.addActionListener(listenForCalcButton);

	}


	/**
	 * the following method, create a panel just for messages in the East-North of my original
	 * layout. the layout for this panel is Border layout 
	 * at the end, I add this panel to my original panel
	 */
	public void messagePanel() {
		messagePanel = new JPanel();

		messagePanel.setLayout( new BorderLayout() );
		boxMessage = new JTextArea();
		titleLabel=new JLabel("Message Window:");
		boxMessage.setEditable(false);


		messagePanel.add(titleLabel, "North");
		messagePanel.add(boxMessage, "Center");

		getContentPane().add( messagePanel);    // Add Panel1 to East-North


	}


	/**
	 * the following method, create a panel just for printing the name of player and its mark in the East-North of my original
	 * layout. the layout for this panel is grid layout 
	 * at the end, I add this panel to  original panel
	 */
	public void playerPanel() {
		playerPanel = new JPanel();

		playerPanel.setLayout( new GridLayout(2,2,5,5) );




		markLabel=new JLabel("   Player");
		nameLabel=new JLabel("   User Name");
		boxName = new  JTextArea();
		boxMark = new  JTextArea();

		boxName.setEditable(false);
		boxMark.setEditable(false);

		playerPanel.add(markLabel);
		playerPanel.add(boxMark);
		playerPanel.add(nameLabel);
		playerPanel.add(boxName);


		getContentPane().add( playerPanel);  // Add player(name) Panel to West-South
	}

	/**
	 * setters for BoxMessage, setBoxName and BoxMark  
	 */


	public void setBoxMessage(String boxmessage) {
		boxMessage.setText(boxmessage); 
	}

	public void setBoxName(String boxname) {
		boxName.setText(boxname);
	}

	public void setBoxMark(String boxmark) {
		boxMark.setText(boxmark);
	}





}
