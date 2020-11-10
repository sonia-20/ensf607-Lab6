package Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * The Class Server.
 * @author Sonia Soleimani
 * @version 1.0
 * @since November 6, 2020
 */


public class Server {

	/** The a socket. */
	private Socket aSocket;

	/** The server socket. */
	private ServerSocket serverSocket;

	/** The x out. */
	private PrintWriter xOut;

	/** The x in. */
	private BufferedReader xIn;

	/** The o out. */
	private PrintWriter oOut;

	/** The o in. */
	private BufferedReader oIn;

	/** The pool. */
	private ExecutorService pool;

	/** The o. */
	String X,O;

	/** The game. */
	Game game ;



	/**
	 * Instantiates a new server.
	 */
	public Server() {
		try {
			serverSocket = new ServerSocket(9090);
			//			
			pool = Executors.newFixedThreadPool(2);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Run server.
	 */
	public void runServer() {
		try {
			ArrayList<Socket> list = new ArrayList<Socket>();
			while (true) {


				aSocket = serverSocket.accept();
				PrintWriter out = new PrintWriter((aSocket.getOutputStream()), true);
				BufferedReader In = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));

				if (list.size() == 0) {
					System.out.println("Connection accepted by server and the player is X");
					out.println("X Player for Tic tak");
					out.println("X");
					X= In.readLine();
				}
				else {
					System.out.println("Connection accepted by server  and the player is O");
					out.println("O Player for Tic tak");
					out.println("O");
					O= In.readLine();
				}

				list.add(aSocket);
				System.out.println(list.size());
				if (list.size()== 2) {
					this.game = new Game(list.get(0), list.get(1),X,O);
					list.clear();
					pool.execute(game);
				}



			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
			pool.shutdown();
		}try {
			xIn.close();
			xOut.close();
			oIn.close();
			oOut.close();
			aSocket.close();
		}catch(IOException e) {}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		Server myServer = new Server();
		myServer.runServer();
	}

}

