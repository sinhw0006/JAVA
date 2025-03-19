package CH24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException, InterruptedException {
		// 192.168.16.21:7000
		ServerSocket server = new ServerSocket(7001);

		System.out.println("[INFO] SERVER SOCKET LISTENING");

		Socket client = server.accept();

		System.err.println("CLIENT IP: `" + client.getInetAddress()+"`에서 연결");
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		ServerSendThread send = new ServerSendThread(dout);
		ServerRecvThread recv = new ServerRecvThread(din);
		
		Thread th1 = new Thread(send);
		Thread th2 = new Thread(recv);
		
		th1.start();
		th2.start();
		
		th1.join();
		th2.join();

		in.close();
		out.close();
		client.close();
		server.close();
		System.out.println("서버 종료");
	}
}
