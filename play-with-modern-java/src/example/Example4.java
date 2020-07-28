package example;

import java.util.function.Consumer;

/**
 * 
 * @author nag
 *
 *
 *         LE vs AIC
 *
 */

public class Example4 {

	public static void main(String[] args) {

		// Anonymous class, multiple instances
		System.out.println("\nAnonymous class:");
		for (int i = 0; i < 5; i++) {
			Consumer<String> myPrinter1 = new Consumer<String>() {
				@Override
				public void accept(String msg) {
					System.out.println("Consuming " + msg);
				}
			};
			myPrinter1.accept(myPrinter1.toString());
		}

		// Non-capturing lambda, one instance
		System.out.println("\nNon-capturing lambda:");
		for (int i = 0; i < 5; i++) {
			Consumer<String> myPrinter2 = msg -> System.out.println("Consuming " + msg);
			myPrinter2.accept(myPrinter2.toString());
		}

		// Constant-capturing lambda, one instance
		System.out.println("\nConstant-capturing lambda:");
		final int secret = 42;
		for (int i = 0; i < 5; i++) {
			Consumer<String> myPrinter3 = msg -> System.out.println("Consuming " + msg + ", " + secret);
			myPrinter3.accept(myPrinter3.toString());
		}
		
		new Example4().foo();

	}

	private int id = 1;

	public void foo() {
		System.out.println("\nInstance-capturing lambda:");
		//for (int i = 0; i < 5; i++) {
			// this-capturing lambda, many instances!
			
		//}
		Consumer<String> myPrinter41 = msg -> System.out.println("Consuming " + msg + ", " + this.id);
		myPrinter41.accept(myPrinter41.toString());
		
		Consumer<String> myPrinter42 = msg -> System.out.println("Consuming " + msg + ", " + this.id);
		myPrinter42.accept(myPrinter42.toString());
	}

}
