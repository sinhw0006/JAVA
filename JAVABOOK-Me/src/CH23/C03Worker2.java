package CH23;

public class C03Worker2 implements Runnable{
	C03GUI gui;
	int count = 0;
	
	public C03Worker2(C03GUI gui) {
		this.gui = gui;
	}

	@Override
	public void run() {
		while(true) {
			try {
				if(count%15 ==0) gui.area2.setText("");
				gui.area2.append("WORKER02...."+(++count)+"\n");
				Thread.sleep(320);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("WORKER02 INTERRUPTED...");
	}
	
}
