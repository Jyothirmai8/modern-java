package example;

import java.util.List;

public class ParallelStreamEx {

	public static void main(String[] args) {
		
		
		List<Dish> menu=Dish.menu;
		
		System.out.println(
		
		menu
		.parallelStream()
//		.filter(dish->dish.getType().equals(Dish.Type.FISH))
		.map(Dish::getCalories)
		.reduce(0,Integer::sum)
		
		);

	}

}
