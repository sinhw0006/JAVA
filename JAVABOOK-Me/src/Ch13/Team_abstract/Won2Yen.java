package Ch13.Team_abstract;

import java.util.Scanner;

class Won2Yen extends Converter {

	public Won2Yen() {
		super();
	}

	public Won2Yen(double ratio) {
		this.ratio = ratio;
	}
	
	public Won2Yen(int ratio) {
		this.ratio = (double)ratio;
	}

	@Override
	protected double convert(double src) {
		// TODO Auto-generated method stub
		return Math.round(src / ratio);
	}

	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return "원";
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "엔";
	}

}


