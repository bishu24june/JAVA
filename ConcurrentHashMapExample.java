package com.sample.concurrent.program;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
	public static void main(String[] args) {

		ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<String,String>();
		concurrentHashMap.put("A", "Apple");
		concurrentHashMap.put("B", "Blackberry");
		for (Map.Entry e : concurrentHashMap.entrySet()) {
			System.out.println(e.getKey() + " = " + e.getValue());
		}
	}
}