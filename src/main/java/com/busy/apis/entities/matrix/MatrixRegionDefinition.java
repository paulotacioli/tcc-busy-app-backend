package com.busy.apis.entities.matrix;

public class MatrixRegionDefinition {
	
	private String type;
	private MatrixDistanciaLatitudeLongitude center;
	private int radius;
	
	
	public MatrixRegionDefinition() {
		

	}
	public MatrixRegionDefinition(String type, MatrixDistanciaLatitudeLongitude center, int radius) {
		super();
		this.type = type;
		this.center = center;
		this.radius = radius;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MatrixDistanciaLatitudeLongitude getCenter() {
		return center;
	}
	public void setCenter(MatrixDistanciaLatitudeLongitude center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	
}
