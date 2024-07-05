package com.cpnc.CPnC.TimesofRun;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class outputReport {	
	  
    public void createReport(ArrayList<String> list) throws IOException  {
		
		
		
		String path = System.getProperty("user.dir")+"//Reports//outputreport.txt";
		File file = new File(path);
		
		
		System.out.println(list.size()); 

		
		FileWriter read = null;
		try {
			read = new FileWriter(file , true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter wr = new BufferedWriter(read);
		 
		
		
		
		wr.append("Slot----------------------------------");
		wr.newLine();
		wr.append("");
		wr.newLine();
		int k = 0;
		for(int i=0;i<list.size();i++) {
		  
			
				
			wr.append(list.get(i));
			k++;
			if(k<list.size()) {
			  wr.newLine();
			}
		System.out.println(list.get(i)+"OkOk") ; 
		  
		}
		
		wr.newLine();
		wr.append("");
		wr.newLine();
		wr.append("");
			wr.close();
			
			
	}
}



