package ar.com.dss.factory;

import ar.com.dss.guesser.Guesser;
import ar.com.dss.guesser.MachineGuesser;

public class MachineGuesserFactory extends GuesserFactory {

	@Override
	public Guesser create() {
		return new MachineGuesser();
	}

}
