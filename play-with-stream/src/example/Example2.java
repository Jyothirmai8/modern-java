package example;

import java.util.Iterator;
import java.util.List;

public class Example2 {

	public static void main(String[] args) {

		List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// External Iteration
		// way-1
		for (int i = 0; i < integers.size(); i++) {
			System.out.println(integers.get(i));
		}
		// way-2
		Iterator<Integer> iterator = integers.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
		// way-3
		for (Integer integer : integers) {
			System.out.println(integer);
		}

		// Internal Iteration  ==> stream API
		
		//way-4
		integers
		.stream()
		//.parallel()
		.forEach(System.out::println);
		

	}

}
