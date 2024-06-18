package com.cpnc.CPnC.TimesofRun;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//import org.testng.annotations.DataProvider;
//
//@DataProvider
public class RunTime {
//	
//	public static Object[] runTime() {
//		int n = 1;
//		Object[] data = new Object[n];
//		
//		for(int i=0;i<=n-1;i++) {
//			data[i] = i;
//			
//			
//		}
//		return data;
//	}
//	
//
	
	
	  
public void createReport(ArrayList<String> list) throws IOException  {
		
		
		
		String path = System.getProperty("user.dir")+"//Reports//Report.txt";
		File file = new File(path);
		
		
		
		
		FileWriter read = null;
		try {
			read = new FileWriter(file , true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter wr = new BufferedWriter(read);
		 
		
		
		
		
//		wr.newLine();
		int k = 0;
		for(int i=0;i<list.size();i++) {
		  
			
				
			wr.append(list.get(i));
			k++;
			if(k<list.size()) {
			  wr.newLine();
			}
		
		  
		  
		}
		
			wr.close();
			list.clear();
			
	}
}



