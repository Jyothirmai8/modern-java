package example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

interface MyInterface {

	int VAL = 12;

	void absMethod();

	default void defaultMethod() {
	}

	static void staMethod() {
		// validator , factory, ....
	}

}

public class Example6 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add(null);
		list.add("Indu");
		list.add("Riya");
		list.add("Diya");

		Comparator<String> asc = Comparator.nullsLast(Comparator.naturalOrder());

		list.sort(asc);

		System.out.println(list);

	}

}
