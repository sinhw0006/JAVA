package CH19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class C05FileInputStreamMain {
	
	public static void main(String[] args) throws IOException
	{
		InputStream fin = new FileInputStream("C:\\정처산기A 공유\\IOTEST\\data.xlsx");
		StringBuffer stringBuffer = new StringBuffer();
		
		long sTime = System.currentTimeMillis();
		while(true) {
			int data = fin.read();
			if(data==-1) break;
		}
		long eTime = System.currentTimeMillis();
		System.out.println("소요시간 : " +(eTime-sTime)+"ms");
		fin.close();
	}
}
