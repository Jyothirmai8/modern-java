package example;

import java.util.List;
import static java.util.stream.Collectors.toList;
public class Example3 {
	
	
	public static void main(String[] args) {
		
		List<Dish> menu=Dish.menu;
		
		
		//
		List<String> threeHighCaloricDishNames=
				menu
				.stream()
				.filter(dish->{
					System.out.println(dish);
					return dish.getCalories()>300;
				})
				.map(Dish::getName)
				.limit(3)
				.collect(toList());
		
		System.out.println(threeHighCaloricDishNames);
				
		
	}

}
