package ogs.main.server.messages.client;

import java.net.Socket;

import ogs.main.server.protocol.JSONMessageFlags;

import org.json.JSONArray;

public interface DefaultClientMessage extends Runnable, JSONMessageFlags{
	void setClient(Socket client);
	
	void readData(JSONArray data);
}
