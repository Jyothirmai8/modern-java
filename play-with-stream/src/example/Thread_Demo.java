package example;

import java.util.Scanner;

/*
 * s/w 
 * 
 *  2 types od task
 *  
 *  task1 ==> computation
 *  task2 ==> io
 * 
 */

public class Thread_Demo {

	public static void computation() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " intiatited computation");
		while (true) {
		}
		// System.out.println(name +" completed computation");
	}

	public static void io() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " intiatited io");
		Scanner sc = new Scanner(System.in);
		System.out.println("say ur name");
		String user = sc.nextLine();
		System.out.println("hello " + user);
		System.out.println(name + " intiatited io");
		sc.close();
	}

	public static void main(String[] args) {

		Thread ioThread = new Thread(() -> {
			io();
		});
		ioThread.start();

		Thread computationThread = new Thread(() -> {
			computation();
		});
		computationThread.start();

	}

}
