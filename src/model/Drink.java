package model;

import java.io.Serializable;

public class Drink implements Serializable {

	private int idbrink; // 不顯示
	private String username;
	private String name;
	private int peach; // 密桃奶茶 60
	private int melon; // 冷露歐雷 65
	private int brown; // 黑糖鮮奶 75

	public Drink() {
		super();
	}

	public Drink(String name, int peach, int melon, int brown) {
		super();
		this.name = name;
		this.peach = peach;
		this.melon = melon;
		this.brown = brown;
	}

	public Drink(String username, String name, int peach, int melon, int brown) {
		super();
		this.username = username;
		this.name = name;
		this.peach = peach;
		this.melon = melon;
		this.brown = brown;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPeach() {
		return peach;
	}

	public void setPeach(int peach) {
		this.peach = peach;
	}

	public int getMelon() {
		return melon;
	}

	public void setMelon(int melon) {
		this.melon = melon;
	}

	public int getBrown() {
		return brown;
	}

	public void setBrown(int brown) {
		this.brown = brown;
	}

}
