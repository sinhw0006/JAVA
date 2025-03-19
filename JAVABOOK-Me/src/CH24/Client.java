package CH24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.http.WebSocket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		//192.168.16.21:7000
		Socket client = new Socket("192.168.16.24",7000);
		
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		
		ClientSendThread send = new ClientSendThread(dout);
		ClientRecvThread recv = new ClientRecvThread(din);
		
		Thread th1 = new Thread(send);
		Thread th2 = new Thread(recv);
		
		th1.start();
		th2.start();
		
		th1.join();
		th2.join();
		
		
		in.close();
		out.close();
		client.close();
	}
}
