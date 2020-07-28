package example;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * 
 * @author nag
 *
 *
 *         eager vs lazy computation
 *
 */

public class Example5 {

	public static String getApplicationState() {
		System.out.println("collecting appln state");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return LocalDateTime.now().toString();
	}

	public static void main(String[] args) {

		// computationOne("hello", null);
		// computationTwo("hello", null);

		Predicate<String> predicate = s -> s.isEmpty();
		String name = "Nag";

		// ..
		predicate.test(name);

	}

	private static void computationOne(String string1, String string2) {
		Objects.requireNonNull(string1, "string1 may not be null! " + getApplicationState());
		Objects.requireNonNull(string2, "string2 may not be null! " + getApplicationState());
		System.out.println(string1.hashCode() ^ string2.hashCode());
	}

	private static void computationTwo(String string1, String string2) {
		Objects.requireNonNull(string1, () -> "string1 may not be null! " + getApplicationState());
		Objects.requireNonNull(string2, () -> "string2 may not be null! " + getApplicationState());
		System.out.println(string1.hashCode() ^ string2.hashCode());
	}

}
