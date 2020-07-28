package com.util;

import java.util.Comparator;

public interface List extends Collection {

	void add(int idx, String item);

	default void sort(Comparator<String> comparator) {
		// sorting logic
	}

}
