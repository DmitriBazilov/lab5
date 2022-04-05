package com.Dmitrii.client.worker;

public class Coordinates {

	private double x;
	private long y;

	public Coordinates() {
	}

	public Coordinates(double x, long y) {
		this.x = x;
		this.y = y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(long y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public long getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Coordinates{" + "x=" + x + ", y=" + y + '}';
	}
}
