package examples;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Resource implements AutoCloseable {
	public Resource() {
		System.out.println("Resource : init()");
	}

	public void opt() {
		System.out.println("Resource : opt()");
//		throw new RuntimeException();
	}

	public void close() {
		System.out.println("Resource : close()");
	}
}

public class CollectionApiEnhancements {

	public static void main(String[] args) throws NoSuchAlgorithmException {

//		Resource resource = new Resource();
//		use(resource);

		// -------------------------------------------------------------------

//		String star = "*";
//		System.out.println(star.repeat(30));
//		System.out.println("java");
//		System.out.println(star.repeat(30));

		// -------------------------------------------------------------------

		int __ = 12;
//		System.out.println(__);

		// -------------------------------------------------------------------

		List<String> friends = new ArrayList<String>();
		friends.add("friend1");
		friends.add("friend2");
		friends.add("friend3");

		friends = Arrays.asList("friend1", "friend2", "friend3");
//		System.out.println(friends);
		friends.set(0, "FRIEND1");
//		System.out.println(friends);
		// friends.add("friend4"); // Exception

		friends = List.of("friend1", "friend2", "friend3");

		Set<String> setFriends = Set.of("friend1", "friend2", "friend3");
//		System.out.println(setFriends);

		Map<String, Integer> phoneBook = new HashMap<String, Integer>();
		phoneBook.put("friend1", 123456789);

		phoneBook = Map.of("friend1", 234567, "friend2", 56789);

		// -------------------------------------------------------------------

		//

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);

//		for (Integer n : numbers) {
//			if (n % 2 == 0)
//				numbers.remove(n);
//		}

//		for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
//			Integer n = iterator.next();
//			if (n % 2 == 0) {
//				numbers.remove(n);
//			}
//		}

//		for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
//			Integer n = iterator.next();
//			if (n % 2 == 0) {
//				iterator.remove();
//			}
//		}

		//

//		numbers.removeIf(n->n%2==0);
//		System.out.println(numbers);

//		-------------------------------------------------------------------

//		numbers.replaceAll(n -> n % 2 == 0 ? 0 : n);
//		System.out.println(numbers);

//		-------------------------------------------------------------------

//		numbers.sort(Integer::compare);
//		System.out.println(numbers);
//		
//		-------------------------------------------------------------------

//		Map<String, Integer> ageMap = new HashMap<String, Integer>();
//		ageMap.put("Nag", 37);
//		ageMap.put("Indu", 32);
//		ageMap.put("Riya", 5);
//		ageMap.put("Diya", 2);

//		Set<Entry<String, Integer>> entries = ageMap.entrySet();
//		for (Entry<String, Integer> entry : entries) {
//			System.out.println(entry.getKey() + " : " + entry.getValue());
//		}
//
//		Set<String> keys = ageMap.keySet();
//		for (String key : keys) {
//			System.out.println(key + " : " + ageMap.get(key));
//		}

//		ageMap.forEach((name, age) -> {
//			System.out.println(name + " : " + age);
//		});

//		ageMap
//		.entrySet()
//		.stream()
//		.sorted(Entry.comparingByValue())
//		.forEachOrdered(System.out::println);

//		Integer age=ageMap.getOrDefault("Unknown", 0);
//		System.out.println(age);

//		-------------------------------------------------------------------
		// Computation based on presence / absence of key in Map
//		-------------------------------------------------------------------

//		Map<String, byte[]> dataToHash = new HashMap<String, byte[]>(); // cache
//		messageDigest = MessageDigest.getInstance("SHA-256");
//
//		List<String> keys = List.of("key1", "key-2");
//		keys.forEach(key -> {
//			dataToHash.computeIfAbsent(key, Ex::calculateDigest);
//		});
//		System.out.println(dataToHash.size());
//		keys.forEach(key -> {
//			dataToHash.computeIfAbsent(key, Ex::calculateDigest);
//		});
//		System.out.println(dataToHash.size());
//		
//		-------------------------------------------------------------------
//		-------------------------------------------------------------------
		// CucurrentHashMap
//		-------------------------------------------------------------------

	}

	static MessageDigest messageDigest;

	private static byte[] calculateDigest(String key) {
		return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
	}

	private static void use(Resource resource) {

		try (resource) {
			resource.opt();
		}

	}

}
