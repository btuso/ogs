package ogs.main.thread.runnables;

import java.io.IOException;
import java.net.ServerSocket;

import ogs.main.thread.ThreadFactory;

public class ConnectionListenerRunnable implements Runnable{

	ServerSocket serverSocket = null;
	ThreadFactory threadFactory;
	
	public ConnectionListenerRunnable(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
		threadFactory = new ThreadFactory();
	}
	
	@Override
	public void run() {
		 try {
			 while(true){
	          Thread newConnectedClient = threadFactory.makeNewConnectionRunnableThread(serverSocket.accept());
	          System.err.println("Nuevo cliente, arrancandolo");
	          newConnectedClient.start();
			 }
	     } catch (IOException e) {
	            System.err.println("Accept failed.");
	            System.exit(1);
	     }
	}

	
}
