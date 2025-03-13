package CH19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class C07FileCopyMain {
	
	public static void main(String[] args) throws IOException
	{
		InputStream in = new FileInputStream("C:\\정처산기A 공유\\IOTEST\\eclipse-jee-2024-12-R-win32-x86_64.zip");
		OutputStream out = new FileOutputStream("C:\\정처산기A 공유\\IOTEST\\a.zip");
		
		byte [] buff = new byte[4096];
		while(true) {
			int data = in.read(buff);
			if(data==-1) break;
//			out.write((byte)data);
			out.write(buff, 0, 4096);
			out.flush();
		}
		in.close();
		out.close();
	}
}
