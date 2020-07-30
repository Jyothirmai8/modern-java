package example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Async_Programming_Ex {

	public static CompletableFuture<String> getOrder(int orderId) {
		
		
		ForkJoinPool forkJoinPool=new ForkJoinPool(5);

		return CompletableFuture.supplyAsync(() -> {
			System.out.println("L : "+Thread.currentThread());
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "order-"+orderId;
		},forkJoinPool);

	}

	public static void main(String[] args) {

		for (int i = 0; i < 2; i++) {
		
			
			ForkJoinPool forkJoinPool=new ForkJoinPool(5);
			
			CompletableFuture<String> completableFuture = getOrder(i);
			completableFuture
			.thenApply(order -> "enrich "+order)
			.thenApply(order-> "payment " + order)
			.thenApply(order-> " dispatch " +order)
			.thenAcceptAsync(order -> {
				System.out.println("E : "+Thread.currentThread());
				System.out.println("email " + order);
			},forkJoinPool);

		}

		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
