package ogs.main.server.protocol;

import ogs.main.server.messages.client.ConnectionRequestMessage;
import ogs.main.server.messages.client.DefaultClientMessage;

public enum ClientMessages {
	CONNECTION_REQUEST(JSONMessageFlags.HEADER_CONNECTION_REQUEST, ConnectionRequestMessage.class);
	
	private String header;
	private Class<? extends DefaultClientMessage> runnableClass;
	
	private ClientMessages(String header, Class<? extends DefaultClientMessage> runnableClass) {
		this.header = header;
		this.runnableClass = runnableClass;
	}
	
	public String getHeader() {
		return header;
	}
	
	public Class<? extends DefaultClientMessage> getRunnableClass() {
		return runnableClass;
	}
}
