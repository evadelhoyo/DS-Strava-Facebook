package es.deusto.ingenieria.sd.strava.facebook.server;

import java.net.ServerSocket;
import java.rmi.Naming;

import es.deusto.ingenieria.sd.strava.facebook.remote.LoginFacebookGateway;
import es.deusto.ingenieria.sd.strava.facebook.remote.ILoginFacebookGateway;

public class LoginFacebookServer {

private static int numClients = 0;
	
	public static void main(String args[]) {
		if (args.length < 1) {
			System.err.println(" # Usage: TCPSocketEchoServer [PORT]");
			System.exit(1);
		}
		
		//args[1] = Server socket port
		int serverPort = Integer.parseInt(args[0]);
		
		//Declaration of the ServerSocket (only a port number is needed)
		try (ServerSocket tcpEchoServerSocket = new ServerSocket(serverPort);) {
			System.out.println(" - FBSocketServer: Waiting for connections '" + tcpEchoServerSocket.getInetAddress().getHostAddress() + ":" + tcpEchoServerSocket.getLocalPort() + "' ...");
			
			//The main thread is always waiting for connections
			while (true) {
				//When a connection from a client is received, a new EchoService is created. The "accept()" method returns the socket to
				//communicate with the client.
				new FacebookService(tcpEchoServerSocket.accept());
				System.out.println(" - FBSocketServer: New client connection accepted. Client Number: " + numClients++);
			}
		} catch (Exception e) {
			System.out.println("# EchoServer: IO error:" + e.getMessage());
		}
	}
}