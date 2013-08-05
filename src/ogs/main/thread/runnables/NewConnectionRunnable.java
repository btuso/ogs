package ogs.main.thread.runnables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import ogs.main.server.messages.client.DefaultClientMessage;
import ogs.main.server.protocol.ClientMessages;
import ogs.main.server.protocol.JSONMessageFlags;

import org.json.JSONArray;
import org.json.JSONException;

public class NewConnectionRunnable implements Runnable,JSONMessageFlags{

	Socket client = null;
	
	public NewConnectionRunnable(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		//TODO Send update message
		while(true){
		    BufferedReader in;
			try {
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String result = "";
		        String inputLine;
				while ((inputLine = in.readLine()) != null) {
					result = result.concat(inputLine);  
					processMessage(new JSONArray(result));
		        }
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void processMessage(JSONArray message) throws JSONException, InstantiationException, IllegalAccessException {
		String header = message.getJSONObject(0).getString(HEADER);
		DefaultClientMessage messageInstance = ClientMessages.valueOf(header).getRunnableClass().newInstance();
		messageInstance.readData(message);
		new Thread(messageInstance).start();
	}

	
}
