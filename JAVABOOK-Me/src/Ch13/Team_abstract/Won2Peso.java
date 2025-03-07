package Ch13.Team_abstract;

public class Won2Peso extends Converter {

	public Won2Peso() {
		super();
	}

	public Won2Peso(double ratio) {
		super();
		this.ratio = ratio;

	}

	@Override
	protected double convert(double src) {
		// TODO Auto-generated method stub

		return Math.round((src / ratio) * 100) / 100.0;
	}

	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return "원화";
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "페소";
	}

}
