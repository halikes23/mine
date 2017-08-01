package practice.session3;

public class ErrorPublish {

	private static int n ;
	
	public ErrorPublish() throws InterruptedException{
		Thread.sleep(100L);
		n = 10 ;
	}
	
	public static void assertSanity() throws InterruptedException{
		
		int temp = n ;
		
		Thread.sleep(500L);
		
		System.out.println(temp + ":" + n);
		
		if( temp != n ){
			throw new AssertionError("This statement is false");
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					ErrorPublish.assertSanity();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}) ;
		thread.start();
		ErrorPublish errorPublic = new ErrorPublish();
		
	}
	
	
}
