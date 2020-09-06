package com.sample.concurrent.program;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer1 implements Runnable{
    
    private BlockingQueue queue;
    
    public Producer1(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        
        // We are adding elements using offer() in order to check if
        // it actually managed to insert them.
        for (int i = 0; i < 4; i++) {
            System.out.println("Trying to add to queue: String " + i +
                    " and the result was " + queue.offer("String " + i));
            
            try {  
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    
    private BlockingQueue queue;
    
    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        
        // As long as there are empty positions in our array,
        // we want to check what's going on.
        while (queue.remainingCapacity() > 0) {
            System.out.println("Queue size: " + queue.size() +
                    ", remaining capacity: " + queue.remainingCapacity());
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ArrayBlockingQueueExample {

    public static void main(String[] args) {
        // Let's create a blocking queue that can hold at most 5 elements.
        BlockingQueue queue = new ArrayBlockingQueue<>(5);
        
        // The two threads will access the same queue, in order
        // to test its blocking capabilities.
        Thread producer = new Thread(new Producer1(queue));
        Thread consumer = new Thread(new Consumer(queue));
        
        producer.start();
        consumer.start();
    }
}

