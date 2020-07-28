package example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * 
 *  transforming Elements with stream api
 * 
 */

public class Example6 {

	public static void main(String[] args) {
		
		
		
		// map
		List<Dish> menu = Dish.menu; 
		
		System.out.println(
				
				menu
				.stream()
				.map(dish->dish.getName())
				.map(String::length)
				.collect(Collectors.toList())
				
		);
		
		// flatmap
		
		// {"Hello","world"}  ==> ["H,"E","L","O","W","R","D"]
		
		
		String[] words= {"HELLO","WORLD"};
		
		System.out.println(
		
		Arrays
		.stream(words)
		.flatMap(word->Arrays.stream(word.split("")))
		.distinct()
		.collect(Collectors.toList())
		
		);
		
		//----------------------------------------------
		
		List<Integer> numbers=List.of(1,2,3);
		
		// (1 1) (2 4) (3 9) => 1 1 1 2 4 4 3 9 27
		
		System.out.println(
		
		numbers
		.stream()
		.flatMap(n->Stream.of(n,n*n,n*n*n))
		.collect(Collectors.toList())
		
		);
		
		
		//----------------------------------------------
		
		
		
		String[] csvReport= {
		"A,IT,1000",
		"B,HR,3000",
		"C,SALES,3000",
		"D,IT,4000"
		};
		
		
		Arrays
		.stream(csvReport)
		.flatMap(record->{
			String[] tokens=record.split(",");
			return Stream.of(tokens[1]);	
		})
		.distinct()
		.forEach(System.out::println);
		
		
	}
	
}
