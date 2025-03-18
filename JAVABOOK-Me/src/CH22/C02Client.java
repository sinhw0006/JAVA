package CH22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.http.WebSocket;
import java.util.Scanner;

public class C02Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//192.168.16.21:7000
		Socket client = new Socket("192.168.16.40",7000);
		
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		
		Scanner sc = new Scanner(System.in);
		String send = null;
		String recv = null;
		while (true) {
			recv = din.readUTF();
			if (recv.equals("q"))
				break;
			System.out.println("[Server] : "+recv);
			System.out.printf("[Client] : ");
			send = sc.nextLine();
			if (send.equals("q"))
				break;
			dout.writeUTF(send);
			dout.flush();
		}
		din.close();
		dout.close();
		in.close();
		out.close();
		client.close();
	}
}
