package com.generic.example;

import java.util.ArrayList;

import java.util.List;

public class TestPassingArgFromMethod {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<Integer>();
		myList.add(4);
		myList.add(6);
		Inserter in = new Inserter();
		in.insert(myList); // pass List<Integer> to legacy code

		/////////////////////////////////////////////////////////////////////////////////////////
		// make ArrayLists instead of arrays for Dog, Cat, Bird

		List<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());

		List<Cat> cats = new ArrayList<Cat>();

		cats.add(new Cat());
		cats.add(new Cat());

		List<Bird> birds = new ArrayList<Bird>();
		birds.add(new Bird());

		// this code is the same as the Array version

		TestPassingArgFromMethod doc = new TestPassingArgFromMethod();

		// this worked when we used arrays instead of ArrayLists
		//doc.checkAnimals(dogs); // send a List<Dog>
		//doc.checkAnimals(cats); // send a List<Cat>
		//doc.checkAnimals(birds); // send a List<Bird>
		
		/*Animal[] animals = new Animal[3];
		animals[0] = new Cat(); 
		animals[1] = new Dog();*/
		
		List<Animal> animals1 = new ArrayList<Animal>(); 
		animals1.add(new Cat());  // OK 
		animals1.add(new Dog());  // OK

			doc.addAnimalWithSuper(animals1);
			doc.addAnimalWithExtends(animals1);
			doc.addAnimal(animals1);
			doc.doInsert(animals1);
	}
	
	 void doInsert(List<?> list) {     
		 //list.add(new Dog());  
		 //By the way, List<? extends Object> and List<?> are absolutely identical! 
	 } 
	
	public void addAnimalWithSuper(List<? super Dog> animals) {  
		animals.add(new Dog()); // adding is sometimes OK with super 
		}
	public void addAnimalWithExtends(List<? extends Animal> animals) {      
		// animals.add(new Dog());  // NO! Can't add if we use <? extends Animal>                        
		
	}
	public void addAnimal(List<Animal> animals){
		
	}

	public void checkAnimals(ArrayList<Animal> animals) {
		for (Animal a : animals) {
			a.checkup();
		}
	}
}

class Inserter {
	// method with a non-generic List argument
	void insert(List list) {
		list.add(new Integer(42));
		System.out.println(list);
		list.add(new String("str"));

		System.out.println(list);
	}
}

abstract class Animal {

	public abstract void checkup();

}

class Dog extends Animal {

	public void checkup() {

		// implement Dog-specific code

		System.out.println("Dog checkup");
	}
}

class Cat extends Animal {

	public void checkup() {
		// implement Cat-specific code
		System.out.println("Cat checkup");
	}
}

class Bird extends Animal {
	public void checkup() {
		// implement Bird-specific code
		System.out.println("Bird checkup");
	}

}

class AnimalDoctor {
	// method takes an array of any animal subtype
	public void checkAnimals(Animal[] animals) {
		for (Animal a : animals) {
			a.checkup();
		}
	}
}
