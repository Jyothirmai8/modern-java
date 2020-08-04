package examples.chain.fp;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfReponsibilityPattern_Ex {

	public static void main(String[] args) {

		UnaryOperator<String> headerText = s -> "From Nag , Title : " + s;
		UnaryOperator<String> spellCheck = s -> s.replaceAll("labda", "lambda");
		UnaryOperator<String> toUpperCase = String::toUpperCase;

		Function<String, String> function = 
				                          headerText
				                          .andThen(spellCheck)
				                          .andThen(toUpperCase);
		
		String result = function.apply("Function style coding with labda");
		System.out.println(result);
		
	}

}
