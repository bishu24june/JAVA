package com.generic.example;
/*
----------------------------------------------------------------------------------------------------------------------
//List myList = new ArrayList();  // old-style, non-generic
//is almost identical to
//List<Object> myList = new ArrayList<Object>(); // holds ANY object type
----------------------------------------------------------------------------------------------------------------------
List myList = new ArrayList();
becomes
List<Integer> myList = new ArrayList<Integer>();
and a list meant to hold only Strings goes from
public List changeStrings(ArrayList s) { }
to this:
public List<String> changeStrings(ArrayList<String> s) { }

List<Object> myList = new ArrayList<JButton>();  // NO! 
List<Number> numbers = new ArrayList<Integer>(); // NO! 

List<JButton> myList = new ArrayList<JButton>(); // yes 
List<Object> myList = new ArrayList<Object>();   // yes 
List<Integer> myList = new ArrayList<Integer>(); // yes

By the way, List<? extends Object> and List<?> are absolutely identical! 

1) List<?> list = new ArrayList<Dog>(); //YES
2) List<? extends Animal> aList = new ArrayList<Dog>(); //YES
3) List<?> foo = new ArrayList<? extends Animal>(); //NO
4) List<? extends Dog> cList = new ArrayList<Integer>(); //NO
5) List<? super Dog> bList = new ArrayList<Animal>(); //YES
6) List<? super Animal> dList = new ArrayList<Dog>();//NO

------------------------------------------------------------------------------------------------------------------------
#Remember, the older legacy code was allowed to put anything at all (except primitives) into a collection
----------------------------------------------------------------------------------------------------------------------
*/