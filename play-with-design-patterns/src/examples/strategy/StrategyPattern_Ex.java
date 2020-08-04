package examples.strategy;

interface ValidationStrategy {
	boolean execute(String s);
}

// OO principle ==> Open for Extension , Closed for modification principle
class Validator {
	private final ValidationStrategy strategy;

	public Validator(ValidationStrategy strategy) {
		super();
		this.strategy = strategy;
	}

	public boolean validate(String s) {
		// .....
		return strategy.execute(s);
	}
}

class IsNumeric implements ValidationStrategy {
	@Override
	public boolean execute(String s) {
		return s.matches("\\d+");
	}
}

class IsAllLowerCase implements ValidationStrategy {
	@Override
	public boolean execute(String s) {
		return s.matches("[a-z]+");
	}
}

public class StrategyPattern_Ex {

	public static void main(String[] args) {

		// OO style
		Validator numericValidator = new Validator(new IsNumeric());
		Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
		Validator upperCaseValidator = new Validator(new ValidationStrategy() {
			@Override
			public boolean execute(String s) {
				return s.matches("[A-Z]+");
			}
		});

		// Functional style
		numericValidator = new Validator(s -> s.matches("\\d+"));
		lowerCaseValidator = new Validator(s -> s.matches("[a-z]+"));
		upperCaseValidator = new Validator(s -> s.matches("[A-Z]+"));

	}

}
