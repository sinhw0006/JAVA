package CH00; // 패키지 구별 코드

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.css.RGBColor;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CH00 extends JFrame {
    public CH00() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setResizable(false);

        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        
        final int buttonSize = 50;
        final int buttonCount = 5;
        final int buttonCout2 = buttonCount*buttonCount;
        final int boomCount = 10;
        Set<Integer> s = new HashSet<Integer>();
        
        Random random = new Random();
        
        int aroundBoomCount[] = new int[buttonCout2]; 
        
        int boom[] = new int[buttonCout2];
        
        JButton[] btn = new JButton[buttonCout2];
        setSize((buttonSize+10)*buttonCount+5, (buttonSize+10)*buttonCount+30);
        for (int i = 0; i < buttonCount; i++) {
            for (int j = 0; j < buttonCount; j++) {
                int xPosition = (j * (buttonSize+10));
                int yPosition = (i * (buttonSize+10));
                btn[i * buttonCount + j] = new JButton();
                btn[i * buttonCount + j].setBounds(xPosition, yPosition, buttonSize, buttonSize);
                btn[i * buttonCount + j].setBackground(null);
                btn[i * buttonCount + j].putClientProperty("data", i * buttonCount + j);
                btn[i * buttonCount + j].addActionListener(new ActionListener() {
					
					@Override 
					public void actionPerformed(ActionEvent e) {
						JButton clickButton = (JButton) e.getSource();
						int clickValue = (int) clickButton.getClientProperty("data");
						
						while(boomCount != s.size()) {
							int boomAdd = random.nextInt(buttonCout2)+1;
							if(boomAdd != clickValue) {
								s.add(boomAdd);
							}
							for(int i = 0; i<buttonCout2; i++) {
					       		boom[i] = s.contains(i+1) ? 1:0;
					        }
				        }
						System.out.println(clickButton.getClientProperty("data")+" / "+ boom[clickValue]);
						int left = clickValue-1 < 0 || (clickValue+1) % buttonCount == 1? clickValue : clickValue-1;
						int right = ((clickValue+1) % buttonCount) == 0 ? clickValue: clickValue+1;
						int top = clickValue-buttonCount < 0 ? clickValue : clickValue-buttonCount;
						int bottom = clickValue+buttonCount >= buttonCout2 ? clickValue:clickValue+buttonCount;
						btn[clickValue].setBackground(btn[clickValue].isBackgroundSet()? null: Color.WHITE);
						if(clickValue != left) btn[left].setBackground(btn[left].isBackgroundSet()? null: Color.WHITE);
						if(clickValue != right) btn[right].setBackground(btn[right].isBackgroundSet()? null: Color.WHITE);
						if(clickValue != top) btn[top].setBackground(btn[top].isBackgroundSet()? null: Color.WHITE);
						if(clickValue != bottom) btn[bottom].setBackground(btn[bottom].isBackgroundSet()? null: Color.WHITE);
					}
				});
                contentPane.add(btn[i * buttonCount + j]);
            }
        }

        setVisible(true);
    }
    public static void main(String [] args) {
    	CH00 mf = new CH00();
    }
}
