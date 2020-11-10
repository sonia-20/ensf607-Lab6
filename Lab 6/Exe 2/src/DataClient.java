


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
*this class asks the client to select either data or time, and sends the entry  through socket
*@author Sonia Soleimani
*@version 
*/
public class DataClient {

	private Socket aSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	private BufferedReader stdIn;
/**
*constructs sockets, reader and writer
*/
	public DataClient(String serverName, int portNumber) {
		try {
			aSocket = new Socket(serverName, portNumber);
//			keyboard input stream
			stdIn = new BufferedReader(new InputStreamReader(System.in));
//			socket input stream
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter(aSocket.getOutputStream(),true);

		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
/**
*communicates with the user and server
*/
	public void communicate() {
		String line = "";
		String response = "";

		while (!line.equals("QUIT")) {
try {
	
	System.out.println("Please select an option:(DATE/TIME):");
	line = stdIn.readLine();//read line from the user
	socketOut.println(line);
	response = socketIn.readLine();//read response from the socket
	System.out.println("Response is: "+response);
	
	
} catch (IOException e) {
	e.printStackTrace();
}

		}
		try {
			stdIn.close();
				socketIn.close();
				socketOut.close();
				}catch (IOException e) {}
	}

	public static void main(String[] args) throws IOException {
		DataClient aClient = new DataClient("localhost", 9090);
		aClient.communicate();

	}
}
