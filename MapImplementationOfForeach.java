package com.java8feature.example.labda;

import java.util.ConcurrentModificationException;
import java.util.LinkedHashMap;
import java.util.Map;

/*
	default void forEach(BiConsumer<? super K, ? super V> action) {
	       // Objects.requireNonNull(action);
	        for (Map.Entry<K, V> entry : entrySet()) {
	            K k;
	            V v;
	            try {
	                k = entry.getKey();
	                v = entry.getValue();
	            } catch (IllegalStateException ise) {
	                // this usually means the entry is no longer in the map.
	                throw new ConcurrentModificationException(ise);
	            }
	            action.accept(k, v);
	        }
	    }
*/
public class MapImplementationOfForeach 
{
	
	

	public static void main(String[] args)
    {
		Map<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "Rust");
        map.put(4, "JavaScript");
        map.put(5, "Go");

        map.forEach((k, v) -> System.out.println(k + ":" + v));
	}
	
	


}
