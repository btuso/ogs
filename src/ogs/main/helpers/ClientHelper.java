package ogs.main.helpers;

import java.net.Socket;
import java.util.HashMap;

public class ClientHelper {
	HashMap<String, Socket> clients;
	
	public ClientHelper() {
		clients = new HashMap<>();
	}
	
	public void addClient(String userId, Socket client) {
		clients.put(userId, client);
	}
	
	public Socket getClient(String userId){
		return clients.get(userId);
	}
}
