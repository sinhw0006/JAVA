package CH18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class C07GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
	String name;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton input;
	JTextField txt1;
	JTextArea area1;
	JScrollPane scroll1;

	// Frame
	public C07GUI(String name, String title) {
		super(title);
		this.name = name;
		final int MARGIN = 10;
		final int[] TEXTAREASIZE = { 500, 560 };
		final int[] BUTTONSIZE = { TEXTAREASIZE[0] / 3, TEXTAREASIZE[1] / 10 };
		setBounds(400, 100, TEXTAREASIZE[0] + BUTTONSIZE[0] + MARGIN * 5, TEXTAREASIZE[1] + BUTTONSIZE[1] + MARGIN * 7);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// Component
		btn1 = new JButton("파일로 저장");
		btn1.setBounds(TEXTAREASIZE[0] + MARGIN * 2, TEXTAREASIZE[0] / 10, BUTTONSIZE[0], BUTTONSIZE[1]);

		btn2 = new JButton("1 : 1 요청");
		btn2.setBounds(TEXTAREASIZE[0] + MARGIN * 2, TEXTAREASIZE[0] / 10 + BUTTONSIZE[1] * 2, BUTTONSIZE[0],
				BUTTONSIZE[1]);

		btn3 = new JButton("대화기록");
		btn3.setBounds(TEXTAREASIZE[0] + MARGIN * 2, TEXTAREASIZE[0] / 10 + BUTTONSIZE[1] * 4, BUTTONSIZE[0],
				BUTTONSIZE[1]);

		input = new JButton("입력");
		input.setBounds(TEXTAREASIZE[0] + MARGIN * 2, TEXTAREASIZE[1] + MARGIN * 2, BUTTONSIZE[0], BUTTONSIZE[1]);

		area1 = new JTextArea();
		area1.setEditable(false);
		area1.setLineWrap(true);
		area1.setWrapStyleWord(true);
		scroll1 = new JScrollPane(area1);
		scroll1.setBounds(MARGIN, MARGIN, TEXTAREASIZE[0], TEXTAREASIZE[1]);

		txt1 = new JTextField();
		txt1.setBounds(MARGIN, TEXTAREASIZE[1] + MARGIN * 2, TEXTAREASIZE[0], BUTTONSIZE[1]);

		// event listener add
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		input.addActionListener(this);
		txt1.addKeyListener(this);
		area1.addMouseListener(this);

		// Panel(Component)
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(input);
		panel.add(txt1);
		panel.add(scroll1);

		// Frame(Panel)
		add(panel);

		// Frame
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			System.err.println("파일로 저장");
		} else if (e.getSource() == btn2) {
			System.err.println("1대1 요청");
		} else if (e.getSource() == btn3) {
			System.err.println("대화 기록");
		} else if (e.getSource() == input) {
			String message = txt1.getText();
			area1.append(name + " : " + message + "\n");
			txt1.setText("");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {// 문자 완성
//		System.err.println("KeyTyped" + e.getKeyChar());
//		System.err.println("KeyTyped" + e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) { // 누르고 있을때
//		System.err.println("KeyPressed" + e.getKeyCode());
		if (e.getSource() == txt1) {
			if (e.getKeyCode() == 10) {
				String message = txt1.getText();
				area1.append(name + " : " + message + "\n");
				txt1.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {// 키업
//		System.err.println("KeyReleased" + e.getKeyChar());
//		System.err.println("KeyReleased" + e.getKeyCode());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
//			System.out.println("MouseClicked..." + e.getPoint());
			int offset = area1.viewToModel(e.getPoint());
//			System.out.println("MouseClicked offset..." + offset);
			int row = area1.getLineOfOffset(offset);
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
//			System.out.printf("MouseClicked offset...row : %d startOffset : %d endOffset : %d\n",row,startOffset,endOffset);
			String str = area1.getText(startOffset, endOffset-startOffset);
			System.out.println(str);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

public class C07SwingEventMain {

	public static void main(String[] args) {
		new C07GUI("user1", "Chatting Server");
	}

}
