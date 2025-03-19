package CH25;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Sgui extends JFrame implements ActionListener, KeyListener {

	JTextArea area;
	JScrollPane scroll;
	JTextField txt1;
	// 소켓코드 추가
	ServerSocket server;
	List<Socket> clients = new ArrayList<Socket>();
	Socket client;
	DataOutputStream dout;	
	DataInputStream din;

	Sgui() throws Exception {
		super("Chat Server"); // 프레임창 제목
		JPanel pannel = new JPanel(); // 패널 생성
		pannel.setLayout(null); // Layout 설정 x

		area = new JTextArea(); // 텍스트영역창
		area.setEditable(false); //

		// area.setBounds(10,10,260,240); //스크롤 추가시 생략
		scroll = new JScrollPane(area); // area에 스크롤 추가하기
		scroll.setBounds(10, 10, 260, 240);

		txt1 = new JTextField(); // 텍스트입력창
		txt1.setBounds(10, 260, 260, 30); // 크기
		txt1.addKeyListener(this); // 이벤트 추가(키보드)

		pannel.add(txt1);
		// pannel.add(area); //스크롤 추가시 생략
		pannel.add(scroll);

		add(pannel); // 프레임에 패널 추가

		setBounds(100, 100, 300, 350); // 프레임창 위치
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료버튼 사용가능상태
		setVisible(true); // 프레임창 보여주기

		// 192.168.16.21:7000
		server = new ServerSocket(7001);

		System.out.println("[INFO] SERVER SOCKET LISTENING");

		//응답 스레드 생성
		ClientAcceptThread clientAcceptThread = new ClientAcceptThread(this);
		Thread th = new Thread(clientAcceptThread);
		th.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	// 키를 뗏을때(UNICODE지원)
	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println("KEYTPYED함수 : " + e.getKeyChar());

	}

	// 키를 눌렀을때
	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println("KEYPRESSED함수 : "+e.getKeyChar());
		// System.out.println("KEYPRESSED함수 : "+e.getKeyCode());
		if (e.getKeyCode() == 10) // 엔터키 입력
		{
			try {
				// 1 필드의 내용 ->Area
				area.append("[SERVER] : " + txt1.getText() + "\n");

				// 송신
				for (Socket client : clients) {
                    DataOutputStream dout = new DataOutputStream(client.getOutputStream());
                    dout.writeUTF("[Server] : " + txt1.getText());
                    dout.flush();
                }
				
				// 2 필드의 내용 삭제
				txt1.setText("");

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 키를 뗏을때(UNICODE 미지원)
	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println("KEYRELEASED함수 : "+e.getKeyChar());

	}

}

public class ServerUI {

	public static void main(String[] args) throws Exception {
		new Sgui();
	}

}
