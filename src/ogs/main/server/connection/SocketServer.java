package ogs.main.server.connection;

import java.io.IOException;
import java.net.ServerSocket;

import ogs.main.thread.ThreadFactory;

public class SocketServer {
	private static Integer PORT = 4444;
	ThreadFactory threadFactory;
	
	public void startListening(){
		ServerSocket serverSocket = null;
		threadFactory = new ThreadFactory();
		try {
			serverSocket = new ServerSocket(PORT);
			Thread connectionListenerThread = threadFactory.makeConnectionListenerRunnableThread(serverSocket);
			connectionListenerThread.start();
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + PORT + ".");
		}
	}
}
	

//	        Socket clientSocket = null;
//	        try {
//	            clientSocket = serverSocket.accept();
//	        } catch (IOException e) {
//	            System.err.println("Accept failed.");
//	            System.exit(1);
//	        }
//
//	        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//	        BufferedReader in = new BufferedReader(
//					new InputStreamReader(
//					clientSocket.getInputStream()));
//	        String inputLine, outputLine;
//
//	        out.close();
//	        in.close();
////	        clientSocket.close();
