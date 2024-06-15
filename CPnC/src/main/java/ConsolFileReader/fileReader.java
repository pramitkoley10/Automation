package ConsolFileReader;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;




public class fileReader {

	
	
	
		//File file = new File(System.getProperty("user.dir")+"//CPnC//ConsolOutput.txt");
		

		public String to() throws IOException {
			String path = System.getProperty("user.dir")+"//src//main//java//ConsolFileReader//ConsolOutput.txt";
			File file = new File(path);
			FileReader read = new FileReader(file);
			BufferedReader bf = new BufferedReader(read);
			String a;
			String b = "";
			while((a = bf.readLine()) != null ) {
				if(a.contains("[RemoteTestNG]") == false) {
			               b=b+ '\n'+a;
				}
			}
			
			return b;
		 }
	
	
	
	
}
