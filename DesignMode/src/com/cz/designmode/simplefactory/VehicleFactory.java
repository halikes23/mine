package com.cz.designmode.simplefactory;

public class VehicleFactory {

	public static Vehicle build(String vehicle){
		
		if("Car".equals(vehicle)){
			return new Car() ;
		}else if("Bike".equals(vehicle)){
			return new Bike() ;
		}else{
			return null ;
		}
		
	}
	
}
