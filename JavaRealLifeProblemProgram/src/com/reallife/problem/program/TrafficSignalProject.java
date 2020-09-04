/**
 * 
 */
package com.reallife.problem.program;

/**
 * @author bishu
 *
 */

abstract class TrafficSignal {

	public final static int GO = 0;
	public final static int CAUTION = 1;
	public final static int STOP = 2;
	public final static int NUMBER_OF_STATES = 3;

	boolean passageRequested = false;
	int state = STOP;

	public boolean getPassageRequested() {
		return passageRequested;
	}

	public void requestPassage() {
		if (state == STOP) {
			passageRequested = true;
		}
	}

	public void passageGranted() {
		passageRequested = false;
	}

	public void changeState() {
		this.state = (state + 1) % NUMBER_OF_STATES;
		if (state == GO) {
			passageRequested = false;
		}
	}

	public int getState() {
		return state;
	}
}

class TrafficLight extends TrafficSignal {
	public String getMessage() {
		switch (state) {
		case STOP:
			return "red";
		case GO:
			return "green";
		case CAUTION:
			return "yellow";
		default:
			return "illegal state";
		}
	}
}

// The WalkSign subclass
class WalkSign extends TrafficSignal {
	public String getMessage() {

		switch (state) {
		case STOP:
			return "Don't Walk";
		case GO:
			return "Walk";
		case CAUTION:
			return "Flashing Don't Walk";
		default:
			return "illegal state";
		}
	}
}

public class TrafficSignalProject {

	public static void main(String[] args) {

		WalkSign w1 = new WalkSign();
		for (int i = 0; i <= TrafficSignal.NUMBER_OF_STATES; i++) {
			System.out.println(w1.getMessage());
			w1.changeState();
		}

		TrafficLight t1 = new TrafficLight();
		for (int i = 0; i <= TrafficSignal.NUMBER_OF_STATES; i++) {
			System.out.println(t1.getMessage());
			t1.changeState();
		}

	}

}
