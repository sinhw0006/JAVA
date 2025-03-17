package CH21;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class Memo {
	private int id;
	private String text;
	private LocalDateTime createdAt;

	public Memo() {
	}

	public Memo(int id, String text, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.text = text;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime timestamp) {
		this.createdAt = timestamp;
	}

	@Override
	public String toString() {
		return "Memo [id=" + id + ", text=" + text + ", createdAt=" + createdAt + "]";
	}
}
class C07SELECTGUI extends JFrame {
	JButton[] btn;
	
	public C07SELECTGUI(List<Memo> memos){
		memos.size();
		final int MARGIN = 10;
		setBounds(400, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// Component
		btn = new JButton[memos.size()];

		// event listener add
//		btn[0].addActionListener(this);

		// Panel(Component)
		panel.add(btn[0]);

		// Frame(Panel)
		add(panel);

		// Frame
		setResizable(false);
		setVisible(true);
	}
	
}

class C07GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
	JButton btn1;
	JButton btn2;
	JButton btn3; // INSERT;
	JButton btn4; // UPDATE;
	JButton btn5; // DELETE;
	JButton btn6; // SELECTONE;
	JButton input;
	JTextField txt1;
	JTextArea area1;
	JScrollPane scroll1;

	Writer out;

	// DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/test2db";

	// JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	// Frame
	public C07GUI(String title) throws ClassNotFoundException, SQLException {
		super(title);
		final int MARGIN = 10;
		final int[] TEXTAREASIZE = { 600, 500 };
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

		btn3 = new JButton("DB_INSERT");
		btn3.setBounds(TEXTAREASIZE[0] + MARGIN * 2, TEXTAREASIZE[0] / 10 + BUTTONSIZE[1] * 4, BUTTONSIZE[0],
				BUTTONSIZE[1]);

		btn4 = new JButton("DB_UPDATE");
		btn4.setBounds(TEXTAREASIZE[0] + MARGIN * 2, TEXTAREASIZE[0] / 10 + BUTTONSIZE[1] * 5, BUTTONSIZE[0],
				BUTTONSIZE[1]);

		btn5 = new JButton("DB_DELETE");
		btn5.setBounds(TEXTAREASIZE[0] + MARGIN * 2, TEXTAREASIZE[0] / 10 + BUTTONSIZE[1] * 6, BUTTONSIZE[0],
				BUTTONSIZE[1]);

		btn6 = new JButton("DB_SELECT");
		btn6.setBounds(TEXTAREASIZE[0] + MARGIN * 2, TEXTAREASIZE[0] / 10 + BUTTONSIZE[1] * 7, BUTTONSIZE[0],
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
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		input.addActionListener(this);
		txt1.addKeyListener(this);
		area1.addMouseListener(this);

		// Panel(Component)
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(input);
		panel.add(txt1);
		panel.add(scroll1);

		// Frame(Panel)
		add(panel);

		// Frame
		setResizable(false);
		setVisible(true);

		// DB 연결코드
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success...");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB CONNECTED...");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			System.err.println("파일로 저장");
			String contents = area1.getText();

			JFileChooser fileChooser = new JFileChooser();

			String dirPath = "C:\\정처산기A 공유\\IOTEST\\";

			fileChooser.setDialogTitle("파일 저장 위치를 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			File defaultDirPath = new File(dirPath);
			if (defaultDirPath.exists())
				fileChooser.setCurrentDirectory(defaultDirPath);

			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal : " + selectedVal);

			if (selectedVal == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : " + selectedFile);

				// 파일확장자 추가
				String filePath = selectedFile.toString();
				if (!selectedFile.toString().endsWith(".txt")) {
					filePath = selectedFile.toString() + ".txt";
				}
				System.out.println("filePath : " + filePath);

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
				String filename = LocalDateTime.now().format(formatter);
				try {
					out = new FileWriter(dirPath + filename + ".txt");
					out.write(contents);
					out.flush();
					out.close();
				} catch (Exception e1) {
					e1.printStackTrace();

				} finally {
					try {
						out.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		} else if (e.getSource() == btn2) {
			System.err.println("1대1 요청");
		} else if (e.getSource() == btn3) {
			try {
				pstmt = conn.prepareStatement("INSERT INTO tbl_memo(text,createdAt) VALUES(?,now())");
				pstmt.setString(1, area1.getText());
				int result = pstmt.executeUpdate();
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "INSERT SUCCESS", "확인창", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "INSERT FAIL", "확인창", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					pstmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} else if (e.getSource() == btn4) {
			System.err.println("UPDATE");
		} else if (e.getSource() == btn5) {
			System.err.println("DELETE");
		} else if (e.getSource() == btn6) {
			System.err.println("SELECT");
			try {
				pstmt = conn.prepareStatement("SELECT * FROM tbl_memo");
				List<Memo> list = new ArrayList<Memo>();
				Memo memo;
				rs = pstmt.executeQuery();
				while (rs.next()) {
//					System.out.printf("%s작성일 : %s\n==========\n", rs.getString("text"), rs.getTimestamp("createdAt"));
					memo = new Memo();
					memo.setId(rs.getInt("id"));
					memo.setText(rs.getString("text"));
					Timestamp timestamp = rs.getTimestamp("createdAt");
					memo.setCreatedAt(timestamp.toLocalDateTime());
					list.add(memo);
				}
				list.forEach(System.out::println);
				new C07SELECTGUI(list);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} else if (e.getSource() == input) {
			String message = txt1.getText();
			area1.append(message + "\n");
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
				area1.append(message + "\n");
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
			String str = area1.getText(startOffset, endOffset - startOffset);
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

public class C07SwingAddDBMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new C07GUI("Chatting Server");
	}

}
