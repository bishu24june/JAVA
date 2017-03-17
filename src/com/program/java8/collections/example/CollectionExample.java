package com.program.java8.collections.example;

import java.util.Arrays;

public class CollectionExample {

	public static void main(String[] args) {
	//	Arrays.asList( "a", "b", "d" ).forEach( e -> System.out.println( e ) );
	//	Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );
		
		/*Arrays.asList( "a", "b", "d" ).forEach( e -> {
			    System.out.print( e );
			    //System.out.print( e );
			} );*/
		
		
		Arrays.asList( "k", "b", "d" ).sort( (e1, e2)  -> e1.compareTo( e2 ) );
		
		
		
		
		Arrays.asList( "k", "b", "d" ).sort( ( e1, e2 ) -> {
			    int result = e1.compareTo( e2 );
			    return result;
			} );


	}

}
