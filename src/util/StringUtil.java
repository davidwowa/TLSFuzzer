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

	public String removeWhiteCharacters(String string) {
		if (null != string && !string.isEmpty()) {
			return string.replaceAll("\\s+", "");
		}
		return null;
	}

	public byte[] convertFrom(String string) {
		byte[] ans = new byte[string.length() / 2];

		for (int i = 0; i < ans.length; i++) {
			int index = i * 2;
			int val = Integer.parseInt(string.substring(index, index + 2), 16);
			ans[i] = (byte) val;
		}
		return ans;
	}

	public byte[] convertFrom1(String string) {
		int len = string.length();
		byte[] ans = new byte[len / 2];

		for (int i = 0; i < len; i += 2) {
			ans[i / 2] = (byte) ((Character.digit(string.charAt(i), 16) << 4)
					+ Character.digit(string.charAt(i + 1), 16));
		}
		return ans;
	}

	public byte[] convertFrom2(String string) {
		return string.getBytes();
	}
}