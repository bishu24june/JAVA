/*What is Mutex? :: Official Definition: “Mutexes are typically used to serialise access to a section of re-entrant code that cannot be executed concurrently by more than one thread. A mutex object only allows one thread into a controlled section, forcing other threads which attempt to gain access to that section to wait until the first thread has exited from that section.”
In other words: Mutex = Mutually Exclusive Semaphore*/


package com.sample.concurrent.program;

/*
 
 Interfaces

BlockingDeque
BlockingQueue
Callable
CompletableFuture.AsynchronousCompletionTask
CompletionService
CompletionStage
ConcurrentMap
ConcurrentNavigableMap
Delayed
Executor
ExecutorService
ForkJoinPool.ForkJoinWorkerThreadFactory
ForkJoinPool.ManagedBlocker
Future
RejectedExecutionHandler
RunnableFuture
RunnableScheduledFuture
ScheduledExecutorService
ScheduledFuture
ThreadFactory
TransferQueue
------------------------------------------------------------------------------

Classes
AbstractExecutorService
---------------------------------------------------------------------------------------------------------
ArrayBlockingQueue:
•	ArrayBlockingQueue: It uses an internal array in which the elements are kept, and the Queue interface imposes 
certain rules (like the FIFO rule, which is essential to any queue). Because it uses an array, it has a fixed 
size which is given in the constructor.
---------------------------------------------------------------------------------------------------------
CompletableFuture
-------------------------------------------------------------------------------------------------------------------
ConcurrentHashMap
Part of the map called Segment (internal data structure) is only getting locked while adding or updating the map.
So ConcurrentHashMap allows concurrent threads to read the value without locking at all.
Concurrency-Level: Defines the number which is an estimated number of concurrently updating threads.

Question : Is this possible for 2 threads to update the ConcurrentHashMap at the same moment ?
Answer : Yes, its possible to have 2 parallel threads writing to the CHM at the same time, infact in the default implementation of CHM, atmost 16 threads can write in parallel. But in worst case if the two objects lie in the same segment, then parallel write would not be possible. On the other-hand reads are not blocking in nature, so any number of threads can read the data at the same time, also reads can overlap with writes.
------------------------------------------------------------------------------------------------------------------
ConcurrentHashMap.KeySetView
ConcurrentLinkedDeque
ConcurrentLinkedQueue
ConcurrentSkipListMap
ConcurrentSkipListSet
CopyOnWriteArrayList
CopyOnWriteArraySet
CountDownLatch
CountedCompleter
CyclicBarrier
DelayQueue
Exchanger
ExecutorCompletionService
Executors
ForkJoinPool
ForkJoinTask
ForkJoinWorkerThread
FutureTask
LinkedBlockingDeque
----------------------------------------------------------------------------------------------------------
LinkedBlockingQueue:
•	LinkedBlocking Queue: It uses nodes (like a linked list), to keep track of the order of the elements, 
which increases the complexity of the data structure. It can have a fixed-size limit as well, 
but if we don’t define one the limit is Integer.MAX_VALUE by default.

The major implementation difference between the two data structures (synchronization-wise) is that because 
ArrayBlockingQueue keeps the elements in an array it needs only one lock to keep everything synchronized. 
On the other hand, LinkedBlockingQueue uses two locks, one for insertion and one for extraction. 
That happens because while ArrayBlockingQueue contains just an array, LinkedBlockingQueue contains a
series of connected nodes, so it doesn’t need to keep track of insertion and extraction at the same time.
---------------------------------------------------------------------------------------------------------
LinkedTransferQueue
Phaser
PriorityBlockingQueue
RecursiveAction
RecursiveTask
ScheduledThreadPoolExecutor
Semaphore = Semaphores are often used to restrict the number of threads than can access some (physical or logical) resource
Some Scenario where Semaphore can be used:
1) To implement better Database connection pool which will block if no more connection is available instead of failing and handover Connection as soon as its available.

2) To put a bound on collection classes. by using semaphore you can implement bounded collection whose bound is specified by counting semaphore.

---------------------------------------------------------------------------------------------------------------
->The Java language gives many ways of handling race conditions when dealing with concurrent threads accessing a 
common resource. Some include;
1.Using the volatile keyword
2.Using classes available in java.util.concurrent and java.util.concurrent.atomic
3.Synchronized blocks
4.Using a Semaphore
----------------------------------------------------------------------------------------------------------------
SynchronousQueue
ThreadLocalRandom
---------------------------------------------------------------------------------------------------------
ThreadPoolExecutor:
?
 
Executors#newFixedThreadPool(int nThreads)
ExecutorService executor = Executors.newFixedThreadPool(20);
is basically

 return new ThreadPoolExecutor(20, 20,
                                  0L, TimeUnit.MILLISECONDS,
                                  new LinkedBlockingQueue<Runnable>());
2.

BlockingQueue<Runnable> threadPool = new LinkedBlockingQueue<Runnable>();
ThreadPoolExecutor tpExecutor = new ThreadPoolExecutor(20, 2000, 0L,
    TimeUnit.MILLISECONDS, threadPool);
---------------------------------------------------------------------------------------------------------
ThreadPoolExecutor.AbortPolicy
ThreadPoolExecutor.CallerRunsPolicy
ThreadPoolExecutor.DiscardOldestPolicy
ThreadPoolExecutor.DiscardPolicy
Enums

TimeUnit
Exceptions

BrokenBarrierException
CancellationException
CompletionException
ExecutionException
RejectedExecutionException
TimeoutException
*/