package com.busy.apis.entities.matrix;

public class ElementsGoogle {
	
	private DistanceGoogle distance;
	private DistanceGoogle duration;
	private String status;
	
	public ElementsGoogle() {
		
	}

	public ElementsGoogle(DistanceGoogle distance, DistanceGoogle duration, String status) {
		super();
		this.distance = distance;
		this.duration = duration;
		this.status = status;
	}

	public DistanceGoogle getDistance() {
		return distance;
	}

	public void setDistance(DistanceGoogle distance) {
		this.distance = distance;
	}

	public DistanceGoogle getDuration() {
		return duration;
	}

	public void setDuration(DistanceGoogle duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ElementsGoogle [distance=" + distance + ", duration=" + duration + ", status=" + status + "]";
	}

	
	
	
	
}
