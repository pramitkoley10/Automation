package ConsolFileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class WriteIntoFile {
	

	public void writeText(ArrayList<String> list) throws IOException  {
		
		
		
		String path = System.getProperty("user.dir")+"//src//main//java//ConsolFileReader//ConsolOutput.txt";
		File file = new File(path);
		
		
		
		 FileWriter fwOb = new FileWriter(file , false); 
	        PrintWriter pwOb = new PrintWriter(fwOb, false);
	        pwOb.flush();
	        pwOb.close();
	        fwOb.close();
		
		
		
		
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
		  
			
				
			wr.append(list.get(i));
			k++;
			if(k<list.size()) {
			  wr.newLine();
			}
		
			
		  System.out.println(list.get(i));
		  
		  
		}
		
			wr.close();
			list.clear();
			
	}
}
