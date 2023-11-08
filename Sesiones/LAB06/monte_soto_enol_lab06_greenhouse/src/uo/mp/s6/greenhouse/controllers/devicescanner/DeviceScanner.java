/**
 * 
 */
package uo.mp.s6.greenhouse.controllers.devicescanner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enolmontesoto
 *
 */
public class DeviceScanner {
	
	private List<Scanneable> scanneables = new ArrayList<Scanneable>();
	
	public void add(Scanneable sc) {
		scanneables.add(sc);
	}
	
	public List<String> scan() {
		
		List<String> messages = new ArrayList<String>();
		
		for(Scanneable sc: scanneables) {
			if(sc.check() == false) {
				messages.add("WARNING! Device " + sc.toString()  + " is not working properly");
			}
		}
		
		return messages;
	}

}
