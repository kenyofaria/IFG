package br.edu.ifg.threads.webservice.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ClientGet implements Runnable {

	private final String uri;
	private DataHelper dataHelper;

	public ClientGet(String uri, DataHelper dataHelper) {
		this.uri = uri;
		this.dataHelper = dataHelper;
		
	}
	
	@Override
	public void run() {
		try {
			URL url = new URL(uri);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			dataHelper.printData(conn.getInputStream());
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
