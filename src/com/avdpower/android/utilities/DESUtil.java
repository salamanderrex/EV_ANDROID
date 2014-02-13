package com.avdpower.android.utilities;

import org.junit.Test;

public class DESUtil {
	// LITTLE_ENDIAN

	public static int bytesToInt(byte[] bytes, int numberOFdigit,
			int lower_position, boolean is_sign) {
		int i = 0;
		if (numberOFdigit == 8) {
			if (is_sign == true)
				i = bytesToSignInt8(bytes[lower_position]);
			else
				i = bytesToUnSignInt8(bytes[lower_position]);
		}

		else if (numberOFdigit == 16) {
			if (is_sign == true)
				i = bytesToSignInt16(bytes[lower_position],
						bytes[lower_position + 1]);
			else
				i = bytesToUnSignInt16(bytes[lower_position],
						bytes[lower_position + 1]);
		}

		return i;
	}

	public static int bytesToInt(byte[] bytes, int numberOFdigit,
			int lower_position)
	/*
	 * @return unsign int
	 */
	{
		int i = bytesToInt(bytes, numberOFdigit, lower_position, false);
		return i;
	}

	public static short bytesToSignInt16(byte lower, byte higher) {
		/*
		 * use the first bit to determinate the sign
		 */

		if ((higher) >> 7 == (byte) 0) {
			short abs = (short) ((((higher & 0x7F) << 8) | (lower)));
			return abs;
		}
		// else negitive
		else {
			// higher = (byte) ~((~higher) | 0x80);
			short abs = (short) ((((higher & 0x7F) << 8) | (lower)));
			return (short) -abs;
		}

	}

	public static int bytesToUnSignInt16(byte lower, byte higher) {

		// short i=bytesToSignInt16(lower,higher);
		// return i&0x0FFFF;

		int int16 = (int) ((((higher) << 8) | (lower)) & 0xFFFF);
		return int16;
	}

	public static short bytesToSignInt8(byte higher) {

		if ((higher) >> 7 == (byte) 0) {
			short abs = (short) (higher);
			return abs;
		}
		// else negitive
		else {
			// higher = (byte) ~((~higher) | 0x80);
			short abs = (short) ((higher & 0x7F));
			return (short) -abs;
		}
	}

	public static short bytesToUnSignInt8(byte lower) {

		short int8 = (short) (lower & 0xFF);
		return int8;
	}

	public static byte[] unSignInt16tobyte(int i, byte[] bytes,
			int start_position) {
		byte[] result = new byte[2];

		result[0] = (byte) ((i >> 8) & 0xFF);
		result[1] = (byte) (i & 0xFF);

		bytes[start_position] = result[1];
		bytes[(start_position + 1)] = result[0];
		return result;
	}

	public static byte[] SignInt16tobyte(int i, byte[] bytes, int start_position) {
		byte[] result = new byte[2];
		// ???????????????????????????????????????????
		result[0] = (byte) ((i >> 8) & 0xFF);
		result[1] = (byte) (i & 0xFF);

		bytes[start_position] = result[1];
		bytes[(start_position + 1)] = result[0];
		return result;
	}

	public static byte unSignInt8tobyte(int i, byte[] bytes, int start_position) {

		byte result = (byte) ((i) & 0xFF);
		bytes[start_position] = result;
		return result;
	}

	// 将指定byte数组以16进制的形式打印到控制台
	public static void printHexString(byte[] b) {
		for (int i = 0; i < 24; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			System.out.print("0x" + hex + " ");
		}
		System.out.println("\n");

	}

	public static boolean getBit(byte b, int position) {

		position = 7 - position;
		byte i = (byte) ((b >>> (7 - position)) & 0x1);
		if (i == 0x01) {
			return true;
		} else {
			return false;
		}

	}

	public static byte[] reverse_int2bytes(int i, int number_of_digits)
	/*
	 * @return the unsign one
	 */
	{
		return reverse_int2bytes(i, number_of_digits, false);
	}

	public static byte[] reverse_int2bytes(int i, int number_of_digits,
			boolean is_sign) {
		byte[] bytes = null;
		if (8 == number_of_digits) {
			if (is_sign)
				bytes = reverse_Sign8_bytes(i);
			else
				bytes = reverse_UnSign8_bytes(i);
		}

		else if (16 == number_of_digits) {
			if (is_sign)
				bytes = reverse_Sign16_bytes(i);
			else
				bytes = reverse_UnSign16_bytes(i);
		}

		return bytes;
	}

	public static byte[] reverse_UnSign16_bytes(int i) {

		byte[] abyte0 = new byte[4];

		abyte0[0] = (byte) (0xff & i);

		abyte0[1] = (byte) ((0xff00 & i) >> 8);

		abyte0[2] = (byte) ((0xff0000 & i) >> 16);

		abyte0[3] = (byte) ((0xff000000 & i) >> 24);
		return abyte0;
	}

	public static byte[] reverse_Sign16_bytes(int i) {
		byte[] abyte0 = new byte[4];
		if (i >= 0) {

			abyte0[0] = (byte) (0xff & i);

			abyte0[1] = (byte) ((0xff00 & i) >> 8);

			abyte0[2] = (byte) ((0xff0000 & i) >> 16);

			abyte0[3] = (byte) ((0xff000000 & i) >> 24);
		}

		else {
			i = -i;
			abyte0[0] = (byte) (0xff & i);

			abyte0[1] = (byte) ((0xff00 & i) >> 8);

			abyte0[2] = (byte) ((0xff0000 & i) >> 16);

			abyte0[3] = (byte) ((0xff000000 & i) >> 24);
			abyte0[1] = (byte) (abyte0[1] | 0x80);
		}
		return abyte0;
	}

	public static byte[] reverse_UnSign8_bytes(int i) {

		byte[] abyte0 = new byte[1];

		abyte0[0] = (byte) (0xff & i);

		return abyte0;
	}

	public static byte[] reverse_Sign8_bytes(int i) {

		byte[] abyte0 = new byte[1];
		if (i >= 0) {
			abyte0[0] = (byte) (0xff & i);

			return abyte0;
		} else {
			i = -i;
			abyte0[0] = (byte) (0xff & i);
			abyte0[0] = (byte) (abyte0[0] | 0x80);

			return abyte0;
		}
	}

	public static byte[] reverse_modify_bytes(byte[] inner_bytes,
			byte[] changed_bytes, int lower_position)
	/*
	 * will get a modify bytes , if succeed, remember to update the object !!!!!
	 * 
	 * @return the bytes
	 */
	{
		byte[] bytes = inner_bytes.clone();
		System.out.println("length is " + changed_bytes.length);
		// 8 digit
		if (1 == changed_bytes.length) {
			bytes[lower_position] = changed_bytes[0];
		}
		// if 16 digit
		else {
			bytes[lower_position] = changed_bytes[0];
			bytes[lower_position + 1] = changed_bytes[1];
		}
		return bytes;
	}

	public static int boolean2int(boolean i) {
		if (i == true) {
			return 1;

		} else
			return 0;
	}
}
