package com.sample.concurrent.program;

import java.util.concurrent.ThreadFactory;

class DaemonThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}
}

class MaxPriorityThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(Thread.MAX_PRIORITY);
		return t;
	}
}

public class ThreadFactoryDemo {
	public static void main(String[] args) {
		DaemonThreadFactory daemontf = new DaemonThreadFactory();
		MaxPriorityThreadFactory mptf = new MaxPriorityThreadFactory();
		Runnable r = new SimpleTasks("High Priority");
		mptf.newThread(r).start();
		r = new SimpleTasks("Low Priority");
		daemontf.newThread(r).start();
	}
}

class SimpleTasks implements Runnable {
	String s = null;

	public SimpleTasks(String s) {
		this.s = s;
	}

	@Override
	public void run() {
		System.out.println(s + " Simple task done.");
	}
}
