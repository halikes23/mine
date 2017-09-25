package com.cz.thinkinjava.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		DemoSerializable s = new DemoSerializable();
		s.setCode("001");
		s.setName("成振");
		
		File file = new File("/data/temp/demoSerializable.obj");
		file.createNewFile() ;
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("/data/temp/demoSerializable.obj")) ;
		
		os.writeObject(s);
		
		os.close();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream() ;
		
		os = new ObjectOutputStream(baos) ;
		
		os.writeObject(s);
		
		byte[] obj = baos.toByteArray() ;
		
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(obj)) ;
		DemoSerializable sReaded = (DemoSerializable)ois.readObject() ;
		
		System.out.println(sReaded);
		
	}
	
}
