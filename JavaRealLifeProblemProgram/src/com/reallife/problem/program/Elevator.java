package com.reallife.problem.program;

import java.util.Scanner;

public class Elevator {

	  private int currentFloor;

	  public void run() {
		  do{
			 
			  System.out.println("Request for Floor : 1 , 2 , 3 , 4 , 5 : ");
			  Scanner scan= new Scanner(System.in);
			  int personFloor = scan.nextInt();
			  
			  if (personFloor > 5){
				  System.out.println("Floor does not exist : ");
			  }else{
				  moveTo(personFloor);
			  }

			  
			  
		  }while (true);
		  
	    //currentFloor = 1 + ((int) (Math.random() * 10));

	   /* System.out.println("The elevator is now on floor " + currentFloor);
	    System.out.print("Which floor are you at now (0-10) where 0 = basement: ");
	    int personFloor = Keyboard.readInt();
	    
	    System.out.println("Enter the elevator");

	    System.out.println("To which floor do you want to go (0-10) where 0 = basement");
	    int destinationFloor = Keyboard.readInt();
	    moveTo(destinationFloor);
	    System.out.println("Leave the elevator");*/
	  }

	  private void moveTo(int destinationFloor) {
	    if (destinationFloor == currentFloor) {
	      /* nothing to do */
	    } else if (destinationFloor > currentFloor) {
	      moveUpTo(destinationFloor);
	    } else {
	      moveDownTo(destinationFloor);
	    }
	  }

	  private void moveUpTo(int destinationFloor) {
	    System.out.println("The elevator is on its way up ...");
	    while (currentFloor < destinationFloor) {
	      currentFloor++;
	      try{
	    	  Thread.sleep(1000);
	      }catch(InterruptedException e){}
	      System.out.print(currentFloor + " ");
	    }
	    System.out.println("The elevator has arrived");
	  }

	  private void moveDownTo(int destinationFloor) {
	    System.out.println("The elevator is on its way down ...");
	    while (currentFloor > destinationFloor) {
	      currentFloor--;
	      try{
	    	  Thread.sleep(1000);
	      }catch(InterruptedException e){}
	      System.out.print(currentFloor + " ");
	    }
	    System.out.println("The elevator has arrived");
	  }

	  public static void main(String[] args) {
	    new Elevator().run();
	  }

	}