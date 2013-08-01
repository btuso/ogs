/**
 * 
 */
package ogs.main;

import java.net.Socket;

import ogs.main.helpers.ItemHelper;
import ogs.main.helpers.MapHelper;
import ogs.main.helpers.PlayerHelper;
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
		MapHelper mapHelper = new MapHelper();
		ItemHelper itemHelper = new ItemHelper();
		
		
		socketServer.startListening();
	}

}
