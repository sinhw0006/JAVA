package Ch35.gun;

import Ch35.unit.Unit;

public abstract class Gun {
	int maxBullitCnt;
	int curBullitCnt;
	int power;
	
	public abstract void fire(Unit unit);
	public abstract void reload(int bullit);
	
}
