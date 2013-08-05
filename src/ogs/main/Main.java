/**
 * 
 */
package ogs.main;

import java.util.HashMap;

import ogs.main.helpers.ClientHelper;
import ogs.main.helpers.MapHelper;
import ogs.main.helpers.PlayerHelper;
import ogs.main.server.connection.SocketServer;

/**
 * @author Bernardo Tuso
 *
 */
public class Main {

	private static PlayerHelper playerHelper;
	private static MapHelper mapHelper;
	private static SocketServer socketServer;
	private static ClientHelper clientHelper;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		socketServer = new SocketServer();
//		ItemHelper itemHelper = new ItemHelper();
		mapHelper = new MapHelper();
		playerHelper = new PlayerHelper();
		clientHelper = new ClientHelper();
		
		socketServer.startListening();
	}

	public static PlayerHelper getPlayerHelper() {
		return playerHelper;
	}

	public static MapHelper getMapHelper() {
		return mapHelper;
	}

	public static SocketServer getSocketServer() {
		return socketServer;
	}
	
	public static ClientHelper getClientHelper() {
		return clientHelper;
	}
}
