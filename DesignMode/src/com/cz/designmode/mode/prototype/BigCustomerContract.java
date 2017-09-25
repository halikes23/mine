package com.cz.designmode.mode.prototype;

public class BigCustomerContract implements Contract{

	private String wallah ;
	
	private String firstParty ;
	
	private String sencondParty ;
	
	private String content ;
	
	private String date ;
	

	private BigCustomerContract(String firstParty , String wallah , String sencondParty , String content , String date ){
		this.firstParty = firstParty ;
		this.wallah = wallah ;
		this.sencondParty = sencondParty ;
		this.content = content ;
		this.date = date ;
	}
	
	public static BigCustomerContract build(String firstParty , String wallah , String sencondParty , String content , String date ){
		BigCustomerContract contract = new BigCustomerContract(firstParty,wallah,sencondParty,content,date) ;
		return contract ;
	}
	
	@Override
	public String print() {
		
		StringBuilder contract = new StringBuilder() ;
		contract.append("FirstParty : ").append(firstParty).append("\n") ;
		contract.append("Wallah : ").append(wallah).append("\n") ;
		contract.append("SencondParty : ").append(sencondParty).append("\n") ;
		contract.append(content).append("\n") ;
		contract.append("\t\t\t\t\t Date : ").append(date).append("\n") ;
		contract.append("\t\t\t\t\t No.").append(Context.fileNo++ ).append("\n") ;
		return contract.toString();
	}
	
	@Override
	public Object clone(){
		Object obj = null ;
		
		try {
			obj = super.clone() ;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return obj ;
		
	}

}
