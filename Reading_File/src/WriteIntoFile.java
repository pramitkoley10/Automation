import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class WriteIntoFile {

	public void writeText(ArrayList<String> list)  {
		File file = new File("//Users//pramitk//eclipse-workspace//Reading_File//src//File.txt");
		FileWriter read = null;
		try {
			read = new FileWriter(file , true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter wr = new BufferedWriter(read);
		
		
//		Iterator<String> it = list.iterator();
//		while(it.hasNext()) {
//			
//		 it.next();
//		
//		}
		
		
		
		//wr.newLine();
		int k = 0;
		for(int i=0;i<list.size();i++) {
		  
			try {
				
			wr.append(list.get(i)+"a");
			k++;
			if(k<list.size()) {
			  wr.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		  System.out.println(list.get(i));
		  
		  
		}
		
		try {
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
