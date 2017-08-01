package practice.session2;

import javax.swing.plaf.SliderUI;

public class SyncDemo {

	public static void method1() throws InterruptedException{
		System.out.println( "method1 start" );
		System.out.println( "method1 end" );
	}
	
	public static void method2() throws InterruptedException{
		System.out.println( "method3 start" );
		System.out.println( "method3 end" );
	}
	
	private static class Method1Thread extends Thread{
		
		public void run(){
			
			try {
				SyncDemo.method1() ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private static class Method2Thread extends Thread{
		
		public void run(){
			try {
				SyncDemo.method2() ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		for(int i = 0 ; i < 10000 ; i ++ ){
			new Method1Thread().start();
			new Method2Thread().start();
			
		}
		
		
	}
	
}
