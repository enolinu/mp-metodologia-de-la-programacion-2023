package uo.mp.s6.greenhouse.sensors;

import java.util.Random;

import uo.mp.s6.greenhouse.controllers.devicescanner.Scanneable;

public class HumiditySensor implements Scanneable{
	
	private int id;
	
	public HumiditySensor(int id) {
		this.id = id;
	}
	
	public int getHumidity() {
		return new Random().nextInt(101);
	}
	
	@Override
	public String toString() {
		return "[HumiditySensor] " + id ;
	}

	@Override
	public boolean check() {
		return new Random().nextDouble() >= 0.05;
	}

}
