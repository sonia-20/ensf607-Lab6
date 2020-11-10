

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * The Class Client.
 * @author Sonia Soleimani
 * @version 1.0
 * @since November 6, 2020
 */
public class Client {

	/** The a socket. */
	private Socket aSocket;

	/** The socket out. */
	private PrintWriter socketOut;

	/** The socket in. */
	private BufferedReader socketIn;

	/** The controller tic tac. */
	ControllerTicTac controllerTicTac;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new client.
	 *
	 * @param serverName the server name
	 * @param portNumber the port number
	 */
	public Client(String serverName, int portNumber) {
		try {

			aSocket = new Socket(serverName, portNumber);
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter(aSocket.getOutputStream(), true);

			String ticName = socketIn.readLine();
			String mark = socketIn.readLine();
			String name = gettingNamePlayer();
			this.name = name;
			this.controllerTicTac = new ControllerTicTac(ticName, mark, name);
			socketOut.println(name);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	/**
	 * Communicate.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void communicate() throws IOException {

		while (true) {
			String line = socketIn.readLine();
			if (line.equals("END")) {
				controllerTicTac.Frame.setBoxMessage(line);
				String line2 = socketIn.readLine();
				controllerTicTac.Frame.setBoxMessage(line2);
			} 
			else if (line.equals("PLAY")) {
				controllerTicTac.setAction("true");
				while (true) {
					System.out.print("");
					controllerTicTac.Frame.setBoxMessage(name+" is your turn");
					if (controllerTicTac.moving()) {

						int col = controllerTicTac.getCol();
						int row = controllerTicTac.getRow();
						socketOut.println(row);
						socketOut.println(col);

						line = socketIn.readLine();
						if (!line.equals("false")) {

							if (line.equals("X")) {
								String mark = "X";
								controllerTicTac.setRow_target(row);
								controllerTicTac.setCol_target(col);
								controllerTicTac.markOpponentMove(mark, row, col);
								controllerTicTac.setFlag("No");
								break;
							} else if (line.equals("O")) {
								String mark = "O";
								controllerTicTac.setRow_target(row);
								controllerTicTac.setCol_target(col);
								controllerTicTac.markOpponentMove(mark, row, col);
								controllerTicTac.setFlag("No");
								break;
							}
						}
					}
				}
			}

			else if (line.equals("WAIT")) {
				controllerTicTac.Frame.setBoxMessage(name+", please wait");
				String input = socketIn.readLine();
				char rows = input.charAt(0);
				char cols = input.charAt(2);
				if (input.charAt(1) == 'X') {
					String mark = "X";
					controllerTicTac.setRow_target(Integer.parseInt(String.valueOf(rows)));
					controllerTicTac.setRow_target(Integer.parseInt(String.valueOf(cols)));
					controllerTicTac.markOpponentMove(mark, Integer.parseInt(String.valueOf(rows)),Integer.parseInt(String.valueOf(cols)));

				} else if (input.charAt(1) == 'O') {
					String mark = "O";
					controllerTicTac.setRow_target(Integer.parseInt(String.valueOf(rows)));
					controllerTicTac.setRow_target(Integer.parseInt(String.valueOf(cols)));
					controllerTicTac.markOpponentMove(mark, Integer.parseInt(String.valueOf(rows)),Integer.parseInt(String.valueOf(cols)));

				}

			}

		}

	}



	/**
	 * Gets the name player.
	 *
	 * @return the  name player
	 */
	public String gettingNamePlayer() {
		String PlayerName;
		PlayerName = JOptionPane.showInputDialog("Please enter the name of the  player: ");
		while (PlayerName == null ||PlayerName.equals("") ||  PlayerName.equals(" ")) {

			PlayerName = JOptionPane.showInputDialog("Please enter the name of the player: ");
		}
		return PlayerName;
	}





	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		Client client = new Client("localhost", 9090);
		client.communicate();

	}
}