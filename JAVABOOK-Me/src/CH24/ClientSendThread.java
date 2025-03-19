package CH24;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ClientSendThread implements Runnable{
	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);

	public ClientSendThread(DataOutputStream dout) {
		this.dout = dout;
	}
	
	@Override
	public void run() {
		String send;
		try {
			while (true) {
				System.out.printf("[Clent(me)] : ");
				send = sc.nextLine();
				dout.writeUTF(send);
				dout.flush();
				if (send.equals("q")) break;
			}
		} catch (IOException e) {
			System.err.println("[EXCEPTION] 예외발생 ClentSendThread 종료");
		} finally {
			try {dout.close();} catch (IOException e) {}
		}
	}
}
