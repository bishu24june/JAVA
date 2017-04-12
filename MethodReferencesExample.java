package com.program.java8.method.references;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodReferencesExample {

	public static void main(String[] args) {
		final Car car = Car.create( Car::new );
		final Car car1= Car.create( Car::new );
		
		final List< Car > cars = Arrays.asList( car,car1 );
		cars.forEach( Car::collide );
		//cars.forEach( Car::repair );
		
		final Car police = Car.create( Car::new );
		
		cars.forEach( police::follow );


	}

	public static class Car {
		public static Car create(final Supplier<Car> supplier) {
			return supplier.get();
		}

		public static void collide(final Car car) {
			System.out.println("Collided " + car.toString());
		}

		public void follow(final Car another) {
			System.out.println("Following the " + another.toString());
		}

		public void repair() {
		}
	}

}
