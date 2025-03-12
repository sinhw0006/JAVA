package CH18;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;

class C06GUI extends JFrame implements ActionListener{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton input;
	//Frame 
	public C06GUI(String title)  {
		super(title);
		final int MARGIN = 10;
		final int[] TEXTAREASIZE = {500,560};
		final int[] BUTTONSIZE = {TEXTAREASIZE[0]/3,TEXTAREASIZE[1]/10};
		setBounds(400,100,TEXTAREASIZE[0]+BUTTONSIZE[0]+MARGIN*5,TEXTAREASIZE[1]+BUTTONSIZE[1]+MARGIN*7);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);

		//Component
		btn1 = new JButton("파일로 저장");
		btn1.setBounds(TEXTAREASIZE[0]+MARGIN*2,TEXTAREASIZE[0]/10,BUTTONSIZE[0],BUTTONSIZE[1]);
		
		btn2 = new JButton("1 : 1 요청");
		btn2.setBounds(TEXTAREASIZE[0]+MARGIN*2,TEXTAREASIZE[0]/10+BUTTONSIZE[1]*2,BUTTONSIZE[0],BUTTONSIZE[1]);
		
		btn3 = new JButton("대화기록");
		btn3.setBounds(TEXTAREASIZE[0]+MARGIN*2,TEXTAREASIZE[0]/10+BUTTONSIZE[1]*4,BUTTONSIZE[0],BUTTONSIZE[1]);
		
		input = new JButton("입력");
		input.setBounds(TEXTAREASIZE[0]+MARGIN*2,TEXTAREASIZE[1]+MARGIN*2,BUTTONSIZE[0],BUTTONSIZE[1]);
		
		JTextArea area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(MARGIN,MARGIN,TEXTAREASIZE[0],TEXTAREASIZE[1]);
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(MARGIN, TEXTAREASIZE[1]+MARGIN*2, TEXTAREASIZE[0], BUTTONSIZE[1]);
		
		//event listener add
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		input.addActionListener(this);
		
		
		
		//Panel(Component)
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(input);
		panel.add(txt1);
		panel.add(scroll1);
		
		
		
		//Frame(Panel)
		add(panel);
		
		//Frame
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			System.err.println("파일로 저장");
		} else if(e.getSource() == btn2){
			System.err.println("1대1 요청");
		} else if(e.getSource() == btn3){
			System.err.println("대화 기록");
		} else if(e.getSource() == input){
			System.err.println("입력");
		}
	}
}

public class C06SwingEventMain {

	public static void main(String[] args) {
		new C06GUI("Chatting Server");
	}

}
