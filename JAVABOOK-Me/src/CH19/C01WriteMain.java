package CH19;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class C01WriteMain {

	public static void main(String[] args) throws IOException {
//		Writer fout = new FileWriter("C:\\정처산기A 공유\\IOTEST\\text1.txt",false); //덮어쓰기
		Writer fout = new FileWriter("C:\\정처산기A 공유\\IOTEST\\test1.txt",true); //추가하기
		fout.write("TEST1\n");
		fout.write("TEST2\n");
		fout.write("TEST3\n");
		fout.write("TEST4\n");
		
		fout.flush();
		fout.close();
		
	}

}
