import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		Items p = new Items();
		p.getName();
		p.getTitle();
		
		ArrayList<String> list = p.to();
		System.out.println(list);
		
		
		long n = list.stream().filter(s->s.contains("Title")).count();
		System.out.println(n);
		WriteIntoFile f = new WriteIntoFile();
		f.writeText(list);
		
//		Testdata k = new Testdata();
//		k.getTitle();
//		
	}

}
