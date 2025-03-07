package Ch13.Team_abstract;

class Won2Euro extends Converter {

	public Won2Euro(double ratio) {
		super();
		this.ratio = ratio;
	}

	@Override
	protected double convert(double src) {
		// TODO Auto-generated method stub
		return Math.round(src / ratio);
	}

	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return "원화";
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "유로"; // 유로는 1563원
	}

}
