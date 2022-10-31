package controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import client.TLSClient;
import generator.TLS13TestDataGenerator;

public class TLSController {

	public static String tlsHost = "localhost";
	public static int tlsPort = 44330;

	public static void main(String[] args) {
//		TLSServer server = new TLSServer();
		TLSClient client = new TLSClient();

		ExecutorService executor = Executors.newFixedThreadPool(2);

//		executor.submit(() -> {
//			try {
//				server.simpleServer();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		});
		executor.submit(() -> {
			try {
//				client.sendTLSMessage(tlsHost, tlsPort, TLS13TestDataGenerator.getInstance().createTestTLSHello());
				client.sendTLSMessage(tlsHost, tlsPort, TLS13TestDataGenerator.getInstance().generateExampleTLSHello());

//				client.sendTLSMessage(tlsHost, tlsPort, TLS12TestDataGenerator.getInstance().createTestTLSHello());
//				client.sendTLSMessage(tlsHost, tlsPort, TLS12TestDataGenerator.getInstance().generateExampleTLSHello());
				System.exit(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}