package com.busy.apis.entities.matrix;

public class DistanceGoogle {
	
	private String text;
	private Long value;

	
	public DistanceGoogle() {
		
	}


	public DistanceGoogle(String text, Long value) {
		super();
		this.text = text;
		this.value = value;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public long getValue() {
		return value;
	}


	public void setValue(Long value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "DistanceGoogle [text=" + text + ", value=" + value + "]";
	}

	
	
	
	
	
}
