package CH24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ServerRecvThread implements Runnable {

	DataInputStream din;

	public ServerRecvThread(DataInputStream din) {
		this.din = din;
	}

	@Override
	public void run() {
		String recv;
		try {
			while (true) {
				recv = din.readUTF();
				if (recv.equals("q"))
					break;
				System.out.print("\n[Client] : "+recv);
			}
		} catch (IOException e) {
			System.err.println("[EXCEPTION] 예외발생 ServerRecvThread 종료");
		} finally {
			try {din.close();} catch (IOException e) {}
		}
	}

}
