package CH00; // 패키지 구별 코드

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.css.RGBColor;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.lang.constant.Constable;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

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
        
        final int BUTTONSIZE = 40; // 타일 크기
        final int ROW = 9; // 타일 배열  - 가로		초급 - 9 9 10 // 중급 - 16 16 40 // 고급 - 30 16 99 
        final int COLUMN = 9; // 타일 배열 - 세로
        final int TILECOUNT = ROW*COLUMN; // 타일 갯수
        final int BOOMCOUNT = 10; // 지뢰갯수
        final int[] REMAINCOUNT = {TILECOUNT,BOOMCOUNT}; // [0]: 남은 타일 [1] : 남은폭탄
        final int[] SECOND = {0,0}; // [0] : 초 단위 [1] : 타이머 활성화 상태 
        
        // 기본 라벨
        JLabel label1 = new JLabel("남은 지뢰 : ");
        label1.setBounds(BUTTONSIZE*(ROW/2)-30, 5, 100, 30);
        contentPane.add(label1);
        // 폭탄 갯수 라벨
        JLabel label2 = new JLabel(String.valueOf(BOOMCOUNT));
        label2.setBounds(BUTTONSIZE*(ROW/2)+30, 5, 100, 30);
        contentPane.add(label2);
        // 타이머 라벨
        JLabel label3 = new JLabel();
        label3.setBounds(BUTTONSIZE*(ROW/2)+60, 5, 100, 30);
        contentPane.add(label3);
        
        
        // 객체들
        Timer timer = new Timer();
        Set<Integer> s = new HashSet<Integer>();
        Random random = new Random();
        MouseAdapter[] tileListeners = new MouseAdapter[COLUMN * ROW];
        
        // 지뢰 위치값
        int boom[] = new int[TILECOUNT];
        
        
        JButton[] btn = new JButton[TILECOUNT];
        
        setSize((BUTTONSIZE+3)*ROW+15, (BUTTONSIZE+3)*COLUMN+80);
        // 타일 위치 지정
        for (int i = 0; i < COLUMN; i++) {
            for (int j = 0; j < ROW; j++) {
                int xPosition = (j * (BUTTONSIZE+3));
                int yPosition = (i * (BUTTONSIZE+3));
                int btnIndex = (i * ROW + j);
                btn[btnIndex] = new JButton();
                Font currentFont = btn[btnIndex].getFont();
                Font newFont = currentFont.deriveFont(10f);
                btn[btnIndex].setFont(newFont);
                btn[btnIndex].setBounds(xPosition, yPosition+40, BUTTONSIZE, BUTTONSIZE);
                btn[btnIndex].setBackground(null);
                
                // 타일 데이터값
                btn[btnIndex].putClientProperty("data", btnIndex);
                
                // 타일 클릭이벤트 처리
                tileListeners[btnIndex] = new MouseAdapter() {
                    @Override 
                    public void mousePressed(MouseEvent e) {
						// 타일 데이터 값 추출
						JButton clickButton = (JButton) e.getSource();
						int clickValue = (int) clickButton.getClientProperty("data");
						
						// 주변 타일 데이터값 선정
						int aroundBoomData[] = selectAroundTiles(clickValue, ROW, COLUMN);
						
						// 타이머 스타트
						if (SECOND[1] != 1) {
							startTimer(SECOND,timer,label3);
							SECOND[1]++;
						}
						
						// 초기 지뢰 위치 지정
						while(BOOMCOUNT != s.size()) {
							int boomAdd = random.nextInt(TILECOUNT)+1;
							int count = 0;
							
							// 초기 클릭위치 및 주변 제외 선정
							for(int i=0; i<aroundBoomData.length;i++) {
								if(boomAdd == aroundBoomData[i]+1 || boomAdd == clickValue+1) {
									count++;
								}
							}
							// 중복제거
							if (count == 0) {
								s.add(boomAdd);
							}
							// 지뢰 위치 값 저장
							for(int i = 0; i<TILECOUNT; i++) {
					       		boom[i] = s.contains(i+1) ? 1:0;
					       		
					        }
				        }
						// 오른쪽 클릭
						if (e.getButton() == MouseEvent.BUTTON3) {
							if (!clickButton.isBackgroundSet() && REMAINCOUNT[1] != 0) {
								clickButton.setBackground(Color.CYAN);
								label2.setText(String.valueOf(--REMAINCOUNT[1]));
							} else if(clickButton.isBackgroundSet()) {
								clickButton.setBackground(null);
								label2.setText(String.valueOf(++REMAINCOUNT[1]));
							}
	                    }
						// 왼쪽클릭
						else {
							// 오른쪽 클릭한 타일을 열때
	                    	if(clickButton.isBackgroundSet()) {
	                    		label2.setText(String.valueOf(++REMAINCOUNT[1]));
	                    	}
	                    	// 주변 타일 지뢰 갯수값 계산
	                    	TileOpen(aroundBoomData,boom,btn,tileListeners,ROW,COLUMN,REMAINCOUNT);
							
							// 지뢰 클릭 시
							if(boom[clickValue] == 1) {
								timer.cancel();
								clickButton.setText(null);
								clickButton.setBackground(Color.RED);
								switch(JOptionPane.showConfirmDialog(null, "실패\n다시?", null, JOptionPane.YES_NO_OPTION)) {
								case 0:
									dispose();
									main(new String[0]);
									break;
								default:
									System.exit(0);
								}
							}
							REMAINCOUNT[0] = 0;
							for (int i= 0; i<TILECOUNT; i++) {
								if(!btn[i].isBackgroundSet()) {
									REMAINCOUNT[0]++;
								}
							}
							System.out.println(REMAINCOUNT[0]);
							
							// 모든 타일 오픈(승리)
							if(REMAINCOUNT[0] == 0) {
								timer.cancel();
								switch(JOptionPane.showConfirmDialog(null, "승리\n다시?", null, JOptionPane.YES_NO_OPTION)) {
									case 0:
										dispose();
										main(new String[0]);
										break;
									default:
										System.exit(0);
								}
							}
	                    }
					}
				};
				btn[btnIndex].addMouseListener(tileListeners[btnIndex]);
                contentPane.add(btn[btnIndex]);
            }
        }

        setVisible(true);
        
    }
    public static void TileOpen(int[] aroundBoomData, int[] boom, JButton[] btn,MouseAdapter[] tileListeners, int row, int column, int[] REMAINCOUNT) {
    	int count = 0;
		for(int i=0; i<aroundBoomData.length; i++) {
			if(boom[aroundBoomData[i]] == 1) {
				count++;
			}
		}
		if (count == 0) {
	        btn[aroundBoomData[3] + 1].setText("");

	        // 주변 타일을 하나씩 처리
	        for (int i = 0; i < aroundBoomData.length; i++) {
	        	btn[aroundBoomData[i]].removeMouseListener(tileListeners[aroundBoomData[i]]);
	        	
	            if (!btn[aroundBoomData[i]].isBackgroundSet() && btn[aroundBoomData[i]].getText() == "") {  // 타일이 열려 있지 않으면
	            	btn[aroundBoomData[i]].setBackground(Color.WHITE);
	                // 주변 타일의 상태를 확인하고 재귀적으로 열기
	                if (boom[aroundBoomData[i]] == 0) {
	                    int[] aroundBoomData2 = selectAroundTiles(aroundBoomData[i], row, column);
	                    TileOpen(aroundBoomData2, boom, btn, tileListeners, row, column, REMAINCOUNT);
	                } else {
	                    btn[aroundBoomData[i]].setText(String.valueOf(count));
	                }
	            }
	        }
	    } else {
	    	btn[aroundBoomData[3] + 1].setBackground(Color.WHITE);
	        btn[aroundBoomData[3] + 1].setText(String.valueOf(count));
	        btn[aroundBoomData[3] + 1].removeMouseListener(tileListeners[aroundBoomData[3] + 1]);
	    }
    }
    
    // 타이머 함수
    public static void startTimer(int[] second, Timer timer, JLabel label3) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            	second[0]++;
				int m = second[0]/60;
				int s = second[0]%60;
				label3.setText(String.valueOf(m)+"분"+String.valueOf(s)+"초");
            }
        };
        
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
    // 주변 타일 선정 함수
    public static int[] selectAroundTiles(int clickValue, int ROW, int COLUMN) {
    	int aroundTileData[] = new int[8];
    	
		int top = clickValue-ROW < 0 ? clickValue : clickValue-ROW;
		int topleft = (top == clickValue) || top-1 < 0 || (top+1) % ROW == 1  ? clickValue : top-1;
		int topright = (top == clickValue) || ((top+1) % ROW) == 0 ? clickValue: top+1;
		
    	int left = clickValue-1 < 0 || (clickValue+1) % ROW == 1? clickValue : clickValue-1;
		int right = ((clickValue+1) % ROW) == 0 ? clickValue: clickValue+1;
		
		int bottom = clickValue+ROW >= ROW*COLUMN ? clickValue:clickValue+ROW;
		int bottomleft = (bottom == clickValue) || bottom-1 < 0 || (bottom+1) % ROW == 1? clickValue : bottom-1;
		int bottomright = (bottom == clickValue) || ((bottom+1) % ROW) == 0 ? clickValue: bottom+1;
		
    	aroundTileData[0] = topleft;
    	aroundTileData[1] = top;
    	aroundTileData[2] = topright;
    	aroundTileData[3] = left;
    	aroundTileData[4] = right;
    	aroundTileData[5] = bottomleft;
    	aroundTileData[6] = bottom;
    	aroundTileData[7] = bottomright;
		
		return aroundTileData;
    }
    
    
    public static void main(String [] args) {
    	CH00 mf = new CH00();
    }
}
