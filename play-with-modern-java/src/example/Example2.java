package example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class Example2 {
	
	public static void main(String[] args) {
		
		List<Apple> inventory = Arrays.asList(
				new Apple(80, Color.GREEN,"india"), 
				new Apple(155, Color.GREEN,"swiss"),
				new Apple(155, Color.RED,"aust"));
		
		//-----------------------------------------------------------------------------
		// Comparator
		//-----------------------------------------------------------------------------
		
		Comparator<Apple> byWeightAsc=comparing(Apple::getWeight); // fn1
		Comparator<Apple> byWeightDsc=byWeightAsc.reversed(); // fn2
		Comparator<Apple> byCountryAsc=comparing(Apple::getCountry); // fn3
		Comparator<Apple> byWeighDscAndThenByCountry=byWeightDsc.thenComparing(byCountryAsc);
		inventory
		.sort(byWeighDscAndThenByCountry);
		
		// or
		
		inventory.sort(comparing(Apple::getWeight)
				.reversed()
				.thenComparing(Apple::getCountry));
		
		
		inventory.forEach(System.out::println);
		
		
		
		//-----------------------------------------------------------------------------
		// Predicate
		//-----------------------------------------------------------------------------
		
		Predicate<Apple> redApple=a->a.getColor().equals(Color.RED);
		Predicate<Apple> greenApple=a->a.getColor().equals(Color.GREEN);
		Predicate<Apple> heavyApple=apple->apple.getWeight()>150;
		
		
		Predicate<Apple> redAndHeavyApple=redApple.and(heavyApple); 
		Predicate<Apple> redAndHeavyAppleOrGreen=redAndHeavyApple.or(greenApple);
		Predicate<Apple> notRedApple=redApple.negate();
		
		//-----------------------------------------------------------------------------
		// Function
		//-----------------------------------------------------------------------------
		
		
		Function<Integer, Integer> f=x->x+1;
		
		Function<Integer, Integer> g=x->x*2;
		
		
//		Function<Integer, Integer> h=f.andThen(g);
		Function<Integer, Integer> h=f.compose(g);
		
		System.out.println(h.apply(10));
		
		//
		
		Function<String,String> addHeader=Letter::addHeader;
		
		Function<String, String> transformationPipline=
				addHeader
				.andThen(Letter::checkSpelling)
				.andThen(Letter::addFooter);
		
		
		String letter=transformationPipline.apply("labda");
		System.out.println(letter);
		
		
		Function<String, String> function=addHeader.andThen(Letter::addFooter);
		
	}

}







class Letter{
	public static String addHeader(String text) {
		return "From Nag, :"+text; 
	}
	public static String addFooter(String text) {
		return text +" Kind regards"; 
	}
	public static String checkSpelling(String text) {
		return text.replaceAll("labda", "lambda");
	}
}





