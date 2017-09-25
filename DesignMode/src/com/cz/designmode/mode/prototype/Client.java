package com.cz.designmode.mode.prototype;

public class Client {

	public static void main(String[] args) {
		
		Contract contract = null ;
		
		contract = BigCustomerContract.build("上海触影文化传播有限公司", "成振", "上海帝联信息技术有限公司", "关于CDN的合同", "2017-09-20") ;
		
		print(contract);
		
		print(contract);
		
		contract= NormalContract.build(  "上海帝联信息技术有限公司", "关于CDN的合同" ) ;
		
		print(contract);
		
		print(contract);
		
	}
	
	public static void print(Contract contract){
		Contract c = (Contract)contract.clone() ;
		System.out.println(c.hashCode());
		System.out.println(c.print());
		
	}
	
}
