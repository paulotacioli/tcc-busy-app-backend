package com.busy.apis.entities.matrix;

public class ResponseLoginMotorista {
	

	
	private boolean success;
	private String message;
	private String username;
	private String password;
	public ResponseLoginMotorista() {
		
	}







	public boolean isSuccess() {
		return success;
	}







	public void setSuccess(boolean success) {
		this.success = success;
	}







	public String getUsername() {
		return username;
	}







	public void setUsername(String username) {
		this.username = username;
	}







	public String getPassword() {
		return password;
	}







	public void setPassword(String password) {
		this.password = password;
	}







	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public ResponseLoginMotorista(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	
	
	
}
