package CH19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.Buffer;

public class C04FileCopyMain {

	private static String FileDir = "C:\\정처산기A 공유\\IOTEST\\";
	
	public static void main(String[] args) throws IOException	//args[0] 원본파일 args[1] 대상파일
	{
		Reader fin = new FileReader("C:\\정처산기A 공유\\IOTEST\\test3.txt");
		int data=0;
		
		StringBuffer buffer = new StringBuffer();
		
		char [] buf = new char[1024];
		
		long startTime = System.currentTimeMillis();
		while((data = fin.read(buf)) != -1) {
//			buffer.append((char)data);
			buffer.append(buf);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(buffer);
		System.out.println("소요시간 : "+ (endTime-startTime)+"ms");
		
		fin.close();
	}
}
