package com.sample.lock.program;

/*


Q:Difference between ReentrantLock & ReentrantReadWriteLock class.
A:When a thread acquires a WriteLock, no other thread can acquire the ReadLock nor the WriteLock of the same instance of ReentrantReadWriteLock, unless that thread releases the lock. However, multiple threads can acquire the ReadLock at the same time.

Interfaces


#Condition = Object class wait,notify & notifyAll
#Lock = Synchronization 
ReadWriteLock


Classes

AbstractOwnableSynchronizer
AbstractQueuedLongSynchronizer
AbstractQueuedSynchronizer
LockSupport
#ReentrantLock = Synchronization
ReentrantReadWriteLock
ReentrantReadWriteLock.ReadLock
ReentrantReadWriteLock.WriteLock
StampedLock

*/