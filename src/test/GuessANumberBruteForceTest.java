package test;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import ar.com.dss.guesser.Guesser;
import ar.com.dss.factory.GuesserFactory;
import ar.com.dss.factory.HumanGuesserFactory;
import ar.com.dss.factory.MachineGuesserFactory;

public class GuessANumberBruteForceTest {

	private GuesserFactory guesserFactory;
	private Guesser guesser;
	
	@Test
	public void humanGuesserTest() {
		guesserFactory = new HumanGuesserFactory();
		guesser = guesserFactory.create();
		int goal = guesser.getGoal();
		int choice = goal;
		
		Assert.assertTrue(guesser.iGuessIt(choice));
		
		choice = choice - 1;
		Assert.assertFalse(guesser.iGuessIt(choice));
		
		choice = choice + 2;
		Assert.assertFalse(guesser.iGuessIt(choice));
	}
	
	@Test
	public void machineGuesserTest() {
		guesserFactory = new MachineGuesserFactory();
		guesser = guesserFactory.create();
		
		int goal = 15;
		boolean iGuessIt = false;
		int choice = guesser.getNumber();

		do {

			System.out.print("My number is " + choice + "?");
			if(choice == goal) {
				guesser.setSign("=");
			} else if(choice > goal) {
				System.out.println("-");
				guesser.setSign("-");
			} else {
				System.out.println("+");
				guesser.setSign("+");
			}

			iGuessIt = guesser.iGuessIt(choice);
			choice = guesser.getChoice();
		} while(!iGuessIt);
		
		assertTrue(iGuessIt);
		
		
	}
}
