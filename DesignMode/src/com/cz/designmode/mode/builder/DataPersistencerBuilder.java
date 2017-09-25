package com.cz.designmode.mode.builder;

public interface DataPersistencerBuilder {

	public Object getConnection(Object param) throws Exception;
	
	public void save( Object connection , Object data ) throws Exception;
	
	public void closeConnection(Object connection) throws Exception;
	
	
}
