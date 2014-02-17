package com.avdpover.android.bean;

import com.avdpower.android.utilities.DESUtil;

public class Basic extends avd_message_base_bean {
	/*
	 * 0 帧头1 1 帧头2 2 过电压低字节 无符号16位数 单位：伏 3 过电压高字节 4 过电压恢复低字节 5 过电压恢复高字节 6 欠电压低字节
	 * 7 欠电压高字节 8 欠电压恢复低字节 9 欠电压恢复高字节 10 控制器正常运行相电流低字节 无符号16位数, 单位：安培 11
	 * 控制器正常运行相电流高字节 12 控制器直流电流设定 无符号8位数， 单位：安培 13 高速挡限速低字节 无符号16位数 单位：rpm 14
	 * 高速挡限速高字节 15 转把有效低阀值低字节 无符号16位数 单位：0.0001V 16 转把有效低阀值高字节 17 转把有效高阀值低字节 18
	 * 转把有效高阀值高字节 19 大扭矩启动转把电位低字节 20 大扭矩启动转把电位高字节 21 低速挡限速低字节 无符号16位数 单位：rpm 22
	 * 低速挡限速高字节 23 帧尾
	 */

	public int DC_current;
	public int Phase_current;
	public int High_voltage;
	public int High_voltage_revocer;
	public int Low_voltage;
	public int Low_voltage_recover;
	public int Throttle_low;
	public int Throttle_mid;
	public int Throttle_high;
	public int Max_speed;
	public int ECO_speed;

	// public byte [] bytes;

	public Basic(byte[] bytes) {

		initial(bytes);
	}

	public Basic() {

	}

	public void initial(byte[] bytes) {
		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];

		DC_current = DESUtil.bytesToUnSignInt8(bytes[12]);
		Phase_current = DESUtil.bytesToInt(bytes, 16, 10);
		High_voltage = DESUtil.bytesToUnSignInt16(bytes[2], bytes[3]);
		High_voltage_revocer = DESUtil.bytesToUnSignInt16(bytes[4], bytes[5]);
		Low_voltage = DESUtil.bytesToUnSignInt16(bytes[6], bytes[7]);
		Low_voltage_recover = DESUtil.bytesToUnSignInt16(bytes[8], bytes[9]);

		Throttle_low = DESUtil.bytesToUnSignInt16(bytes[13], bytes[14]);
		Throttle_mid = DESUtil.bytesToUnSignInt16(bytes[15], bytes[16]);
		Throttle_high = DESUtil.bytesToUnSignInt16(bytes[17], bytes[18]);

		Max_speed = DESUtil.bytesToUnSignInt16(bytes[19], bytes[20]);
		ECO_speed = DESUtil.bytesToUnSignInt16(bytes[21], bytes[22]);

		end = bytes[23];
	}

	public byte[] reverse2bytes()
	{
		byte [] bytes=new byte[24];
		bytes[0]=(byte)0xF0;
		
		bytes[1]=(byte)0xE1;
		
		DESUtil.create_bytes(bytes, DC_current, 8, 12);
		DESUtil.create_bytes(bytes, Phase_current, 16, 10);
		DESUtil.create_bytes(bytes, High_voltage, 16, 2);
		DESUtil.create_bytes(bytes, High_voltage_revocer, 16, 4);
		DESUtil.create_bytes(bytes, Low_voltage, 16, 6);
		DESUtil.create_bytes(bytes, Low_voltage_recover, 16, 8);
		DESUtil.create_bytes(bytes, Throttle_low, 16, 13);
		DESUtil.create_bytes(bytes, Throttle_mid, 16, 15);
		DESUtil.create_bytes(bytes, Throttle_high, 16, 17);
		DESUtil.create_bytes(bytes, Max_speed, 16, 19);
		DESUtil.create_bytes(bytes, ECO_speed, 16, 21);
		
		bytes[23]=end;
		return bytes;
	}
}
