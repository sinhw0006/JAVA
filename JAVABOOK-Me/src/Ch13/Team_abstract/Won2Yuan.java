package Ch13.Team_abstract;

public class Won2Yuan extends Converter {
	public void won2Yuan() {
	}

	public Won2Yuan(double ratio) {
		super();
		this.ratio = ratio;
	}

	@Override
	protected double convert(double src) {
		return Double.parseDouble(Double.toString(src/ratio).substring(0, Double.toString(src/ratio).indexOf(".")+2));
	}

	@Override
	protected String getSrcString() {
		return "원화";
	}

	@Override
	protected String getDestString() {
		return "위안";
	}

}
