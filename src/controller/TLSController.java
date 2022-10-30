package controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import client.TLSClient;
import generator.TLS12TestDataGenerator;
import generator.TLS13TestDataGenerator;
import server.TLSServer;

public class TLSController {

	public static void main(String[] args) {
		TLSServer server = new TLSServer();
		TLSClient client = new TLSClient();

		ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.submit(() -> {
			try {
				server.simpleServer();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		executor.submit(() -> {
			try {
				client.sendTLSMessage("localhost", 44330, TLS13TestDataGenerator.getInstance().createTestTLSHello());
				client.sendTLSMessage("localhost", 44330, TLS13TestDataGenerator.getInstance().generateExampleTLSHello());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}