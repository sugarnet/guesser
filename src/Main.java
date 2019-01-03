import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import ar.com.dss.guesser.Guesser;
import ar.com.dss.factory.GuesserFactory;
import ar.com.dss.factory.HumanGuesserFactory;
import ar.com.dss.factory.MachineGuesserFactory;

public class Main {

	public static void main(String[] args) {
		int choice = 0;
		boolean exit = false;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome my friend...");

		do {
			boolean success = false;
			System.out.println("Type 'me' if you want to guess a number, Otherwise (not empty), I will guess a number...");
	
			String who = scanner.next();
	
			if (StringUtils.equalsIgnoreCase(who, "me")) {
				
				GuesserFactory guesserFactory = new MachineGuesserFactory();
				Guesser guesser = guesserFactory.create();
				
				System.out.println("Type '+' if you want to tell me that the number is bigger or '-' if number is smaller.");
				choice = guesser.getNumber();
				
				do {
					
					System.out.print("Is " + choice + "? ");
					String sign = scanner.next();
					
					guesser.setSign(sign);
					success = guesser.iGuessIt(choice);
					choice = guesser.getChoice();
					
				}while(!success);
				
			} else {
				GuesserFactory guesserFactory = new HumanGuesserFactory();
				Guesser guesser = guesserFactory.create();
				guesser.setGoal(guesser.getNumber());
				
				do {
					
					System.out.print("Choose a number from 1 to 100: ");
					choice = scanner.nextInt();
	
					success = guesser.iGuessIt(choice);
					
				} while (!success);
				
			}
			
			System.out.println();
			System.out.print("Exit? (y / n)");

			String again = scanner.next();

			if(StringUtils.equalsIgnoreCase(again, "y")) {
				exit = true;
			}
			
		} while (!exit);
		
		scanner.close();
	}

}
