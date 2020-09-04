package com.sample.lock.program;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {

//private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	private static String message = "a";
	
	public static void main(String[] args) throws InterruptedException{
		Thread t1 = new Thread(new Read());
		Thread t2 = new Thread(new WriteA());
		Thread t3 = new Thread(new WriteB());
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
	}
	
	static class Read implements Runnable {

		public void run() {
			for(int i = 0; i<= 10; i ++) {
				if(lock.isWriteLocked()) {
					System.out.println("class Read ->I'll take the lock from Write");
				}
				lock.readLock().lock();
				System.out.println("ReadThread " + Thread.currentThread().getId() + " ---> Message is " + message );
				
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally{
					lock.readLock().unlock();
				}
				}
			}
		}
	
	static class WriteA implements Runnable {

		public void run() {
			for(int i = 0; i<= 10; i ++) {
				try {
					lock.writeLock().lock();
					message = message.concat("a");
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					lock.writeLock().unlock();
				}
				
			}
			}
		}
	
	static class WriteB implements Runnable {

		public void run() {
			for(int i = 0; i<= 10; i ++) {
				try {
					lock.writeLock().lock();
					message = message.concat("b");
					Thread.sleep(2000);
				} 
				
				catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					lock.writeLock().unlock();
				}
				
			}
			}
		}
}