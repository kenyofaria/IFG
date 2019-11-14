package br.edu.ifg.threads.webservice.client;

/**
 * This set of classes were written to show how you can define different threads with make
 * use of the same resource, in this case DataHelper class, which aims to print
 * the results of each thread.
 * 
 * 
 * IMPORTANT: These classes don't aim to show best development practices.
 * @author kenyo
 *
 */

public class Main {

	public static void main(String[] args) {
		DataHelper dataHelper = new DataHelper();

		Runnable tarefa1 = new ClientGet("https://jsonplaceholder.typicode.com/posts/1", dataHelper);
		Thread t1 = new Thread(tarefa1, "thread-posts");
		t1.start();

		Runnable tarefa2 = new ClientGet("https://jsonplaceholder.typicode.com/comments/2", dataHelper);
		Thread t2 = new Thread(tarefa2, "thread-comments");
		t2.start();

	}
}
