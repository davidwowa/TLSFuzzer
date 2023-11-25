package util;

public class StringUtil {

	private static StringUtil instance;

	private StringUtil() {
	}

	public static StringUtil getInstance() {
		if (null == instance) {
			instance = new StringUtil();
		}
		return instance;
	}

//	public static void main(String[] args) {
//		String testData = "65 78 61 6d 70 6c 65 2e 75 6c 66 68 65 69 6d 2e 6e 65 74".replace(" ", "");
//		System.out.println(StringUtil.getInstance().fromHex(testData));
//	}

	// from
	// https://stackoverflow.com/questions/32806404/convert-hexadecimal-to-string
	public String fromHex(String hex) {
		hex = hex.replaceAll("^(00)+", "");
		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < hex.length(); i += 2) {
			bytes[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
		}
		return new String(bytes);
	}

	public String removeWhiteCharacters(String string) {
		if (null != string && !string.isEmpty()) {
			return string.replaceAll("\\s+", "");
		}
		return null;
	}

	public byte[] convertFrom(String string) {
		int len = string.length();
		byte[] ans = new byte[len / 2];

		for (int i = 0; i < len; i += 2) {
			ans[i / 2] = (byte) ((Character.digit(string.charAt(i), 16) << 4)
					+ Character.digit(string.charAt(i + 1), 16));
		}
		return ans;
	}

	public String toHexString(byte[] byteArray) {
		StringBuilder hexString = new StringBuilder();
        for (byte b : byteArray) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex).append(" ");
        }
        return hexString.toString().toUpperCase().trim();
	}
}