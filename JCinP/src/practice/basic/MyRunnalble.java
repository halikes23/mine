package practice.basic;

public class MyRunnalble implements Runnable {
	
	private static Integer count = 0 ;
	
	public void run() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Runnable : " + ( ++count ) );
	}
}
