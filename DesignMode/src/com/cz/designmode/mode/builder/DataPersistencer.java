package com.cz.designmode.mode.builder;

public class DataPersistencer{

	private DataPersistencerBuilder builder ;
	
	public DataPersistencer(DataPersistencerBuilder builder){
		this.builder = builder ;
	}
	
	public final void process(Object param , Object data) throws Exception{
		Object connection = null ;
		try{
			connection = builder.getConnection(param) ;
			builder.save(connection, data);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection != null){
				builder.closeConnection(connection);
			}
			
		}
		
	}
	
}
