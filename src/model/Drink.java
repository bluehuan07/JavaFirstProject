package model;

public class Drink {

	private String name;
	private int peach;
	private int melon;
	private int brown;

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
