package com.busy.apis.entities.matrix;

public class Nota {
	
	private String exist;
	private String success;
	
	private Data data;
	
	public Nota() {
		
	}

	
	public Nota(String exist, String success, Data data) {
		super();
		this.exist = exist;
		this.success = success;
		this.data = data;
	}


	public String getExist() {
		return exist;
	}

	public void setExist(String exist) {
		this.exist = exist;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
	
	
}
