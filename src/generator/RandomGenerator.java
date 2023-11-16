package generator;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomGenerator {

	private static final Logger logger = Logger.getLogger(RandomGenerator.class.getName());

	private static RandomGenerator instance;

	private RandomGenerator() {
	}

	public static RandomGenerator getInstance() {
		if (null == instance) {
			instance = new RandomGenerator();
		}
		return instance;
	}

	public byte[] generateRandomByteArray(int arraySize) {
		try {
			Random rd = SecureRandom.getInstanceStrong();
			byte[] arr = new byte[arraySize];
			rd.nextBytes(arr);
			return arr;
		} catch (NoSuchAlgorithmException e) {
			if (logger.isLoggable(Level.SEVERE)) {
				logger.severe("error on generating random byte array" + e.getMessage());
			}
			e.printStackTrace();
		}
		return null;
	}
}