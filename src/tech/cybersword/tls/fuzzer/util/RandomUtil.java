package util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomUtil {

	private static final Logger logger = LoggerUtil.getLogger(RandomUtil.class.getName());

	public static RandomUtil instance;

	private RandomUtil() {
	}

	public static RandomUtil getInstance() {
		if (null == instance) {
			instance = new RandomUtil();
		}
		return instance;
	}

	public byte[] generateRandomArray(int arrayLength) {
		try {
			SecureRandom random = SecureRandom.getInstanceStrong();
			return random.generateSeed(arrayLength);
		} catch (NoSuchAlgorithmException e) {
			if (logger.isLoggable(Level.SEVERE)) {
				logger.severe("error on generating random array" + e.getMessage());
			}
			e.printStackTrace();
		}
		return null;
	}

	public byte[] getEmptyArray() {
		return new byte[0];
	}

	public int generateRandomNumber(int start, int end) {
		try {
			SecureRandom random = SecureRandom.getInstanceStrong();
			return random.nextInt(start, end);
		} catch (NoSuchAlgorithmException e) {
			if (logger.isLoggable(Level.SEVERE)) {
				logger.severe("error on generating random number" + e.getMessage());
			}
			e.printStackTrace();
		}
		return -1;
	}
}