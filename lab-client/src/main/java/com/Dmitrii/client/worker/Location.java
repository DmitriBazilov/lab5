package com.Dmitrii.client.worker;

import java.util.List;
import java.util.ArrayList;

public class Location {

	private Double x;
	private long y;
	private int z;

	public Location() {
	}

	public Location(Double x, long y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public void setY(long y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public Double getX() {
		return x;
	}
	
	public long getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public String[] toStringArray() {
		List<String> list = new ArrayList<String>();
		list.add(x.toString());
		list.add(Long.toString(y));
		list.add(Integer.toString(z));
		String[] result = new String[3];
		return list.toArray(result);
	}
}
