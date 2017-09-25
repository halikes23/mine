package com.cz.designmode.simplefactory;

public class Driver {

	public static void main(String[] args) {
		
		Vehicle vehicle = VehicleFactory.build("Car") ;
		vehicle.run("Shang Hai");
		
	}
	
}
