package com.cz.tool;

import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RandomStringBuilder {
	
	private static final Random random = new Random();
	
	public static void main(String[] args) {
		
		Display.getDefault().syncExec(new Runnable(){

			public void run() {
				RandomStringBuilder builder = new RandomStringBuilder();
				builder.launch();
			}

		});
		
	}
	
	public void launch(){
		
		Display display = Display.getDefault() ;
		
		Shell shell = new Shell(display) ;
		
		shell.setSize(new Point(500,500));
		
		shell.setLayout(new RowLayout());
		
		final Text txtLength = new Text(shell,1) ;
		
		txtLength.setText("请输入需要生成的字符串长度");
		
		txtLength.addListener(SWT.FOCUSED, new Listener(){

			public void handleEvent(Event arg0) {
				if("请输入需要生成的字符串长度".equals(txtLength.getText())){
					txtLength.setText("");
				}
			}
			
		});
		
		Button button = new Button(shell,2);
		
		final Text text = new Text(shell,3) ;
		
		
		
		button.setText("生成随机字符串");
		
		button.addListener(SWT.MouseUp ,new Listener() {
			
			public void handleEvent(Event arg0) {
				try{
					Integer length = Integer.parseInt(txtLength.getText()) ;
					String rst = build(length);
					text.setText(rst);
				}catch(NumberFormatException e){
					txtLength.setText("请输入需要生成的字符串长度");
					return ;
				}
				
			}
		});
		
		shell.open();
		
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		
	}
	
	public String build(int length){
		StringBuilder rst = new StringBuilder();
		
		 String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_+*/;:~!@#$%^&*()" ;
		//String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890" ;
		
		String[] codes = str.split("") ;
		
		Integer codesLength = codes.length ;
		
		for(int i = 0 ; i < length ; i ++){
			int index = random.nextInt(codesLength) ;
			rst.append(codes[index]) ;
		}
		
		return rst.toString() ;
	}
	
}
