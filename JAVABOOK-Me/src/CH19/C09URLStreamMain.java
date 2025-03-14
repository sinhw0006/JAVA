package CH19;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URL;

public class C09URLStreamMain {
	public static void main(String[] args) throws Exception {
		URL url = (new URI("https://imnews.imbc.com/replay/2025/nwtoday/article/6695787_36807.html")).toURL();
		InputStream in = url.openStream();
		
		//보조 스트림 추가
		BufferedInputStream buffIn = new BufferedInputStream(in);
		Reader rin = new InputStreamReader(buffIn);
		
//		OutputStream out = new FileOutputStream("C:\\정처산기A 공유\\IOTEST\\index.html");
		Writer out = new FileWriter("C:\\정처산기A 공유\\IOTEST\\index.html");
		String aString = "https://openweathermap.org/img/wn/" + "01d"+".png";
		System.out.print(aString);
		
		while(true) {
			int data = rin.read();
			if(data==-1) {
				break;
			}
			System.out.print((char)data);
			out.write(data);
			out.flush();
		}
		out.close();
	}
}
