package examples.factory.fp;

import java.util.function.Supplier;

import examples.factory.oo.Loan;
import examples.factory.oo.Product;

public class App {

	public static void main(String[] args) {

		Product product = ProductFactory.getProduct("loan");

	}

}
