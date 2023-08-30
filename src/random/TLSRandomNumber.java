package random;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Random;

public class TLSRandomNumber {
	public String generateASCIIString(int lenght) {
		Random random = new Random(255);

		StringBuilder string = new StringBuilder();

		for (int i = 0; i < lenght; i++) {
			string.append((char) random.nextInt(255));
		}

		return string.toString();
	}

	public long generateNumbers(long min, long max) {
		SecureRandom random = new SecureRandom();
		return random.nextLong() % (max - min + 1) + min;
	}

	public BigDecimal generateBigDecimal(BigDecimal min, BigDecimal max) {
		SecureRandom random = new SecureRandom();
		BigDecimal range = max.subtract(min);
		BigDecimal randomNumberInRange = range.multiply(new BigDecimal(random.nextLong()));
		return randomNumberInRange.add(min);
	}

	public static void main(String[] args) {
		TLSRandomNumber r = new TLSRandomNumber();

		System.out.println(r.generateASCIIString(15));

		System.out.println(r.generateNumbers(-10000, 10000));

		System.out.println(r.generateBigDecimal(BigDecimal.ZERO, BigDecimal.TEN));
	}
}
