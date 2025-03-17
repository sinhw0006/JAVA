package CH20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class C02ReadLineMain {
	
	public static void main(String[] args) throws Exception{
		
		Writer out = new FileWriter("C:\\정처산기A 공유\\IOTEST\\test2.txt");
		BufferedWriter bout = new BufferedWriter(out);	
		PrintWriter pout = new PrintWriter(bout);
		pout.println("HELLO");
		pout.println("HELLO");
		pout.println("HELLO");
		pout.flush();
		pout.close();
		
		
		Reader in = new FileReader("C:\\정처산기A 공유\\IOTEST\\test2.txt");
		BufferedReader bin = new BufferedReader(in);
		
		while(true) {
			String data = bin.readLine();
			if(data==null)
				break;
			System.out.println(data);
		}
		
		
		
	}
}
