package it.polito.tdp.nyc.model;

import com.javadocmd.simplelatlng.LatLng;

public class City  {

	
	String city;
	LatLng latlng;

	int num;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LatLng getLatlng() {
		return latlng;
	}

	public void setLatlng(LatLng latlng) {
		this.latlng = latlng;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public City(String city, LatLng latlng, int num) {
		super();
		this.city = city;
		this.latlng = latlng;
		this.num = num;
	}
	
	
	public String toString() {
		
		return this.city;
	}

	
	
}
