package wechat.model;

public class BaseRestElement {
	
	private int status_code;
	private String status_message;
	
	
	
	public BaseRestElement(int status_code, String status_message) {
		super();
		this.status_code = status_code;
		this.status_message = status_message;
	}
	public int getStatus_code() {
		return status_code;
	}
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	public String getStatus_message() {
		return status_message;
	}
	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}
	
	

}
