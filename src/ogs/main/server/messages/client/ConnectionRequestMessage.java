package ogs.main.server.messages.client;

import java.net.Socket;

import ogs.main.Main;
import ogs.main.helpers.MapHelper;
import ogs.main.server.protocol.JSONMessageFlags;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConnectionRequestMessage implements DefaultClientMessage, JSONMessageFlags{

	JSONObject message;
	private String header;
	private String userId;
	private String username;
	private Socket client;
	
	@Override
	public void run() {
		Main.getSocketServer().sendMapSyncMessage(client, Main.getMapHelper().getMaps().get(MapHelper.MAP_ID).getEntityCollisionTiles(), Main.getPlayerHelper().getPlayers());
		Main.getPlayerHelper().registerPlayer(userId, username);
	}

	@Override
	public void readData(JSONArray data) {
		header = data.getString(0);
		message = data.getJSONObject(1);
		setUserId(message);
		setUsername(message);
	}

	@Override
	public void setClient(Socket client) {
		this.client = client;
	}
	
	public Socket getClient() {
		return client;
	}
	
	public String getUserId() {
		return userId;
	}

	private void setUserId(JSONObject json) {
		this.userId = json.getString(USER_ID);
	}

	public String getUsername() {
		return username;
	}

	private void setUsername(JSONObject json) {
		this.username = json.getString(USERNAME);
	}

	public String getHeader() {
		return header;
	}
	

}
