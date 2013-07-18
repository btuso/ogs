/**
 * 
 */
package ogs.main;

import java.net.Socket;

import ogs.main.server.connection.SocketServer;

/**
 * @author Bernardo Tuso
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SocketServer socketServer = new SocketServer();
		socketServer.startListening();
	}

}
