package com.busy.apis.entities.matrix;

import java.util.Arrays;

public class MatrixDistanciaRegions {
	

	private Long[] travelTimes;
	private Long[] distances;
	
	public MatrixDistanciaRegions() {

	}
	
	
	public Long[] getDistances() {
		return distances;
	}


	public MatrixDistanciaRegions(int numOrigins, int numDestinations, Long[] travelTimes, Long[] distances) {
		super();
//		this.numOrigins = numOrigins;
//		this.numDestinations = numDestinations;
		this.travelTimes = travelTimes;
		this.distances = distances;
	}


	public void setDistances(Long[] distances) {
		this.distances = distances;
	}

//
//	public int getNumOrigins() {
//		return numOrigins;
//	}
//	public void setNumOrigins(int numOrigins) {
//		this.numOrigins = numOrigins;
//	}
//	public int getNumDestinations() {
//		return numDestinations;
//	}
//	public void setNumDestinations(int numDestinations) {
//		this.numDestinations = numDestinations;
//	}
	public Long[] getTravelTimes() {
		return travelTimes;
	}
	public void setTravelTimes(Long[] travelTimes) {
		this.travelTimes = travelTimes;
	}


	
	
}
