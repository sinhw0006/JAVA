package CH18;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C04GUI extends JFrame{	
	
	C04GUI(String title){
		//Frame 
		super(title);
		setBounds(100,100,300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//Panel
		JPanel panel = new JPanel();
//		Color col = new Color(71,144,0);
//		panel.setBackground(col);
		panel.setLayout(null);
		
		//Component
		JButton btn1 = new JButton("BTN01");
		btn1.setBounds(10,10,100,30);
		
		JButton btn2 = new JButton("BTN02");
		btn2.setBounds(120,10,100,30);	
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,50,210,30);
		
		JTextArea area1 = new JTextArea();
//		area1.setBounds(10,90,210,350);
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10,90,210,350);
		
		//Panel(Component)
		panel.add(btn1);
		panel.add(btn2);
		panel.add(txt1);
//		panel.add(area1);
		panel.add(scroll1);
		
		
		//Frame(Panel)
		add(panel);
		
		//Frame
		setVisible(true);
	}
}

public class C04SwingMain {

	public static void main(String[] args) {
		new C04GUI("네번째 프레임입니다");
	}

}
