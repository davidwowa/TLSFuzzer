package generator;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RandomGenerator {

	private static final Logger logger = LogManager.getLogger(RandomGenerator.class);

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
			if (logger.isErrorEnabled()) {
				logger.error("error on generating random byte array", e);
			}
			e.printStackTrace();
		}
		return null;
	}
}