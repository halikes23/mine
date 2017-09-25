package com.cz.designmode.mode.builder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TxtDataPersistencerBuilder implements DataPersistencerBuilder{

	@Override
	public Object getConnection(Object param) throws IOException  {
		String fileName = (String) param ;
		File file = new File(fileName) ;
		FileWriter writer = new FileWriter(file) ;
		return writer;
	}

	@Override
	public void save(Object connection, Object data) throws IOException{
		FileWriter writer = (FileWriter)connection ;
		writer.write((String)data);
	}

	@Override
	public void closeConnection(Object connection) throws Exception {
		FileWriter writer = (FileWriter)connection ;
		writer.close(); 
	}

}
