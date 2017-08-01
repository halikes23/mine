package myswt;



import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class IndexForm {

	public static void main(String[] args) {
		
		Display display = new Display();
		
		final Shell shell = new Shell(display) ;
		
		shell.setText("hello world !");
		
		shell.setLayout(new FillLayout());
		
		Button button = new Button(shell,SWT.CENTER);
		
		Menu menu = new Menu(shell,SWT.BAR);
		
		shell.setMenuBar(menu);
		
		MenuItem file = new MenuItem(menu,SWT.RADIO);
		
		file.setText("FILE");
		
		file.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				System.out.println("file is clicked");
				FileDialog dialog = new FileDialog(shell);
				dialog.open() ;
				String fileName = dialog.getFileName();
				System.out.println(fileName);
			}
		});
		
		shell.open();
		
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose(); 
	}
	
}
