package com.program.java8.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class StreamsExample {

	private enum Status {
		OPEN, CLOSED
	};

	private static final class Task {
		private final Status status;
		private final Integer points;

		Task(final Status status, final Integer points) {
			this.status = status;
			this.points = points;
		}

		public Integer getPoints() {
			return points;
		}

		public Status getStatus() {
			return status;
		}

		@Override
		public String toString() {
			return String.format("[%s, %d]", status, points);
		}
	}

	public static void main(String[] args) {
		//Task task = new Task(Status.OPEN, 1);
		//System.out.println(task.toString());

		final Collection<Task> tasks = Arrays.asList(
				new Task(Status.OPEN, 5),
				new Task(Status.OPEN, 13),
				new Task(Status.CLOSED, 8)
		);
		
		
		// Calculate total points of all active tasks using sum()
		final long totalPointsOfOpenTasks = tasks
		    .stream()
		   // .filter( t -> task.getStatus() == Status.OPEN )
		    .mapToInt( Task::getPoints )
		    .sum();
		        
		System.out.println( "Total points: " + totalPointsOfOpenTasks );
		
		/*// Calculate total points of all tasks
		final double totalPoints = tasks
		   .stream()
		   .parallel()
		   .map( t -> task.getPoints() ) // or map( Task::getPoints ) 
		   .reduce( 0, Integer::sum );
		    
		System.out.println( "Total points (all tasks): " + totalPoints );*/
		
		
		// Calculate the weight of each tasks (as percent of total points) 
		final Collection< String > result = tasks
		    .stream()                                        // Stream< String >
		    .mapToInt( Task::getPoints )                     // IntStream
		    .asLongStream()                                  // LongStream
		    .mapToDouble( points -> points / 3 )   // DoubleStream
		    .boxed()                                         // Stream< Double >
		    .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
		    .mapToObj( percentage -> percentage + "%" )      // Stream< String> 
		    .collect( Collectors.toList() );                 // List< String > 
		        
		System.out.println( result );

	}
}
