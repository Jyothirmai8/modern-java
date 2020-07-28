package example;

import java.util.Comparator;
import java.util.List;

public class Example7 {
	
	public static void main(String[] args) {
		
		List<Dish> menu = Dish.menu; // 1m
		
		menu
		.stream()
		.map(Dish::getName)
		.sorted((d1,d2)->d2.compareTo(d1))
		.forEach(System.out::println);
		
	}

}
