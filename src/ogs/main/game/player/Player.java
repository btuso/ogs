package ogs.main.game.player;


import java.net.Socket;

import ogs.main.Main;
import ogs.main.entity.Attributes;
import ogs.main.helpers.MapHelper;
import ogs.main.map.Tile;

public class Player {
	private String userId;
	private String username;
	private Tile currentTile;
	private Attributes attributes;
	private Equipment equipment;
	
	private Integer hp;
	private Integer mp;
	
	public Player(String userId, String username) {
		this.userId = userId;
		this.username = username;
		attributes = new Attributes(3,3,3,3);
		hp = attributes.getEndurance() * 10;
		mp = attributes.getIntelligence() * 10;
		this.currentTile = Main.getMapHelper().getAvailablePlayerSpawnTileFromMap(MapHelper.MAP_ID);
		Main.getMapHelper().getMaps().get(MapHelper.MAP_ID).blockFreeTile(currentTile);
		
	}

	public String getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public Tile getCurrentTile() {
		return currentTile;
	}

	public void setCurrentTile(Tile currentTile) {
		this.currentTile = currentTile;
	}

	@Override
	public int hashCode() {
		return userId.hashCode();
	}

	public Attributes getAttributes() {
		return attributes;
	}
	
	public Integer getHP(){
		return hp;
	}

	public Integer getMP(){
		return mp;
	}

	public Integer getMaxHP(){
		return getEndurance() * 10;
	}

	public Integer getMaxMP(){
		return getIntelligence() * 10;
	}
	
	public Integer getHPPercentage(){
		return (getHP() * 100) / getMaxHP();
	}

	public Integer getMPPercentage(){
		return (getMP() * 100) / getMaxMP();
	}
	
	public int getDefense() {
		return (attributes.getDefense() + equipment.getDefense());
	}


	public int getEndurance() {
		return (attributes.getEndurance() + equipment.getEndurance());
	}


	public int getIntelligence() {
		return (attributes.getIntelligence()+ equipment.getIntelligence());
	}


	public int getPower() {
		return (attributes.getPower() + equipment.getPower());
	}
}
