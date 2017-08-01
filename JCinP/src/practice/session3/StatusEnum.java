package practice.session3;

public enum StatusEnum {

	OPENED("1") , CLOSED("2") ;

	private String status ;
	
	private StatusEnum(String status){
		this.status = status ;
	}

	public String getStatus() {
		return status;
	}
	
}
