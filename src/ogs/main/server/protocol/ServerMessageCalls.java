package ogs.main.server.protocol;

import java.net.Socket;
import java.util.HashSet;

import ogs.main.game.player.Player;
import ogs.main.map.Tile;

public interface ServerMessageCalls {

	void sendMapSyncMessage(final Socket socket, HashSet<Tile> entityCollisionTiles, HashSet<Player> players,mobs);
}
