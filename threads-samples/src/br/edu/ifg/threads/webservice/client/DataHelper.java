package br.edu.ifg.threads.webservice.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataHelper {

	public void printData(InputStream is) throws IOException {
		System.out.println(Thread.currentThread().getName().toUpperCase() + "  trying to accessing print resource....");
		synchronized (this) {
			BufferedReader br = new BufferedReader(new InputStreamReader((is)));
			String output;
			System.out.println("Output from  " + Thread.currentThread().getName().toUpperCase() + "  .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		}
	}
}
