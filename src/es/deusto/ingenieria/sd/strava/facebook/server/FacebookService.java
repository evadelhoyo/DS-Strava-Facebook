package es.deusto.ingenieria.sd.strava.facebook.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * This class process the request of each client as a separated Thread.
 */
public class FacebookService extends Thread {
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;
	private static String DELIMITER = "#";
	
	public FacebookService(Socket socket) {
		try {
			System.out.println("yepa soy lolito gente");
			this.tcpSocket = socket;
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (Exception e) {
			System.out.println("# EchoService - TCPConnection IO error:" + e.getMessage());
		}
	}

	public void run() {
		//Echo server
		try {
			// Read request from the client
			String data = this.in.readUTF();
			System.out.println("   - FacebookService - Received data from '"
					+ tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");

			// Send response to the client
			String response = String.valueOf(loginFB(data));
			this.out.writeUTF(response);

			System.out.println("   - FacebookService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress()
					+ ":" + tcpSocket.getPort() + "' -> '" + response + "'");
		} catch (EOFException e) {
			System.err.println("   # FacebookService - TCPConnection EOF error" + e.getMessage());
		} catch (IOException e) {
			System.err.println("   # FacebookService - TCPConnection IO error:" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (IOException e) {
				System.err.println("   # FacebookService - TCPConnection IO error:" + e.getMessage());
			}
		}
	}
	
	private boolean loginFB(String data) {
		if(data != null && !data.trim().isEmpty()) {
			StringTokenizer tokenizador = new StringTokenizer(data);
			String email = tokenizador.nextToken();
			String comprueba = tokenizador.nextToken();
			
			System.out.println("   - Check if user: " + email + "is valid");
			System.out.println(email + "    " + comprueba);
			if (email.equals(comprueba)) {
				return true;
			} else {
				return false;
			}
			
		}
		return false;
	}
	
}