package example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Example1 {

	public static void main(String[] args) {
		
		List<Apple> inventory = Arrays.asList(
				new Apple(80, Color.GREEN), 
				new Apple(155, Color.GREEN),
				new Apple(120, Color.RED));
		
		// way-1 :
		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return Integer.compare(o1.getWeight(), o2.getWeight());
			}
		});
		
		// way-2:
		inventory.sort((o1,o2)->Integer.compare(o1.getWeight(), o2.getWeight()));
		
		// way-3: 
		inventory.sort(comparing(a->a.getWeight()));
		
		//way-4:
		inventory.sort(comparing(Apple::getWeight));
		
		

	}

}
