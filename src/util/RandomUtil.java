package util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RandomUtil {

	private static final Logger logger = LogManager.getLogger(RandomUtil.class);

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
			if (logger.isErrorEnabled()) {
				logger.error("error on generating random array", e);
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
			if (logger.isErrorEnabled()) {
				logger.error("error on generating random number", e);
			}
			e.printStackTrace();
		}
		return -1;
	}
}