package CH23;

public class C03Worker1 implements Runnable{
	C03GUI gui;
	int count = 0;
	
	
	public C03Worker1(C03GUI gui) {
		this.gui = gui;
	}

	@Override
	public void run() {
		while(true) {
			try {
				if(count%15 ==0) gui.area1.setText("");
				gui.area1.append("WORKER01...."+(++count)+"\n");
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("WORKER01 INTERRUPTED...");
	}
	
}
