package com.cz.designmode.mode.prototype;

public class NormalContract implements Contract{

	private String sencondParty ;
	
	private String content ;
	
	private NormalContract( String sencondParty , String content ){
		this.sencondParty = sencondParty ;
		this.content = content ;
	}
	
	public static NormalContract build( String sencondParty , String content ){
		NormalContract contract = new NormalContract( sencondParty,content ) ;
		return contract ;
	}
	
	@Override
	public String print() {
		
		StringBuilder contract = new StringBuilder() ;
		contract.append("FirstParty : ").append("________").append("\n") ;
		contract.append("Wallah : ").append("________").append("\n") ;
		contract.append("SencondParty : ").append(sencondParty).append("\n") ;
		contract.append(content).append("\n") ;
		contract.append("\t\t\t\t\t Date : ").append("________").append("\n") ;
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
