package _03_Printing_Binary;

public class BinaryPrinter {
	// Complete the methods below so they print the passed in parameter in binary.
	// Don't be afraid to use the methods that are already complete to finish the
	// others.
	// Create a main method to test your methods.
	public static void main(String[] args) {
		printByteBinary((byte) 118);
		printShortBinary((short) 27670);
		printIntBinary(1282311212);
		printLongBinary(1514610092);
	}

	public static void printByteBinary(byte b) {
		int holder = b;
		String l = "";
		for (int i = 6; i >= 0; i--) {
			if ((holder - Math.pow(2, i)) >= 0) {
				holder = (int) (holder - Math.pow(2, i));
				// System.out.println(holder);
				// System.out.println(Math.pow(2,i));
				l += "1";
			} else {
				l += "0";
			}
		}
		System.out.println("Byte Binary");
		System.out.println(l);
		if (b < 0) {
			System.out.println("The input value is invalid.");
		}
	}

	public static void printShortBinary(short s) {
		int holder = s;
		String l = "";
		for (int i = 14; i >= 0; i--) {
			if ((holder - Math.pow(2, i)) >= 0) {
				holder = (int) (holder - Math.pow(2, i));
				l += "1";
			} else {
				l += "0";
			}
		}
		System.out.println("Short Binary");
		System.out.println(l);
		if (s < 0) {
			System.out.println("The imput value is invalid.");
		}
	}

	public static void printIntBinary(int i) {
		int holder = i;
		String l = "";
		for (int x = 30; x >= 0; x--) {
			if ((holder - Math.pow(2, x)) >= 0) {
				holder = (int) (holder - Math.pow(2, x));
				l += "1";
			} else {
				l += "0";
			}
		}
		System.out.println("Int Binary");
		System.out.println(l);
		if (i < 0) {
			System.out.println("The imput value is invalid.");
		}
	}

	public static void printLongBinary(long l) {
		long holder = l;
		String f = "";
		for (int x = 30; x >= 0; x--) {
			if ((holder - Math.pow(2, x)) >= 0) {
				holder = (int) (holder - Math.pow(2, x));
				f += "1";
			} else {
				f += "0";
			}
		}
		System.out.println("Long Binary");
		System.out.println(f);
		if (l < 0) {
			System.out.println("The imput value is invalid.");
		}
	}
}
