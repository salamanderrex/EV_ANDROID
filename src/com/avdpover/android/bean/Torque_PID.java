package com.avdpover.android.bean;

import com.avdpower.android.utilities.DESUtil;

public class Torque_PID extends avd_message_base_bean {
	public int Iq_Kp_Gain_0_Pre;
	public int Iq_Ki_Gain_0_Pre;
	public int Iq_Kp_Gain_0;
	public int Iq_Ki_Gain_0;
	public int Iq_Kp_Gain_2;
	public int Iq_Ki_Gain_2;
	public int Iq_Kp_Gain_3;
	public int Iq_Ki_Gain_3;
	public int Id_Kp_Gain_0_Pre;
	public int Id_Ki_Gain_0_Pre;
	public int Id_Kp_Gain_0;
	public int Id_Ki_Gain_0;
	public int Id_Kp_Gain_2;
	public int Id_Ki_Gain_2;
	public int Id_Kp_Gain_3;
	public int Id_Ki_Gain_3;

	public Torque_PID(byte[] bytes) {

		initial(bytes);
	}

	public void initial(byte[] bytes) {
		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];

		Iq_Kp_Gain_0_Pre = DESUtil.bytesToInt(bytes, 8, 2);
		Iq_Ki_Gain_0_Pre = DESUtil.bytesToInt(bytes, 8, 3);
		Iq_Kp_Gain_0 = DESUtil.bytesToInt(bytes, 8, 6);
		Iq_Ki_Gain_0 = DESUtil.bytesToInt(bytes, 8, 7);
		Iq_Kp_Gain_2 = DESUtil.bytesToInt(bytes, 8, 10);
		Iq_Ki_Gain_2 = DESUtil.bytesToInt(bytes, 16, 11);

		Iq_Kp_Gain_3 = DESUtil.bytesToInt(bytes, 8, 16);
		Iq_Ki_Gain_3 = DESUtil.bytesToInt(bytes, 16, 17);
		Id_Kp_Gain_0_Pre = DESUtil.bytesToInt(bytes, 8, 4);
		Id_Ki_Gain_0_Pre = DESUtil.bytesToInt(bytes, 8, 5);
		Id_Kp_Gain_0 = DESUtil.bytesToInt(bytes, 8, 8);
		Id_Ki_Gain_0 = DESUtil.bytesToInt(bytes, 8, 9);
		Id_Kp_Gain_2 = DESUtil.bytesToInt(bytes, 8, 13);
		Id_Ki_Gain_2 = DESUtil.bytesToInt(bytes, 16, 14);

		Id_Kp_Gain_3 = DESUtil.bytesToInt(bytes, 8, 19);
		Id_Ki_Gain_3 = DESUtil.bytesToInt(bytes, 16, 20);

		end = bytes[23];
	}
}
