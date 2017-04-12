package com.sample.concurrent.program;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;


class Person {

	private Long id;

	private String name;

	private String address;

	public Person(Long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person copyPerson() {
		Person copyPerson = new Person(this.getId(), this.getName(),
				this.getAddress());
		return copyPerson;

	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}
	
	
}


class PersonLock {

	/**
	 * We do not want multiple lock objects lying around so we make ths class
	 * singleton
	 */
	private PersonLock() {

	}

	/**
	 * Bill Pugh's way of lazy initializing the singleton instance
	 * 
	 * @author dinuka.arseculeratne
	 * 
	 */
	private static class SingletonHolder {
		public static final PersonLock INSTANCE = new PersonLock();
	}

	/**
	 * Use this method to get a reference to the singleton instance of
	 * {@link PersonLock}
	 * 
	 * @return the singleton instance
	 */
	public static PersonLock getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * In this sample, we allow only one thread at at time to update the cache
	 * in order to maintain consistency
	 */
	private Semaphore writeLock = new Semaphore(1);

	/**
	 * We allow 10 concurrent threads to access the cache at any given time
	 */
	private Semaphore readLock = new Semaphore(10);

	public void getWriteLock() throws InterruptedException {
		writeLock.acquire();
	}

	public void releaseWriteLock() {
		writeLock.release();
	}

	public void getReadLock() throws InterruptedException {
		readLock.acquire();
	}

	public void releaseReadLock() {
		readLock.release();
	}
}

class PersonStorage {

	private Map<Integer, Person> personCache = new HashMap<Integer, Person>();

	private int counter = 0;

	/**
	 * This class is made singleton and hence the constructor is made private
	 */
	private PersonStorage() {

	}

	/**
	 * Bill Pugh's way of lazy initializing the singleton instance
	 * 
	 * @author dinuka.arseculeratne
	 * 
	 */
	private static final class SingletonHolder {
		public static final PersonStorage INSTANCE = new PersonStorage();
	}

	/**
	 * Use this method to get a reference to the singleton instance of
	 * {@link PersonStorage}
	 * 
	 * @return the singleton instance
	 */
	public static PersonStorage getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * Inserts the person into the map. Note that we use defensive copying so
	 * that even if the client changes the object later on, those changes will
	 * not be reflected in the object within the map
	 * 
	 * @param person
	 *            the instance of {@link Person} to be inserted
	 * @return the key which signifies the location of the person object
	 * @throws InterruptedException
	 */
	public int putPerson(Person person) throws InterruptedException {

		Person copyPerson = person.copyPerson();
		personCache.put(++counter, copyPerson);

		return counter;
	}

	/**
	  * Here as well we use defensive copying so that the value of the object
	  * reference within the map is not passed in to the calling party.
	  * 
	  * @param id
	  *            the id representing the location of the object within the map
	  * @return the instance of the {@link Person} represented by the key passed
	  *         in
	  * @throws InterruptedException
	  */
	 public Person retrievePerson(int id) throws InterruptedException {
	  PersonLock.getInstance().getReadLock();
	  if (!personCache.containsKey(id)) {
	   throw new RuntimeException("Key is not found");
	  }
	  PersonLock.getInstance().releaseReadLock();
	  return personCache.get(id).copyPerson();
	 }

}

public class TestSemaphore {
	public static void main(String[] args) throws InterruptedException {

		  Thread t1 = new Thread(new Runnable() {

		   @Override
		   public void run() {
		    
		    Person p1 = new Person(1L, "Test1", "XYZ");
		    try {
					PersonLock.getInstance().getWriteLock();
					PersonStorage.getInstance().putPerson(p1);
		    } catch (InterruptedException e) {
		     // Exception handling need to be done
		     e.printStackTrace();
		    }
		   finally{
		          PersonLock.getInstance().releaseWriteLock();
		    }
		   }
		  });

		  Thread t2 = new Thread(new Runnable() {

		   @Override
		   public void run() {
		    
		    Person p2 = new Person(2L, "Test123", "ABC");

		    try {
		    			PersonLock.getInstance().getWriteLock();
		    			PersonStorage.getInstance().putPerson(p2);
		    } catch (InterruptedException e) {
		     // Exception handling need to be done
		    }
		 finally{
		          PersonLock.getInstance().releaseWriteLock();
		    }
		    
		   }
		  });

		  t1.start();
		  t2.start();

		  System.out.println(PersonStorage.getInstance().retrievePerson(2));
		 }
}
