package ogs.main.map;

import java.util.HashMap;

import javax.jws.HandlerChain;

public class Tile {

	int globalId;
	boolean collide;
	int X;
	int Y;
	int mapNumber;
	
	public Tile(int mapNumber, int X, int Y, boolean collides) {
		this.mapNumber = mapNumber;
		this.X = X;
		this.Y = Y;
		this.collide = collides;
		this.globalId = (mapNumber * Map.MAP_HEIGHT * Map.MAP_WIDTH) + (this.X + (this.Y * Map.MAP_HEIGHT));
	}
	
	public Tile(int mapNumber, int X, int Y) {
		this(mapNumber, X, Y, false);	
	}

	public boolean isCollide() {
		return collide;
	}

	public void setCollide(boolean collide) {
		this.collide = collide;
	}

	public int getGlobalId() {
		return globalId;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public int getMapNumber() {
		return mapNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}

		if(!Tile.class.equals(obj.getClass())){
			return false;
		}
		
		if(this.hashCode() == obj.hashCode()){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.globalId;
	}
}
