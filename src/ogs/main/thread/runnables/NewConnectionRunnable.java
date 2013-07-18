package ogs.main.thread.runnables;

import java.net.ServerSocket;
import java.net.Socket;

public class NewConnectionRunnable implements Runnable{

	Socket client = null;
	
	public NewConnectionRunnable(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		
	}

	
}
