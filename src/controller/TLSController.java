package controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import client.TLSClient;
import generator.TLS13TestDataGenerator;

public class TLSController {

	private static final Logger logger = LogManager.getLogger(TLSController.class);

	public static String tlsHost = "localhost";
	public static int tlsPort = 31337;

	public static long amountTLSRequests = 100;

	public static int threadsAmount = 4;

	public static void main(String[] args) {
//		TLSServer server = new TLSServer();
		TLSClient client = TLSClient.getInstance();

		ExecutorService executor = Executors.newFixedThreadPool(threadsAmount);

//		executor.submit(() -> {
//			try {
//				server.simpleServer();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		});
		if (logger.isInfoEnabled()) {
			logger.info(String.format("start tls fuzzy test host %s, port %s, amount tls requests %s", tlsHost, tlsPort,
					amountTLSRequests));
		}
		executor.submit(() -> {
			try {
				client.sendTLSMessage(tlsHost, tlsPort, TLS13TestDataGenerator.getInstance().generateExampleTLSHello());
			} catch (Exception e) {
				if (logger.isErrorEnabled()) {
					logger.error("error on start from tls fuzzer test", e);
				}
				e.printStackTrace();
			}
		});
		executor.submit(() -> {
			try {
				for (int i = 0; i < amountTLSRequests; i++) {
					client.sendTLSMessage(tlsHost, tlsPort,
							TLS13TestDataGenerator.getInstance().generateExampleTLSHelloRandomExtensionData());
				}
			} catch (Exception e) {
				if (logger.isErrorEnabled()) {
					logger.error("error on start from tls fuzzer test", e);
				}
				e.printStackTrace();
			}
		});
		executor.submit(() -> {
			try {
				for (int i = 0; i < amountTLSRequests; i++) {
					client.sendTLSMessage(tlsHost, tlsPort,
							TLS13TestDataGenerator.getInstance().generateExampleTLSRHelloRandomExtensionData());
				}
			} catch (Exception e) {
				if (logger.isErrorEnabled()) {
					logger.error("error on start from tls fuzzer test", e);
				}
				e.printStackTrace();
			}
		});
	}
}