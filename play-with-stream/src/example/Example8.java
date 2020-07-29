package example;

import java.util.List;

import static java.util.stream.Collectors.*;

public class Example8 {

	public static void main(String[] args) {

		List<Dish> menu = Dish.menu;
		
		
		System.out.println(
		
		// Build stream
		menu
		.stream()
		
		// intermediate operations
		.filter(dish->dish.getCalories()<1000)
		
		// terminal operation
		//.forEach(dish->System.out.println(dish));
		//.count()
		//.mapToInt(dish->dish.getCalories())
		//.reduce((c1,c2)->c1+c2)
		//.sum()
		//.average()
		//.min()
		
		.collect(groupingBy(Dish::getCalories,flatMapping(dish->Dish.dishTags.get(dish.getName()).stream(), toSet())))
		
		);

		
	}

}
