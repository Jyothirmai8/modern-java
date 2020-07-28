package example;

import java.util.function.Predicate;

public class Example3 {

	
	// HOF ( Higher-Order-Function)
	public  static <T> Predicate<T> and(Predicate<T> p1, Predicate<T> p2) {
		return n -> p1.test(n) && p2.test(n);
	}

	public static void main(String[] args) {

		int v = 12;
		String str = "capgemeni";

		Predicate<Integer> isMin = n -> n > 100;
		Predicate<Integer> isMax = n -> n < 1000;
		Predicate<Integer> isMinAndisMax = and(isMin, isMax);
		System.out.println(isMinAndisMax.test(500));
		
		
		Predicate<String> isNotEmpty=s->!s.isEmpty();
		Predicate<String> isValid=s->s.matches("\\d{10}");
		
		Predicate<String> isNotEmptyAndValid=and(isNotEmpty,isValid);
		
		String mobile="1234567890";
		System.out.println(isNotEmptyAndValid.test(mobile));
		

	}

}
