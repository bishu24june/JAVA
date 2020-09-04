package com.sample.lock.program;

/*
 When the current thread calls lockInterruptibly() and the resource is free, this thread acquires lock and the hold 
 count is incremented by one and returns immediately. If the resource is already held by any other thread, then 
 it will wait until it gets lock or any other thread interrupts it. It means if current thread is waiting for lock 
 but mean while any other thread reaches to acquire lock, then the previous one will be interrupted and returns 
 immediately without acquiring lock. Now find the example of lockInterruptibly(). 
 */

import java.util.concurrent.locks.ReentrantLock;
public class LockInterruptiblyDemo implements Task{
	final ReentrantLock reentrantLock = new ReentrantLock();
	@Override
	public void performTask() {
	     try {
		   reentrantLock.lockInterruptibly();
		   //if it is not able to acquire lock because of other threads interrupts,
		   //it will throw InterruptedException and control will go to catch block.
		   try {
				System.out.println(Thread.currentThread().getName() +": Lock acquired.");
				System.out.println("Work on progress...");
			        Thread.sleep(2000);	
		   } finally {
				System.out.println(Thread.currentThread().getName() +": Lock released.");
				reentrantLock.unlock();
		   }
	     } catch (InterruptedException e) {
		   e.printStackTrace();
	     }
	}
} 