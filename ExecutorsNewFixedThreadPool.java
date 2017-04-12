package com.sample.concurrent.program;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {
	private String message;

	public WorkerThread(String s) {
		this.message = s;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
		processmessage();// call processmessage method that sleeps the thread

		HashMap<String, String> hm = new HashMap<String, String>();
		
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			System.out.println(Thread.currentThread().getName());
			hm.put(""+i, ""+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		// for 2 seconds
		System.out.println(Thread.currentThread().getName() + " (End)");// prints
	}

	private void processmessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ExecutorsNewFixedThreadPool {
	public static void main(String[] args) {
		// creating a pool of 5 threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		//Executors.defaultThreadFactory();
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("worker" + i);
			executor.execute(worker);// calling execute method of
										// ExecutorService
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		System.out.println("Finished all threads");
	}
}
