package myswt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TableForm {

	public static void main(String[] args) throws IOException {
		
		Display display = new Display();
		
		final Shell shell = new Shell(display) ;
		
		shell.setLayout(new FillLayout());
		
		GridData gridData = new GridData();
		
		gridData.horizontalAlignment = SWT.FILL ;
		gridData.grabExcessHorizontalSpace = true ;
		gridData.verticalAlignment = SWT.FILL ;
		gridData.grabExcessVerticalSpace = true ;
		
		
		Table table = new Table(shell,SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLayoutData(gridData);
		table.setLinesVisible(true);
		
		String[] headers = {"接口","调用次数"} ;
		
		TableColumn sorter = null ;
		
		for( String header : headers ){
			TableColumn column = new TableColumn(table,SWT.NONE);
			column.setText(header);
			column.setMoveable(true);
			if( "调用次数".equals(header) ){
				sorter = column ;
			}
			column.pack();
		}
		
		Pattern pattern = Pattern.compile(".*\\)");
		
		BufferedReader reader = new BufferedReader(new FileReader("/temp/access")) ;
		
		List<String[]> list = new ArrayList<String[]>() ;
		
		try{
			String line ;
			String[] row = null;
			
			for(int i = 0 ; (line = reader.readLine() ) != null ; i ++  ){
				Matcher matcher = pattern.matcher(line) ;
				if(matcher.find()){
					System.out.println(matcher.group());
					line = line.replace(matcher.group(), "").replaceAll("\"", "") ;
				}
				
				if(i%2 == 0){
					//item = new TableItem(table,SWT.NONE) ;
					row = new String[2] ;
					row[0] = line ;
				}else{
					row[1] = line ;
					list.add(row) ;
					//item.setText(row);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if( reader != null ){
				reader.close();
			}
		}
		
		list.sort(new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o2[1]) > Integer.parseInt(o1[1]) ? 1 : -1;
			}
		});
		
		for( int i = 0 ; i < list.size() ; i ++ ){
			TableItem item = new TableItem(table,SWT.NONE) ;
			item.setText(list.get(i));
		}
		
//		table.setSortColumn(sorter);
//		table.setSortDirection(SWT.DOWN);
		shell.open();
		
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		
	}
	
}
