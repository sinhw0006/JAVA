package CH19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class C06FileOutputStreamMain {
	
	public static void main(String[] args) throws IOException
	{
		OutputStream outputStream = new FileOutputStream("C:\\정처산기A 공유\\IOTEST\\test4.txt");
		outputStream.write('a');
		outputStream.write('b');
		outputStream.write('c');
		outputStream.flush();
		outputStream.close();
	}
}
