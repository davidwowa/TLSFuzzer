package controller;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import client.TLSClient;
import util.RandomUtil;

public class TLSController {

	private static final Logger logger = Logger.getLogger(TLSController.class.getName());

	public static String tlsHost = "localhost";
	public static int tlsPort = 31337;

	public static int amountTLSRequests = 100;

	public static int threadsAmount = 3;

	public static void main(String[] args) {
		setupLogger();
		TLSClient client = TLSClient.getInstance();

		ExecutorService executor = Executors.newFixedThreadPool(threadsAmount);

		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("start tls fuzzy test host %s, port %s, amount tls requests %s", tlsHost, tlsPort,
					amountTLSRequests));
		}
		// executor.submit(() -> {
		// try {
		// client.sendTLSMessage(tlsHost, tlsPort,
		// TLS13TestDataGenerator.getInstance().generateExampleTLSHello());
		// } catch (Exception e) {
		// if (logger.isErrorEnabled()) {
		// logger.error("error on start from tls fuzzer test", e);
		// }
		// e.printStackTrace();
		// }
		// });
		// executor.submit(() -> {
		// for (int i = 0; i < amountTLSRequests; i++) {
		// try {
		// client.sendTLSMessage(tlsHost, tlsPort,
		// TLS13TestDataGenerator.getInstance().generateExampleTLSHelloRandomExtensionData());
		// showStatus("data generator 1 : only hello client extensions",
		// amountTLSRequests, i);
		// } catch (Exception e) {
		// if (logger.isErrorEnabled()) {
		// logger.error(String.format("error tls fuzzer test number %s", i), e);
		// }
		// e.printStackTrace();
		// }
		// }
		// });
		// executor.submit(() -> {
		// for (int i = 0; i < amountTLSRequests; i++) {
		// try {
		// client.sendTLSMessage(tlsHost, tlsPort,
		// TLS13TestDataGenerator.getInstance().generateExampleTLSRHelloRandomExtensionData());
		// showStatus("data generator 2 : random data in completely hello client",
		// amountTLSRequests, i);
		// } catch (Exception e) {
		// if (logger.isErrorEnabled()) {
		// logger.error(String.format("error tls fuzzer test number %s", i), e);
		// }
		// e.printStackTrace();
		// }
		// }
		// });
		executor.submit(() -> {
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < amountTLSRequests; i++) {
				try {
					byte[] response = client.sendTLSMessage(tlsHost, tlsPort,
							RandomUtil.getInstance().generateRandomArray(100));
					logger.info(new String(response));
					showStatus("data generator 2 : random data in completely hello client", amountTLSRequests, i);
					// TODO get status from ExecutorService is maybe better way...
				} catch (Exception e) {
					if (logger.isLoggable(Level.SEVERE)) {
						logger.severe(String.format("error tls fuzzer test number %s %s", i, e));
					}
					e.printStackTrace();
				}
			}
			logger.info(String.format("end after %s ms", System.currentTimeMillis() - startTime));
		});
		executor.shutdown();
	}

	// TODO make it ...
	public static void showStatus(String name, int total, int part) {
		float percentage = ((float) part / (float) total) * 100f;
		if (((int) percentage % 5 == 0 || (int) percentage == 100 || (int) percentage == 99)
				&& logger.isLoggable(Level.INFO)) {
			logger.info(String.format("%s %s %%", name, percentage));
		}
	}

	private static void setupLogger() {
		try {
			FileHandler fileHandler = new FileHandler("TLSFuzzer.log", 1024 * 1024, 5, true);

			fileHandler.setFormatter(new SimpleFormatter());

			logger.addHandler(fileHandler);
			logger.setLevel(Level.ALL);

			logger.setUseParentHandlers(false);

		} catch (SecurityException | IOException e) {
			logger.log(Level.SEVERE, "Error occurred in setting up the logger", e);
		}
	}
}