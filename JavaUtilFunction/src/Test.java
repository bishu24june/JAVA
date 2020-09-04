import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		double d = -2.9;
		int i= (int)d ;
		i *= (int) Math.ceil(d);
		
		i *= (int) Math.abs(d);
		System.out.println(i);
		
		TreeSet map =  new TreeSet();
		map.add("one");
		map.add("two");
		map.add("tree");
		map.add("four");
		map.add("a");
		
		
		System.out.println(map);
	}

}
