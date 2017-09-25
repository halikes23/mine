package com.cz.brash;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketBrash {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
			while(true){
				ServerSocket server = new ServerSocket(4700) ;
				System.out.println("new socket server is opened");
				
				try{
					
					Socket socket = server.accept() ;
					
					InputStream is = socket.getInputStream();
		
					byte[] buffer = new byte[1024*1024*10] ;
					
					int length = is.read(buffer) ;
					String part = new String(buffer,0,length ,"utf-8");
					System.out.println("request length : " + part.length());
					System.out.println("**************************************************");
					System.out.print(part);
					System.out.println("**************************************************");
					
					OutputStream os = socket.getOutputStream() ;
					try{
						os.write("request has got!".getBytes());
						
					}catch(Exception e){
						socket.close();
					}finally{
						os.flush();
						os.close(); 
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					server.close(); 
				}
			
			}
		
	}
	
}
