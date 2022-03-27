package com.Dmitrii.client.worker;

public class Person {

	private Integer weight;
	private Color eyeColor;
	private Color hairColor;
	private Location location;

	public Person() {
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setEyeColor(Color color) {
		this.eyeColor = color;	
	}

	public Color getEyeColor() {
		return eyeColor;
	}

	public void setHairColor(Color color) {
		this.hairColor = color;
	}

	public Color getHairColor() {
		return hairColor;
	}

	public void setLocation(Location loc) {
		location = loc;
	}

	public Location getLocation() {
		return location;
	}

}
