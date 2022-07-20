package com.busy.apis.entities.matrix;

public class MatrixDistanciaRequest {
	
	private MatrixDistanciaLatitudeLongitude[] origins;
	private MatrixDistanciaLatitudeLongitude[] destinations;
	private MatrixRegionDefinition regionDefinition;
	private String routingMode;
	private String transportMode;
	private String[] matrixAttributes;
	
	public MatrixDistanciaRequest() {
		

	}
	public MatrixDistanciaLatitudeLongitude[] getOrigins() {
		return origins;
	}
	public void setOrigins(MatrixDistanciaLatitudeLongitude[] origins) {
		this.origins = origins;
	}
	public MatrixDistanciaLatitudeLongitude[] getDestinations() {
		return destinations;
	}
	public void setDestinations(MatrixDistanciaLatitudeLongitude[] destinations) {
		this.destinations = destinations;
	}
	public MatrixRegionDefinition getRegionDefinition() {
		return regionDefinition;
	}
	public void setRegionDefinition(MatrixRegionDefinition regionDefinition) {
		this.regionDefinition = regionDefinition;
	}
	public String getRoutingMode() {
		return routingMode;
	}
	public void setRoutingMode(String routingMode) {
		this.routingMode = routingMode;
	}
	public String getTransportMode() {
		return transportMode;
	}
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	public String[] getMatrixAttributes() {
		return matrixAttributes;
	}
	public void setMatrixAttributes(String[] matrixAttributes) {
		this.matrixAttributes = matrixAttributes;
	}
	
	
	
}
