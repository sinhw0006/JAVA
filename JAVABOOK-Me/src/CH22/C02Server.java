package CH22;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C02Server {
	public static void main(String[] args) throws IOException {
		// 192.168.16.21:7000
		ServerSocket server = new ServerSocket(7000);

		System.out.println("[INFO] SERVER SOCKET LISTENING");

		Socket client = server.accept();

		System.err.println("CLIENT IP: " + client.getInetAddress());
		OutputStream out = client.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		InputStream in = client.getInputStream();
		DataInputStream din = new DataInputStream(in);

		Scanner sc = new Scanner(System.in);
		String recv = null;
		String send = null;
		while (true) {
			System.out.println("입력 : ");
			send = sc.nextLine();
			if (send.equals("q"))
				break;
			dout.writeUTF(send);
			dout.flush();
			recv = din.readUTF();
			if (recv.equals("q"))
				break;
			System.out.println(recv);
		}
		din.close();
		dout.close();
		in.close();
		out.close();
		client.close();
		server.close();
		System.out.println("서버 종료");
	}
}
