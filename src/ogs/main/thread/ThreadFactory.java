package ogs.main.thread;

import java.net.ServerSocket;
import java.net.Socket;

import ogs.main.thread.runnables.ConnectionListenerRunnable;
import ogs.main.thread.runnables.NewConnectionRunnable;

public class ThreadFactory {
	
	public ThreadFactory(){ 
		
	}
	
	public Thread makeConnectionListenerRunnableThread(ServerSocket serverSocket){
		ConnectionListenerRunnable connectionListenerRunnable = new ConnectionListenerRunnable(serverSocket);
        return new Thread(connectionListenerRunnable); 
	}
	
	public Thread makeNewConnectionRunnableThread(Socket clientSocket){
		NewConnectionRunnable newConnectionRunnable = new NewConnectionRunnable(clientSocket);
        return new Thread(newConnectionRunnable); 
	}
	
}
