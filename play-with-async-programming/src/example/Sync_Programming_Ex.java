package example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sync_Programming_Ex {

	public static int f(int x) {
		// ... 10s
		return 1000;
	}

	public static int g(int x) {
		// ..
		return 1000;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

//		int x = 1337;

		// --------------------------------------------------------
//
//		int y = f(x); // pull / sync / blocks
//		int z = g(x); // pull / sync / blocks
//		System.out.println(y + z);

		// --------------------------------------------------------

//		Result result = new Result();
//		Thread t1 = new Thread(() -> {
//			result.left = f(x);
//		});
//		Thread t2 = new Thread(() -> {
//			result.right = g(x);
//		});
//		t1.start();
//		t2.start();
//
//		t1.join();
//		t2.join();
//
//		System.out.println(result.left + result.right);

		// --------------------------------------------------------

		// JDK 1.5

		int x = 1337;
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<Integer> y = executorService.submit(() -> f(x));
		Future<Integer> z = executorService.submit(() -> g(x));

		// ....

		System.out.println(y.get() + z.get());

		// ----------------------------------------------------------

	}

//	static class Result {
//		private int left;
//		private int right;
//	}

}
