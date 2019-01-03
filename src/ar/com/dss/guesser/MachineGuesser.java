package ar.com.dss.guesser;
import java.util.ArrayList;
import java.util.List;

public class MachineGuesser extends Guesser {

	private List<Integer> mins;
	private List<Integer> maxs;
	
	public MachineGuesser() {
		mins = new ArrayList<>();
		maxs = new ArrayList<>();
	}
	
	@Override
	protected void sayWin() {
		System.out.println("I Win!");
	}

	@Override
	public int getNumber() {

		int left = findLeftLimit();
		int right = findRightLimit();

		if (left <= right) {
			return getRandom(left, right);
		}

		clearArrays();

		return getRandom(left, right);

	}

	protected int findLeftLimit() {

		int left = maxs.stream().mapToInt(v -> v).max().orElse(LEFT_LIMIT);
		return left != LEFT_LIMIT ? left + 1 : left;
	}

	protected int findRightLimit() {
		int right = mins.stream().mapToInt(v -> v).min().orElse(RIGHT_LIMIT);
		return right != RIGHT_LIMIT ? right - 1 : right;
	}

	protected void addMaxs(int choice) {
		maxs.add(choice);
	}

	protected void addMins(int choice) {
		mins.add(choice);
	}

	private void clearArrays() {
		mins.clear();
		maxs.clear();
	}

	@Override
	public boolean iGuessIt(int choice) {
		boolean success = false;
		int number = 0;
		
		switch (this.getSign()) {
			case "+":
	
				addMaxs(choice);
				number = getNumber();
	
				break;
			case "-":
				addMins(choice);
				number = getNumber();
	
				break;
			case "=":
				success = true;
				sayWin();
				break;
			default:
				break;
		}
		
		this.setChoice(number);
		
		return success;
	}

}
