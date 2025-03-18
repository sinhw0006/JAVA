package CH22;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C01Server {
	public static void main(String[] args) throws IOException {
		//192.168.16.21:7000
		ServerSocket server = new ServerSocket(7000);
		
		System.out.println("[INFO] SERVER SOCKET LISTENING");
		
		Socket client = server.accept();
		
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		dout.writeUTF("[INFO] 누구세요?");
		dout.flush();
		
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		String recv = din.readUTF();
		System.out.println(recv);
		
		
		dout.close();
		out.close();
		client.close();
		server.close();
		System.out.println("서버 종료");
		
	}
}
