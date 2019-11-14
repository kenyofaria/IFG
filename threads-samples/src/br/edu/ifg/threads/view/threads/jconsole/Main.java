package br.edu.ifg.threads.view.threads.jconsole;


/**
 * This class was written to show how you can define threads and monitor its life cycle through jconsole.
 * Two threads are defined, each one with goal of printing 100 thousands of numbers.
 * 
 * 
 * IMPORTANT: This class doesn't aim to show best development practices.
 * 
 * @author kenyo
 * 
 */

public class Main {

	public static void main(String[] args) {
		System.out.println("executing our first thread.");
		try {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int i = 0;
					while (i < 100000) {
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						i++;
						System.out.println(Thread.currentThread().getName() + " -  vaule of i: " + i);
					}
				}
			}, "Thread-A").start();

			new Thread(new Runnable() {
				@Override
				public void run() {
					int i = 0;
					while (i < 100000) {
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						i++;
						System.out.println(Thread.currentThread().getName() + " -  vaule of i: " + i);
					}
				}
			}, "Thread-B").start();

			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("thread terminated");
	}
}
