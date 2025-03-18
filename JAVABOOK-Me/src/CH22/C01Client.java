package CH22;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class C01Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		//Socket client = new Socket("IP",7000);
		Socket client = new Socket("192.168.16.40",7000);
		
		InputStream in =  client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		String recv = din.readUTF();
		System.out.println(recv);
		
		din.close();
		in.close();
		client.close();
	}
}
