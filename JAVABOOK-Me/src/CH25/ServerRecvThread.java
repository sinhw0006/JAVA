package CH25;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerRecvThread implements Runnable {
	Sgui gui;
	DataInputStream din;

	public ServerRecvThread(DataInputStream din, Sgui gui) {
		this.din = din;
		this.gui = gui;
	}

	@Override
	public void run() {
		String recv;
		try {
			while (true) {
				recv = din.readUTF();
				if (recv.equals("q"))
					break;
//				System.out.print("\n[Client] : "+recv);
				gui.area.append("[Client] "+recv+"\n");
				for (Socket client : gui.clients) {
                    DataOutputStream dout = new DataOutputStream(client.getOutputStream());
                    dout.writeUTF("[Client] : " + recv);
                    dout.flush();
                }
			}
		} catch (IOException e) {
			System.err.println("[EXCEPTION] 예외발생 ServerRecvThread 종료");
		} finally {
			try {din.close();} catch (IOException e) {}
		}
	}

}
