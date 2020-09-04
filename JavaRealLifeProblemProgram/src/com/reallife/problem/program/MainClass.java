package com.reallife.problem.program;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

enum Lamp {


	// Express12A line lamp
	S2N("N2S", "S2W", false), 
	S2W("N2E", "E2W", false),
	S2E(null, null, true), 
	
	E2W("W2E", "E2S", false), 
	E2S("W2N", "S2N", false), 
	E2N(null, null, true), 
	
	N2S(null, null, false), 
	N2E(null, null, false),
	N2W(null, null, true), 
	
	W2E(null, null, false), 
	W2N(null, null, false),
	W2S(null, null, true);
	
	// The corresponding direction lamp
	private String oppsite;
	// The lamp to light the next
	private String next;
	// The current state, trueExpressed as green
	private boolean light;

	Lamp(String oppsite, String next, boolean light) {
		this.oppsite = oppsite;
		this.next = next;
		this.light = light;
	}

	// lightUpSaid the light
	public void lightUp() {
		light = true;
		System.out.println(name() + " The green light");
		// If the lamp is not empty, At the same time, change direction lamp is corresponding to the state 

		if (oppsite != null)
			Lamp.valueOf(oppsite).lightUp();
	}

	// lightDownSaid the red light
	public Lamp lightDown() {
		light = false;
		System.out.println(name() + " The red light");
		// If the lamp is not empty, At the same time, change direction lamp is corresponding to the state
		if (oppsite != null)
			Lamp.valueOf(oppsite).lightDown();
		// Returns the next direction of the lamp
		if (next != null)
			return Lamp.valueOf(next);
		return null;
	}

	// Get the current state
	public boolean isLight() {
		return light;
	}
}

class LampControler {

	// Said the first light cycle control,Also for the light
	Lamp currentLamp = Lamp.S2N;
	// Provides methods to control of traffic lights2222

	public void start() {

		// The lights green 9: currentLamp.lightUp(); 10: 1 //Timer
		ScheduledExecutorService timer = Executors.newScheduledThreadPool(1); // Every10Second
																				// change
																				// status

		timer.scheduleAtFixedRate(new Runnable() {
			public void run() {
				// The lamp dimming, And get the next set of lights to quote
				currentLamp = currentLamp.lightDown();
				// the next set of lights green
				currentLamp.lightUp();
			}
		}, 10, 10, TimeUnit.SECONDS);

	}
}

class Road {

	// Route name :
	private String name;
	// storage of vehicles set

	private List<String> vechicles = new LinkedList<String>();

	public Road(String name) {
		this.name = name;
		ExecutorService pool = Executors.newSingleThreadExecutor();
		pool.execute(new Runnable() {
			public void run() {
				for (int i = 0; i < 1000; i++) {

					try {
						Thread.sleep((new Random().nextInt(5) + 1) * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					vechicles.add(Road.this.name + "_" + i);
				}
			}
		});
		ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);

		timer.scheduleAtFixedRate(new Runnable() {
			public void run() {
				if (vechicles.size() > 0) {
					if (Lamp.valueOf(Road.this.name).isLight()) {
						String car = vechicles.remove(0);
						System.out.println(car + " has passed");
					}
				}
			}
		}, 10, 10, TimeUnit.SECONDS);
	}
}

public class MainClass {

	public static void main(String[] args) {
		// The controller starts to work
		new LampControler().start();
		// create 12 routes the instance of
		Lamp[] lamps = Lamp.values();
		for (int i = 0; i < lamps.length; i++) {
			new Road(lamps[i].name());
		}
	}
}
