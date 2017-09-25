package com.cz.thinkinjava.keyfinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoFinal {

	public static List<String> fList = new ArrayList<String>() ;
	
	public static void main(String[] args) {
		
//		fList = new ArrayList<String>() ;
		fList.add("a") ;
		System.out.print( "1 ");
		for( String v : fList ){
			System.out.print(v);
		}
		
		List<String> unmodfiedList = Collections.unmodifiableList(fList) ;
		
		fList.add("b") ;
		System.out.println();
		System.out.print("2 ");
		for( String v : unmodfiedList ){
			System.out.print(v);
		}
		
		System.out.println();
		unmodfiedList.add("c") ;
		
	}
	
}
