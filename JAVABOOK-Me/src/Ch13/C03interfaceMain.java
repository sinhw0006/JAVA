package Ch13;

interface Remocon {
	int MAX_VOL = 100;
	int MIN_VOL = 0;

	void setVolumn(int vol);

	void powerOn();

	void powerOff();
	}

interface Browser{
	void SearchURL(String url);
}

class TV implements Remocon {
	int vol = 50;
	public void setVolumn(int vol) {
		if(this.vol + vol >= MAX_VOL && vol > 0) {
			this.vol = MAX_VOL;
		} else if(this.vol + vol <= MIN_VOL && vol < 0){
			this.vol = MIN_VOL;
		} else {
			this.vol += vol;
		}
		System.out.println("TV의 현재볼륨 : "+this.vol);
	};

	public void powerOn() {
		System.out.println("TV를 켭니다.");
	};

	public void powerOff() {
		System.out.println("TV를 끕니다.");
	};
}

class RADIO implements Remocon {
	int vol = 50;
	public void setVolumn(int vol) {
		if(this.vol + vol >= MAX_VOL && vol > 0) {
			this.vol = MAX_VOL;
		} else if(this.vol + vol <= MIN_VOL && vol < 0){
			this.vol = MIN_VOL;
		} else {
			this.vol += vol;
		}
		System.out.println("RADIO의 현재볼륨 : "+this.vol);
	};

	public void powerOn() {
		System.out.println("RADIO를 켭니다.");
	};

	public void powerOff() {
		System.out.println("RADIO를 끕니다.");
	};
}

class SmartTv extends TV implements Browser{

	@Override
	public void SearchURL(String url) {
		System.out.println(url+"로 이동");
	}
}

public class C03interfaceMain {
	public static void TurnOn(Remocon controller) {
		controller.powerOn();
	}

	public static void TurnOff(Remocon controller) {
		controller.powerOff();
	}
	public static void VolUp(Remocon controller) {
		controller.setVolumn(5);
	}
	public static void VolDown(Remocon controller) {
		controller.setVolumn(-5);
	}
	public static void Internet(Browser browser, String url) {
		browser.SearchURL(url);
	}

	public static void main(String[] args) {
		TV tv1 = new TV();
		SmartTv tv2 = new SmartTv();
		RADIO radio1 = new RADIO();

		TurnOn(radio1);
		TurnOn(tv2);
		TurnOn(tv1);
		Internet(tv2,"http://www.naver.com");

		TurnOff(radio1);
		TurnOff(tv1);
		
		VolUp(radio1);
		VolDown(radio1);
	}
}
