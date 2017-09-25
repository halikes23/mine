package com.cz.thinkinjava.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReader {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/data/temp/demoSerializable.obj")) ;
		
		DemoSerializable s = (DemoSerializable)ois.readObject() ;
		
		System.out.println(s);
		
		ois.close();
		
	}
	
}
