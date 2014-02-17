package com.avdpover.android.bean;

public class avd_message_base_bean {
	public byte start1;
	public byte start2;
	public byte end;
	public byte[] inner_bytes;

	public void store_inner_bytes(byte[] bytes) {
		inner_bytes = bytes;
		start1 = bytes[0];
		start2 = bytes[1];
		end = bytes[23];
	}
	public byte[] reverse2bytes()
	{
		return null;
	}
	

}
