package org.kol.LightApp;

public class LedLightImpl implements ISwitch {

	// Implementation Logic

	@Override
	public void switchOn() {

		System.out.println("LedLight On");

	}

	@Override
	public void switchOff() {

		System.out.println("LedLight Off");
	}

}
