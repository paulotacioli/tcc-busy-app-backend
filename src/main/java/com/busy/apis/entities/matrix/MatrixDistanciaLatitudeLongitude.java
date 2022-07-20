package com.busy.apis.entities.matrix;

public class MatrixDistanciaLatitudeLongitude {
	
	private Double lat;
	private Double lng;
	
	
	
	public MatrixDistanciaLatitudeLongitude() {
		
	}
	public MatrixDistanciaLatitudeLongitude(Double lat, Double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "MatrixDistanciaLatitudeLongitude [lat=" + lat + ", lng=" + lng + "]";
	}
	
	

}
