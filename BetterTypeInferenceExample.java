package com.program.java8.bettertype.inference;

class Value<T> {
	public static <T> T defaultValue() {
		return null;
	}

	public T getOrDefault(T value, T defaultValue) {
		return (value != null) ? value : defaultValue;
	}
}

public class BetterTypeInferenceExample {
	public static void main(String[] args) {
		final Value<String> value = new Value<>();
		String v = value.getOrDefault("22", Value.defaultValue());
		System.out.println(v);
	}

}
