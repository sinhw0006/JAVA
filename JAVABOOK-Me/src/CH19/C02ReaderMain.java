package CH19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class C02ReaderMain {

	public static void main(String[] args) throws IOException {
		Reader fin = new FileReader("C:\\정처산기A 공유\\IOTEST\\test1.txt");
		int data=0;
		
		StringBuffer buffer = new StringBuffer();
		while((data = fin.read()) != -1) {
			System.out.print((char)data);
			buffer.append((char)data);
		}
		System.out.println();
		System.out.println(buffer);
		
		fin.close();
	}

}
