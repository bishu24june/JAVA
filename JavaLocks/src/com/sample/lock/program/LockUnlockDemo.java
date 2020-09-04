package com.sample.lock.program;

import java.util.concurrent.locks.ReentrantLock;

public class LockUnlockDemo implements Task {
	final ReentrantLock reentrantLock = new ReentrantLock();

	@Override
	public void performTask() {
		reentrantLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + ": Lock acquired.");
			System.out.println("Processing...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + ": Lock released.\n");
			reentrantLock.unlock();
		}
	}

	public void anyMethod() {
		assert !reentrantLock.isHeldByCurrentThread();
		reentrantLock.lock();
		try {
			// perform task
		} finally {
			reentrantLock.unlock();
		}
	}

	public void anyMethod1() {
		//assert lock.getHoldCount() == 0;
		reentrantLock.lock();
		try {
			// perform task
		} finally {
			reentrantLock.unlock();
		}
	}
}