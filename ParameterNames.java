package com.program.java8.parameter.names;

import java.lang.reflect.Method;

import java.lang.reflect.Parameter;

public class ParameterNames {

	public static void main(String[] args) throws Exception {

        Method method = ParameterNames.class.getMethod( "main", String[].class );
        
        System.out.println(method.getParameters());

        for( final Parameter parameter: method.getParameters() ) {

            System.out.println( "Parameter: " + parameter.getName() );

        }
        
	}
}