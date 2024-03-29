package tech.cybersword.tls.fuzzer.controller;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import tech.cybersword.tls.fuzzer.client.TLSClient;
import tech.cybersword.tls.fuzzer.common.CommonProperties;
import tech.cybersword.tls.fuzzer.generator.TLS13TestDataGenerator;
import tech.cybersword.tls.fuzzer.ui.TLSSystemTray;
import tech.cybersword.tls.fuzzer.util.LoggerUtil;
import tech.cybersword.tls.fuzzer.util.RandomUtil;
import tech.cybersword.tls.fuzzer.util.StringUtil;

public class TLSController {

	private static final Logger logger = LoggerUtil.getLogger(TLSController.class.getName());

	public static String tlsHost = CommonProperties.getInstance().getTlsHost();
	public static int tlsPort = CommonProperties.getInstance().getTlsPort();
	public static int amountTLSRequests = CommonProperties.getInstance().getAmountTLSRequests();
	public static int threadsAmount = CommonProperties.getInstance().getThreadsAmount();

	private static TLSController instance;

	private TLSController() {
		TLSSystemTray.getInstance();
	}

	public static TLSController getInstance() {
		if (instance == null) {
			instance = new TLSController();
		}
		return instance;
	}

	public static void main(String[] args) {
		TLSController.getInstance().mainTest();
	}

