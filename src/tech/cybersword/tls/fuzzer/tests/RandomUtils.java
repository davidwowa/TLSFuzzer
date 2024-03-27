package tech.cybersword.tls.fuzzer.tests;

import java.math.BigDecimal;
import java.util.Random;

public class RandomUtils {

	public void init() {
	}

	public void end() {
	}

	public String generateASCIIString(int lenght) {
		Random r = new Random(255);

		String string = "";

		for (int i = 0; i <= lenght; i++) {
			string = string + (char) r.nextInt();
		}

		return string;
	}

	public long generateNumbers(int min, int max) {
		return Long.MIN_VALUE;
	}

	public BigDecimal generateBigDecimal(BigDecimal min, BigDecimal max) {
		return null;
	}
}