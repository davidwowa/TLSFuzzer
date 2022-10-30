package generator;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomGenerator {

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
			System.err.println("error on generating random byte array");
			e.printStackTrace();
		}
		return null;
	}
}