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