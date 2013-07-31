package ogs.main.map;

import java.util.Set;

import org.json.JSONObject;

public class MobSpawn {
	public static String MOB_FLAG = "MobFlag";
	public static String MOB_AMOUNT = "MobAmount";
	public static String MOB_SPAWN_TIME = "SpawnTime";
	public static String MOB_SPAWN_ENABLED = "enabled";
	
	private Set<Tile> tiles;
	private Integer mobFlag;
	private Integer mobAmount;
	private double spawnTime;
	private boolean enabled;
	
	public MobSpawn(Set<Tile> tiles, JSONObject properties) {
		this.tiles = tiles;
		this.mobFlag = properties.getInt(MOB_FLAG);
		this.mobAmount = properties.getInt(MOB_AMOUNT);
		this.spawnTime = properties.getDouble(MOB_SPAWN_TIME);
		this.enabled = properties.getBoolean(MOB_SPAWN_ENABLED);
		
		//register spawner with mobhelper
	}
	
	public boolean isEnabled() {
		return enabled;
	}
/*
 * Carga de sqlite
 * MobHelper
 * Playerhelper
 * 	ItemHelper
 * CombatHelper
 * MessageHelper
 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Tile> getTiles() {
		return tiles;
	}

	public Integer getMobFlag() {
		return mobFlag;
	}

	public Integer getMobAmount() {
		return mobAmount;
	}

	public double getSpawnTime() {
		return spawnTime;
	}
}
