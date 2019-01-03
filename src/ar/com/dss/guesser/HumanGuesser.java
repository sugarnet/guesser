package ar.com.dss.guesser;

public class HumanGuesser extends Guesser {
	
	public HumanGuesser() {
		setGoal(getNumber());
	}
	
	@Override
	protected void sayWin() {
		System.out.println("You Win!");
	}

	@Override
	public int getNumber() {
		return getRandom(LEFT_LIMIT, RIGHT_LIMIT);
	}

	@Override
	public boolean iGuessIt(int choice) {
		if (getGoal() == choice) {
			sayWin();
			return true;
		} else if (choice > getGoal()) {
			sayIsSmaller();
		} else {
			sayIsBigger();
		}
		
		return false;
	}

}
