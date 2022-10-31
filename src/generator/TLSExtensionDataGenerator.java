package generator;

import util.StringUtil;

public class TLSExtensionDataGenerator {

	public byte[] createTestExtensionLength7() {
		String str = "00 58";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom(tmp);
	}

	public byte[] createTestExtensionServerName8() {
		// 65 - 74 -> example.ulfheim.net
		String str = "00 00 00 18 00 16 00 00 13 65 78 61 6d 70 6c 65 2e 75 6c 66 68 65 69 6d 2e 6e 65 74";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom(tmp);
	}

	public byte[] createTestExtensionStatusRequest9() {
		String str = "00 05 00 05 01 00 00 00 00";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom(tmp);
	}

	public byte[] createTestExtensionSupportedGroups10() {
		String str = "00 0a 00 0a 00 08 00 1d 00 17 00 18 00 19";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom(tmp);
	}

	public byte[] createTestExtensionECPointFormat11() {
		String str = "00 0b 00 02 01 00";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom(tmp);
	}

	public byte[] createTestExtensionRenegotiationInfo12() {
		// renegotiation is deprecated
		String str = "ff 01 00 01 00";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom(tmp);
	}

	public byte[] createTestExtensionSCT13() {
		// signed certificate timestamp
		String str = "00 12 00 00";
		String tmp = StringUtil.getInstance().removeWhiteCharacters(str);
		return StringUtil.getInstance().convertFrom(tmp);
	}
}