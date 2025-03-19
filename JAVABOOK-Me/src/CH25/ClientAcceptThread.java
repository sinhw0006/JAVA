package CH25;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ClientAcceptThread implements Runnable {
	Sgui gui;

	public ClientAcceptThread(Sgui gui) {
		this.gui = gui;
	}

	@Override
	public void run() {
		try {
			while (true) {
				gui.client = gui.server.accept();
				System.err.println("CLIENT IP: `" + gui.client.getInetAddress() + "`에서 연결");
				gui.din = new DataInputStream(gui.client.getInputStream());
				gui.area.append("[CLIENT] " + gui.client.getInetAddress() + "에서 접속\n");

				// 수신 스레드 생성
				ServerRecvThread recv = new ServerRecvThread(gui.din, gui);
				Thread th = new Thread(recv);
				th.start();
				gui.clients.add(gui.client);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
