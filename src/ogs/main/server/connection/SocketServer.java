package ogs.main.server.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import ogs.main.executor.Executor;
import ogs.main.thread.ThreadFactory;

public class SocketServer {
	private static Integer PORT = 4444;
	
	public void start(){
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + PORT + ".");
		}
	}
	
	public static void main(String[] args) throws IOException {


//	        Socket clientSocket = null;
//	        try {
//	            clientSocket = serverSocket.accept();
//	        } catch (IOException e) {
//	            System.err.println("Accept failed.");
//	            System.exit(1);
//	        }

	        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	        BufferedReader in = new BufferedReader(
					new InputStreamReader(
					clientSocket.getInputStream()));
	        String inputLine, outputLine;

	        out.close();
	        in.close();
//	        clientSocket.close();
	    }
}
