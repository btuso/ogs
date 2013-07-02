package ogs.main.thread;

import java.net.ServerSocket;

import ogs.main.thread.runnables.NewConnectionRunnable;

public class ThreadFactory {
	
	public ThreadFactory(){
		
	}
	
	public NewConnectionRunnable makeNewConnectionRunnable(ServerSocket serverSocket){
		NewConnectionRunnable newConnectionRunnable = new NewConnectionRunnable(serverSocket);
//		newConnectionRunnable
		return newConnectionRunnable;
	}
}
