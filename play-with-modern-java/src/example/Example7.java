package example;

interface I {

	public static final int VAR = 12;

	void abs();

	default void defaultMethod() {

	}

	static void staticMethod() {

	}

}

abstract class AC {

	int var;

	abstract void abs();

	void defaultMethod() {

	}

	static void staticMethod() {

	}

}

interface I1 {
	default void dm1() {
	}

	static void sm1() {
	}
}

interface I2 {
	default void dm1() {
	}

	static void sm1() {
	}
}

class Impln implements I1, I2 {

	@Override
	public void dm1() {
		I2.super.dm1();
	}

}

interface II {

	int PUB = 12;

	private void pri() {

	}

	default void defMethod1() {
		pri();
	}

	default void defMethod2() {
		pri();
	}
}

public class Example7 {

	public static void main(String[] args) {

	}

}
