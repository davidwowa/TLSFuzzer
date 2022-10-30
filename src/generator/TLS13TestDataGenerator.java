package generator;

import java.util.Random;

import util.ArrayUtils;
import util.StringUtil;

public class TLS13TestDataGenerator {

	private static TLS13TestDataGenerator instance;

	private TLS13TestDataGenerator() {
	}

	public static TLS13TestDataGenerator getInstance() {
		if (null == instance) {
			instance = new TLS13TestDataGenerator();
		}
		return instance;
	}

	public byte[] generateExampleTLSHello() {
		var recordHeader = createTestRecordHeader0();
		var handshakeHeader = createTestHandshakeHeader1();
		var clientVersion = createTestClientVersion2();
		var clientRandom = createTestClientRandom3();
		var sessionID = createTestSessionID4();
		var cipherSuite = createTestCipherSuites5();
		var compressionMethods = createTestCompressionMethods6();

		ArrayUtils arrayUtils = new ArrayUtils();

		var arr = arrayUtils.appendAllArrays(recordHeader, handshakeHeader, clientVersion, clientRandom, sessionID,
				cipherSuite, compressionMethods);

		return arr;
	}

	public byte[] createTestTLSHello() {
		// 16
		String exampleTLSHello = "16 03 01 00 f8 01 00 00 f4 03 03 00 01 02 03 04 05 06 07 08 09 0a 0b 0c 0d 0e 0f 10 11 12 13 14 15 16 17 18 19 1a 1b 1c 1d 1e 1f 20 e0 e1 e2 e3 e4 e5 e6 e7 e8 e9 ea eb ec ed ee ef f0 f1 f2 f3 f4 f5 f6 f7 f8 f9 fa fb fc fd fe ff 00 08 13 02 13 03 13 01 00 ff 01 00 00 a3 00 00 00 18 00 16 00 00 13 65 78 61 6d 70 6c 65 2e 75 6c 66 68 65 69 6d 2e 6e 65 74 00 0b 00 04 03 00 01 02 00 0a 00 16 00 14 00 1d 00 17 00 1e 00 19 00 18 01 00 01 01 01 02 01 03 01 04 00 23 00 00 00 16 00 00 00 17 00 00 00 0d 00 1e 00 1c 04 03 05 03 06 03 08 07 08 08 08 09 08 0a 08 0b 08 04 08 05 08 06 04 01 05 01 06 01 00 2b 00 03 02 03 04 00 2d 00 02 01 01 00 33 00 26 00 24 00 1d 00 20 35 80 72 d6 36 58 80 d1 ae ea 32 9a df 91 21 38 38 51 ed 21 a2 8e 3b 75 e9 65 d0 d2 cd 16 62 54";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(exampleTLSHello);
		return StringUtil.getInstance().convertFrom1(tmp);
	}

	public byte[] createTestTLSHelloWithRandomOption() {
		Random random = new Random();
		int r = random.nextInt(17);

		String rr = "" + r;

		if (r < 10) {
			rr = 0 + rr;
		}

		// 16
		String exampleTLSHello = rr
				+ "03 01 00 f8 01 00 00 f4 03 03 00 01 02 03 04 05 06 07 08 09 0a 0b 0c 0d 0e 0f 10 11 12 13 14 15 16 17 18 19 1a 1b 1c 1d 1e 1f 20 e0 e1 e2 e3 e4 e5 e6 e7 e8 e9 ea eb ec ed ee ef f0 f1 f2 f3 f4 f5 f6 f7 f8 f9 fa fb fc fd fe ff 00 08 13 02 13 03 13 01 00 ff 01 00 00 a3 00 00 00 18 00 16 00 00 13 65 78 61 6d 70 6c 65 2e 75 6c 66 68 65 69 6d 2e 6e 65 74 00 0b 00 04 03 00 01 02 00 0a 00 16 00 14 00 1d 00 17 00 1e 00 19 00 18 01 00 01 01 01 02 01 03 01 04 00 23 00 00 00 16 00 00 00 17 00 00 00 0d 00 1e 00 1c 04 03 05 03 06 03 08 07 08 08 08 09 08 0a 08 0b 08 04 08 05 08 06 04 01 05 01 06 01 00 2b 00 03 02 03 04 00 2d 00 02 01 01 00 33 00 26 00 24 00 1d 00 20 35 80 72 d6 36 58 80 d1 ae ea 32 9a df 91 21 38 38 51 ed 21 a2 8e 3b 75 e9 65 d0 d2 cd 16 62 54";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(exampleTLSHello);
		return StringUtil.getInstance().convertFrom1(tmp);
	}

	public byte[] createTestRecordHeader0() {
		String str = "16 03 01 00 f8";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom1(tmp);
	}

	public byte[] createTestHandshakeHeader1() {
		String str = "01 00 00 f4";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom1(tmp);
	}

	public byte[] createTestClientVersion2() {
		String str = "03 03";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom1(tmp);
	}

	public byte[] createTestClientRandom3() {
		// R
		String str = "00 01 02 03 04 05 06 07 08 09 0a 0b 0c 0d 0e 0f 10 11 12 13 14 15 16 17 18 19 1a 1b 1c 1d 1e 1f";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom1(tmp);
	}

	public byte[] createTestSessionID4() {
		// R
		String str = "20 e0 e1 e2 e3 e4 e5 e6 e7 e8 e9 ea eb ec ed ee ef f0 f1 f2 f3 f4 f5 f6 f7 f8 f9 fa fb fc fd fe ff";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom1(tmp);
	}

	public byte[] createTestCipherSuites5() {
		// R
		String str = "00 08 13 02 13 03 13 01 00 ff";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom1(tmp);
	}

	public byte[] createTestCompressionMethods6() {
		// R
		String str = "01 00";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom1(tmp);
	}
}