package random;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Random;

public class TLSRandomNumber {
	public String generateASCIIString(int lenght) {
		Random random = new Random(255);

		//TODO 
		// use StringBuilder in this context
		String string = "";

		for (int i = 0; i <= lenght; i++) {
			string = string + (char) random.nextInt();
		}
		return string;
	}

	public long generateNumbers(long min, long max) {
		SecureRandom random = new SecureRandom();
		return random.nextLong() % (max - min + 1) + min;
	}

	public BigDecimal generateBigDecimal(BigDecimal min, BigDecimal max) {
		SecureRandom random = new SecureRandom();
		BigDecimal range = max.subtract(min);
		BigDecimal randomNumberInRange = range.multiply(new BigDecimal(random.nextLong()));
		BigDecimal randomBigDecimal = randomNumberInRange.add(min);
		return randomBigDecimal;
	}

	public static void main(String[] args) {
		TLSRandomNumber r = new TLSRandomNumber();

		System.out.println(r.generateASCIIString(10));

		System.out.println(r.generateNumbers(-10000, 10000));

		System.out.println(r.generateBigDecimal(BigDecimal.ZERO, BigDecimal.TEN));
	}
}
