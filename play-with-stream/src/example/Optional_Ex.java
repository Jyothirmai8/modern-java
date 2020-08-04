package example;

import java.util.List;
import java.util.OptionalInt;
import java.util.Random;

public class Optional_Ex {

	public static void main(String[] args) {

		List<Integer> list = List.of(12, 13, 21, 15, 16, 81, 10);
		
		
		OptionalInt optionalInt=
								list
								.stream()
								.mapToInt(n->n)
								.max();
		
//		if(optionalInt.isPresent()) {
//			System.out.println(optionalInt.getAsInt());
//		}else {
//			System.out.println("Unknown");
//		}
		
//		System.out.println(optionalInt.orElse(100));
		
//		optionalInt
//		.ifPresent(max->{
//			System.out.println("MAX "+max);
//		});
		
//		int v=optionalInt
//		.orElseGet(()->new Random().nextInt(100));
//		
//		System.out.println(v);
		
//		int v=optionalInt
//		.orElseThrow();
//		
//		System.out.println(v);
		
		
		

	}

}
