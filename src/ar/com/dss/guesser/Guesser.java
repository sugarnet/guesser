package ar.com.dss.guesser;
import java.util.Random;

public abstract class Guesser {

	public static final int LEFT_LIMIT = 1;
	public static final int RIGHT_LIMIT = 100;
	private int goal;
	private int choice;
	private String sign;
	
	public int getGoal() {
		return goal;
	}

	public int getChoice() {
		return choice;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}
	
	public String getSign() {
		return sign;
	}
	
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * Return a random number between the left limit and right limit (included)
	 * @param leftLimit
	 * @param rightLimit
	 * @return
	 */
	public int getRandom(int leftLimit, int rightLimit) {
		return leftLimit + (int) (new Random().nextFloat() * (rightLimit - leftLimit));
	}
	
	/**
	 * return true if choice is the same value of the goal
	 * @param choice
	 * @return
	 */
	public abstract boolean iGuessIt(int choice);
	
	protected void sayIsSmaller() {
		System.out.println("The number is smaller...");
	}

	protected void sayIsBigger() {
		System.out.println("The number is bigger...");
	}
	
	
	protected abstract void sayWin();
	
	/**
	 * Return a number depending of the type the guesser
	 * @return
	 */
	public abstract int getNumber();
	
	
}
