package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text. Each number 0-63 is
	 * mapped to a character. NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE
	 * ENCODING! Since the numbers 0 through 63 can be represented using 6 bits,
	 * every four (4) characters will represent twenty four (24) bits of data. 4 * 6
	 * = 24 For this exercise, we won't worry about what happens if the total bits
	 * being converted do not divide evenly by 24. If one char is 8 bits, is this an
	 * efficient way of storing binary data? (hint: no) It is, however, useful for
	 * things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or
	 * whatever in a separate location. View this link for a full description of
	 * Base64 encoding https://en.wikipedia.org/wiki/Base64
	 */
	final static char[] base64Chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '+', '/' };

	// 1. Complete this method so that it returns the the element in
	// the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c) {
		int holder = 0;
		for (int i = 0; i < base64Chars.length; i++) {
			if (base64Chars[i] == c) {
				holder = i;
			}
		}
		return (byte) holder;
	}

	// 2. Complete this method so that it will take in a string that is 4
	// characters long and return an array of 3 bytes (24 bits). The byte
	// array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s) {
		byte c1 = convertBase64Char(s.charAt(0));
		byte c2 = convertBase64Char(s.charAt(1));
		byte c3 = convertBase64Char(s.charAt(2));
		byte c4 = convertBase64Char(s.charAt(3));
		byte[] b = new byte[3];
		b[0] = (byte) ((c1 << 2) | (c2 >> 4));
		b[1] = (byte) ((c2 << 4) | (c3 >> 2));
		b[2] = (byte) ((c3 << 6) | (c4));
		return b;
	}

	// 3. Complete this method so that it takes in a string of any length
	// and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		int ix = file.length() * 3;
		int l = ix / 4;
		String[] stringz = new String[file.length() / 4];
		for (int i = 0; i < (file.length() / 4); i++) {
			stringz[i] = file.substring(4 * i, 4 + 4 * i);
		}
		byte[] b = new byte[l];
		for (int i = 0; i < stringz.length; i++) {
			byte[] c = convert4CharsTo24Bits(stringz[i]);
			b[3 * i] = c[0];
			b[3 * i + 1] = c[1];
			b[3 * i + 2] = c[2];
		}
		return b;
	}
}
