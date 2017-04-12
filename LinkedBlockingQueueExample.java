package com.sample.concurrent.program;

import java.util.concurrent.LinkedBlockingQueue;

class ObservingConsumer implements Runnable {

	private LinkedBlockingQueue<String> queue;
	private Producer producer;

	public ObservingConsumer(LinkedBlockingQueue<String> queue, Producer producer) {
		this.queue = queue;
		this.producer = producer;
	}

	@Override
	public void run() {

		// As long as the producer is running,
		// we want to check for elements.
		while (producer.isRunning()) {
			System.out.println("ObservingConsumer->Elements right now: " + queue);

			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("OC Completed.");
		System.out.println("Final elements in the queue: " + queue);
	}
}

class Producer implements Runnable {

	private LinkedBlockingQueue<String> queue;
	private boolean running;

	public Producer(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
		running = true;
	}

	// We need to check if the producer thread is
	// Still running, and this method will return
	// the state (running/stopped).
	public boolean isRunning() {
		return running;
	}

	@Override
	public void run() {

		// We are adding elements using put() which waits
		// until it can actually insert elements if there is
		// not space in the queue.
		for (int i = 0; i < 15; i++) {
			String element = "String" + i;

			try {
				queue.put(element);
				System.out.println("Producer->Adding element: " + element);

				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("P Completed.");
		running = false;
	}

}

class RemovingConsumer implements Runnable {
	private LinkedBlockingQueue<String> queue;
	private Producer producer;

	public RemovingConsumer(LinkedBlockingQueue<String> queue, Producer producer) {
		this.queue = queue;
		this.producer = producer;
	}

	@Override
	public void run() {

		// As long as the producer is running,
		// we remove elements from the queue.
		while (producer.isRunning()) {

			try {
					System.out.println("RemovingConsumer->Removing element: " + queue.take());

				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("RC completed.");
	}
}

public class LinkedBlockingQueueExample {

	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

		Producer producer = new Producer(queue);
		ObservingConsumer obsConsumer = new ObservingConsumer(queue, producer);
		RemovingConsumer remConsumer = new RemovingConsumer(queue, producer);

		Thread producerThread = new Thread(producer);
		Thread obsConsumerThread = new Thread(obsConsumer);
		Thread remConsumerThread = new Thread(remConsumer);

		producerThread.start();
		//obsConsumerThread.start();
		remConsumerThread.start();
	}
}
