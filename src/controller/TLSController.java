package controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import client.TLSClient;
import util.RandomUtil;

public class TLSController {

	private static final Logger logger = LogManager.getLogger(TLSController.class);

	public static String tlsHost = "localhost";
	public static int tlsPort = 31337;

	public static int amountTLSRequests = 100;

	public static int threadsAmount = 3;

	public static void main(String[] args) {
		TLSClient client = TLSClient.getInstance();

		ExecutorService executor = Executors.newFixedThreadPool(threadsAmount);

		if (logger.isInfoEnabled()) {
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
					if (logger.isErrorEnabled()) {
						logger.error(String.format("error tls fuzzer test number %s", i), e);
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
				&& logger.isInfoEnabled()) {
			logger.info(String.format("%s %s %%", name, percentage));
		}
	}
}