package CH24;

import java.io.DataInputStream;
import java.io.IOException;

public class ClientRecvThread implements Runnable {

	DataInputStream din;

	public ClientRecvThread(DataInputStream din) {
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
				System.out.print("\n[Server] : "+recv);
			}
		} catch (IOException e) {
			System.err.println("[EXCEPTION] 예외발생 ClientRecvThread 종료");
		} finally {
			try {din.close();} catch (IOException e) {}
		}
	}
}
