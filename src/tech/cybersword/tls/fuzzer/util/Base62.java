package tech.cybersword.tls.fuzzer.util;

public class Base62 {
    private static final String BASE62 = "/0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String encode(long value) {
        StringBuilder sb = new StringBuilder();
        do {
            int i = (int) (value % 62);
            sb.append(BASE62.charAt(i));
            value /= 62;
        } while (value > 0);
        return sb.reverse().toString();
    }

    public static long decode(String str) {
        long result = 0;
        long power = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            int digit = BASE62.indexOf(str.charAt(i));
            result += digit * power;
            power *= 62;
        }
        return result;
    }

    public static void main(String[] args) {
        // Beispiel für Kodierung
        long numberToEncode = 170847823;
        String encoded = encode(numberToEncode);
        System.out.println("Encoded: " + encoded);

        // Beispiel für Dekodierung
        String stringToDecode = "/hvBHQ";
        long decoded = decode(stringToDecode);
        System.out.println("Decoded: " + decoded);
    }
}
