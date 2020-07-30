package examples.factory.oo;

public class ProductFactory {

	public static Product getProduct(String name) {
		switch (name) {
		case "loan": {
			return new Loan();
		}
		case "stock": {
			return new Stock();
		}
		case "bond": {
			return new Bond();
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + name);
		}
	}

}
