package com.cz.thinkinjava.collectionrm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoRemoveCollectionElement {

	private List<String> list ;
	
	public static void main(String[] args) {
		
		DemoRemoveCollectionElement demo = new DemoRemoveCollectionElement() ;
		
		List<String> list = new ArrayList<String>() ;
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
//		demo.setList(list);
		
		try{
			for(String s : list){
				list.remove(s) ;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(String s : list){
			System.out.println(s);
		}
		
		
		
		
		System.out.println("*************");
		list = new ArrayList<String>() ;
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		for( int i = 0 ; i < list.size() ; i ++ ){
			list.remove(i) ;
		}
		
		for(String s : list){
			System.out.println(s);
		}
		
		System.out.println("*************");
		list = new ArrayList<String>() ;
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		for( int i = 0 ; i < list.size() ; i ++ ){
			list.remove(i) ;
			i -- ;
		}
		
		for(String s : list){
			System.out.println(s);
		}
		
		System.out.println("*************");
		list = new ArrayList<String>() ;
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		Iterator<String> i = list.iterator() ;
		while(i.hasNext()){
			i.next();
			i.remove(); 
		}
		
		for(String s : list){
			System.out.println(s);
		}
		
		List<String> l = demo.getList() ;
		for(String s : l){
			System.out.println(s);
		}
		
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
}
