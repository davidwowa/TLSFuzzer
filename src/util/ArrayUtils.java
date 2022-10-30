package util;

public class ArrayUtils {
	
	public byte[] appendAllArrays(byte[]... a) {
		// define array size
		int arraySize = 0;
		for (byte[] b : a) {
			arraySize = arraySize + b.length;
		}
		
		byte[] arr = new byte[arraySize];
		
		int count = 0;
		for (byte[] b : a) {
			for (int i = 0; i < b.length; i++) {
				arr[count] = b[i];
				count++;
			}
		}
		return arr;
	}
}