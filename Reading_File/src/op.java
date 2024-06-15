import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class op {
 public ArrayList<String> to() throws FileNotFoundException {
	File file = new File("//Users//pramitk//eclipse-workspace//Reading_File//src//File.txt");
	FileReader read = new FileReader(file);
	BufferedReader bf = new BufferedReader(read);
	
	
	
//	String a = null;
//	try {
//		while((a = bf.readLine()) != null) {
//			System.out.println(a);
//		}
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	try {
//		bf.close();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	String a = null;
	ArrayList<String> list = new ArrayList<String>();
	try {
		while((a = bf.readLine()) != null) {
		    list.add(a);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
 }
}
