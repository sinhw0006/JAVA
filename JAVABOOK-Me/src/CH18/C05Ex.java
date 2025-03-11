package CH18;

import java.awt.Font;
import java.awt.TextArea;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;

class GUI extends JFrame{
	//Frame 
	public GUI(String title)  {
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
		JButton btn1 = new JButton("파일로 저장");
		btn1.setBounds(TEXTAREASIZE[0]+MARGIN*2,TEXTAREASIZE[0]/10,BUTTONSIZE[0],BUTTONSIZE[1]);
		
		JButton btn2 = new JButton("1 : 1 요청");
		btn2.setBounds(TEXTAREASIZE[0]+MARGIN*2,TEXTAREASIZE[0]/10+BUTTONSIZE[1]*2,BUTTONSIZE[0],BUTTONSIZE[1]);
		
		JButton btn3 = new JButton("대화기록");
		btn3.setBounds(TEXTAREASIZE[0]+MARGIN*2,TEXTAREASIZE[0]/10+BUTTONSIZE[1]*4,BUTTONSIZE[0],BUTTONSIZE[1]);
		
		JButton input = new JButton("입력");
		input.setBounds(TEXTAREASIZE[0]+MARGIN*2,TEXTAREASIZE[1]+MARGIN*2,BUTTONSIZE[0],BUTTONSIZE[1]);
		
		JTextArea area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(MARGIN,MARGIN,TEXTAREASIZE[0],TEXTAREASIZE[1]);
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(MARGIN, TEXTAREASIZE[1]+MARGIN*2, TEXTAREASIZE[0], BUTTONSIZE[1]);
		
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
}

public class C05Ex {

	public static void main(String[] args) {
		new GUI("Chatting Server");
	}

}