	public void mainTest() {
		TLSClient client = TLSClient.getInstance();

		ExecutorService executor = Executors.newFixedThreadPool(threadsAmount);

		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("start tls fuzzy test host %s, port %s, amount tls requests %s", tlsHost, tlsPort,
					amountTLSRequests));
		}

		simpleTLSRandomFixArray(client, executor);
		simpleTLSRandomArray(client, executor);
		simpleTLSHelloTest(client, executor);
		simpleTLSHelloRandomExtensionTest(client, executor);
		simpleTLSRHelloRandomExtensionTest(client, executor);

		executor.shutdown();
	}

	private static void simpleTLSRandomFixArray(TLSClient client, ExecutorService executor) {
		int lastStatus = 0;
		executor.submit(() -> {
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < amountTLSRequests; i++) {
				try {
					byte[] response = client.sendTLSMessage(tlsHost, tlsPort,
							RandomUtil.getInstance()
									.generateRandomArray(CommonProperties.getInstance().getRandomArraySize()));
					if (response.length != 0 && logger.isLoggable(Level.INFO)) {
						logger.info(StringUtil.getInstance().toHexString(response));
					}
					showStatus("simpleTLSRandomFixArray", amountTLSRequests, i, lastStatus);
					// TODO get status from ExecutorService is maybe better way...
				} catch (Exception e) {
					if (logger.isLoggable(Level.SEVERE)) {
						logger.severe(
								String.format("simpleTLSRandomFixArray: error tls fuzzer test number %s %s", i, e));
					}
					e.printStackTrace();
				}
			}
			logger.info(
					String.format("simpleTLSRandomFixArray: end after %s ms", System.currentTimeMillis() - startTime));
		});
	}

	private static void simpleTLSRandomArray(TLSClient client, ExecutorService executor) {
		int lastStatus = 0;
		executor.submit(() -> {
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < amountTLSRequests; i++) {
				try {
					SecureRandom random = SecureRandom.getInstance("NativePRNG");
					int randomNumber = random.nextInt(CommonProperties.getInstance().getRandomMaxArraySize());
					byte[] response = client.sendTLSMessage(tlsHost, tlsPort,
							RandomUtil.getInstance().generateRandomArray(randomNumber));
					if (response.length != 0 && logger.isLoggable(Level.INFO)) {
						logger.info(StringUtil.getInstance().toHexString(response));
					}
					showStatus("simpleTLSRandomArray", amountTLSRequests, i, lastStatus);
					// TODO get status from ExecutorService is maybe better way...
				} catch (Exception e) {
					if (logger.isLoggable(Level.SEVERE)) {
						logger.severe(String.format("simpleTLSRandomArray: error tls fuzzer test number %s %s", i, e));
					}
					e.printStackTrace();
				}
			}
			logger.info(String.format("simpleTLSRandomArray: end after %s ms", System.currentTimeMillis() - startTime));
		});
	}

	private static void simpleTLSHelloTest(TLSClient client, ExecutorService executor) {
		int lastStatus = 0;
		executor.submit(() -> {
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < amountTLSRequests; i++) {
				try {
					byte[] response = client.sendTLSMessage(tlsHost, tlsPort,
							TLS13TestDataGenerator.getInstance().generateExampleTLSHello());
					if (response.length != 0 && logger.isLoggable(Level.INFO)) {
						logger.info(StringUtil.getInstance().toHexString(response));
					}
					showStatus("simpleTLSHelloTest", amountTLSRequests, i, lastStatus);
					// TODO get status from ExecutorService is maybe better way...
				} catch (Exception e) {
					if (logger.isLoggable(Level.SEVERE)) {
						logger.severe(String.format("simpleTLSHelloTest: error tls fuzzer test number %s %s", i, e));
					}
					e.printStackTrace();
				}
			}
			logger.info(String.format("simpleTLSHelloTest: end after %s ms", System.currentTimeMillis() - startTime));
		});
	}

	private static void simpleTLSRHelloRandomExtensionTest(TLSClient client, ExecutorService executor) {
		int lastStatus = 0;
		executor.submit(() -> {
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < amountTLSRequests; i++) {
				try {
					byte[] response = client.sendTLSMessage(tlsHost, tlsPort,
							TLS13TestDataGenerator.getInstance().generateExampleTLSRHelloRandomExtensionData());
					if (response.length != 0 && logger.isLoggable(Level.INFO)) {
						logger.info(StringUtil.getInstance().toHexString(response));
					}
					showStatus("simpleTLSRHelloRandomExtensionTest", amountTLSRequests, i, lastStatus);
					// TODO get status from ExecutorService is maybe better way...
				} catch (Exception e) {
					if (logger.isLoggable(Level.SEVERE)) {
						logger.severe(String.format(
								"simpleTLSRHelloRandomExtensionTest: error tls fuzzer test number %s %s", i, e));
					}
					e.printStackTrace();
				}
			}
			logger.info(String.format("simpleTLSRHelloRandomExtensionTest: end after %s ms",
					System.currentTimeMillis() - startTime));
		});
	}

	private static void simpleTLSHelloRandomExtensionTest(TLSClient client, ExecutorService executor) {
		int lastStatus = 0;
		executor.submit(() -> {
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < amountTLSRequests; i++) {
				try {
					byte[] response = client.sendTLSMessage(tlsHost, tlsPort,
							TLS13TestDataGenerator.getInstance().generateExampleTLSHelloRandomExtensionData());
					if (response.length != 0 && logger.isLoggable(Level.INFO)) {
						logger.info(StringUtil.getInstance().toHexString(response));
					}
					showStatus("simpleTLSHelloRandomExtensionTest", amountTLSRequests, i, lastStatus);
					// TODO get status from ExecutorService is maybe better way...
				} catch (Exception e) {
					if (logger.isLoggable(Level.SEVERE)) {
						logger.severe(String
								.format("simpleTLSHelloRandomExtensionTest: error tls fuzzer test number %s %s", i, e));
					}
					e.printStackTrace();
				}
			}
			logger.info(String.format("simpleTLSHelloRandomExtensionTest: end after %s ms",
					System.currentTimeMillis() - startTime));
		});
	}

	public static void showStatus(String name, int total, int part, int lastShowedNumber) {

		float percentage = ((float) part / (float) total) * 100;
		int percentageRounded = Math.round(percentage);

		if ((percentageRounded % 5 == 0 || percentageRounded == 100 || percentageRounded == 99)
				&& logger.isLoggable(Level.INFO)) {
			if (percentageRounded != lastShowedNumber) {
				String message = String.format("%s %s %%", name, percentageRounded);
				logger.info(message);
				TLSSystemTray.getInstance().showInfoMessage(name, message);
				lastShowedNumber = percentageRounded;
			}
		}
	}
}