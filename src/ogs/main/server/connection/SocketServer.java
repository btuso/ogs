package ogs.main.server.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;

import org.json.JSONArray;
import org.json.JSONObject;

import ogs.main.game.player.Player;
import ogs.main.map.Tile;
import ogs.main.server.protocol.JSONMessageFlags;
import ogs.main.server.protocol.ServerMessageCalls;
import ogs.main.thread.ThreadFactory;
import ogs.utils.JSONMaker;

public class SocketServer implements ServerMessageCalls, JSONMessageFlags{
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
	
	private void sendMessage(final Socket socket, final JSONArray message) throws IOException {
		final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		Runnable sender = new Runnable() {
			
			@Override
			public void run() {
				out.println(message.toString());
				out.close();
			}
		};
		new Thread(sender).start();
	}
	
	private void sendMessage(final Socket socket, final JSONObject message) throws IOException {
		JSONArray array = new JSONArray();
		array.put(message);
		sendMessage(socket, array);
	}

	@Override
	public void sendMapSyncMessage(final Socket socket, HashSet<Tile> entityCollisionTiles, HashSet<Player> players) {
		try {
			JSONArray message = new JSONArray();
			JSONObject header = new JSONObject();
			JSONObject collideTiles = new JSONObject();
			JSONObject jplayers = new JSONObject();
			
			header.put(HEADER,HEADER_MAP_SYNC);
			message.put(header);
			
			collideTiles.put(COLLIDING_TILES, JSONMaker.makeTilesJSONArray(entityCollisionTiles));
			message.put(collideTiles);
			
			jplayers.put(PLAYERS, JSONMaker.makePlayersUpdateJsonArray(players));
			message.put(jplayers);
			
			sendMessage(socket, message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}