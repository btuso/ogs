package ogs.main.server.protocol;

public interface JSONMessageFlags {
	//CLIENT MESSAGE HEADERS
	public static final String HEADER_CONNECTION_REQUEST = "connectionRequest";
	
	//SERVER MESSAGE HEADERS
	public static final String HEADER_MAP_SYNC = "mapSync";
	
	//JSON KEYS
	public static final String HEADER = "header";
	public static final String USER_ID = "userId";
	public static final String USERNAME = "username";
	public static final String COLLIDING_TILES = "collidingTiles";
	public static final String PLAYERS = "players";
	public static final String X = "x";
	public static final String Y = "y";
	public static final String HP = "hp";
	public static final String TILE = "tile";
}
