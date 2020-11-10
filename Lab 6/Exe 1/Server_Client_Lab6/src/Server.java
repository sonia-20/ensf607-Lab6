
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
/**
 * This class is the server side which checks if the entry from client side is palindrome or not and sends comments on it.
 * 
 * @author Sonia Soleimani
 * @version 
 */
public class Server {
	private Socket aSocket;
	private ServerSocket serverSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
/**
 * constructs a socket with a specific port
 */
	public Server() {
		try {
			serverSocket = new ServerSocket(8099);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
/**
 * this method checks that is a word is a palindrme or not
 */
	boolean isPalindrome(String s) {
		int n = s.length();
		for (int i = 0; i < (n / 2); ++i) {
			if (s.charAt(i) != s.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
	}
/**
 * this method send a result to the client side
 */
	public void palindromeTest() {
		String line = null;
		while (true) {
			try {
				line = socketIn.readLine();
				if (line.equals("QUIT")) {
					line = "Good Bye!";
					socketOut.println(line);
					break;
				} else {
					if (isPalindrome(line)==false) {
						socketOut.println(line + " is not a Palindrome");
					} else {
						socketOut.println(line + " is a Palindrome");
					}
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Server myServer = new Server();
		try {
//      connection is accepted here
			myServer.aSocket = myServer.serverSocket.accept();
			System.out.println("Connection accepted by server");
			myServer.socketIn = new BufferedReader(new InputStreamReader(myServer.aSocket.getInputStream()));
			myServer.socketOut = new PrintWriter((myServer.aSocket.getOutputStream()), true);
			myServer.palindromeTest();
			;

			myServer.socketIn.close();
			myServer.socketOut.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
