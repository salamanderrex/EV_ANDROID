package com.test;

import org.junit.Test;

import com.advpower.android.utilities.DESUtil;

public class test {
	@Test
	public void change() {
		byte bytes[] = new byte[2];
		bytes[0] = (byte) 0x00;
		bytes[1] = (byte) 0x0A;
		short i=DESUtil.bytesToSignInt16(bytes[0], bytes[1]);
		System.out.println(i);
	}
	
}
