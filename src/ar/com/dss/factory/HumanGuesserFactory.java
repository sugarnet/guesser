package ar.com.dss.factory;

import ar.com.dss.guesser.Guesser;
import ar.com.dss.guesser.HumanGuesser;

public class HumanGuesserFactory extends GuesserFactory {

	@Override
	public Guesser create() {
		return new HumanGuesser();
	}

}
