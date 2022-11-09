package util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RandomUtil {
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
			e.printStackTrace();
		}
		return null;
	}
}