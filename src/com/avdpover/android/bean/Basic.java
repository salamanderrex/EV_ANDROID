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
	public float High_voltage;
	public float High_voltage_revocer;
	public float Low_voltage;
	public float Low_voltage_recover;
	public float Throttle_low;
	public float Throttle_mid;
	public float Throttle_high;
	public int Max_speed;
	public int ECO_speed;

	// public byte [] bytes;

	public Basic(byte[] bytes) {
	
		initial(bytes);
	}
	public Basic()
	{
		
	}
	
	public void initial(byte[] bytes)
	{
		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];

		DC_current = DESUtil.bytesToUnSignInt8(bytes[12]);
		Phase_current = DESUtil.bytesToUnSignInt16(bytes[10], bytes[11]);
		High_voltage = ((float)DESUtil.bytesToUnSignInt16(bytes[2], bytes[3]))/100;
		High_voltage_revocer = ((float)DESUtil.bytesToUnSignInt16(bytes[4], bytes[5]))/100;
		Low_voltage=((float)DESUtil.bytesToUnSignInt16(bytes[6], bytes[7]))/100;
		Low_voltage_recover=((float)DESUtil.bytesToUnSignInt16(bytes[8], bytes[9]))/100;
		
		Throttle_low=((float)DESUtil.bytesToUnSignInt16(bytes[13], bytes[14]))/1000;
		Throttle_mid=((float)DESUtil.bytesToUnSignInt16(bytes[15], bytes[16]))/1000;
		Throttle_high=((float)DESUtil.bytesToUnSignInt16(bytes[17], bytes[18]))/1000;
		
		Max_speed= DESUtil.bytesToUnSignInt16(bytes[19], bytes[20]);
		ECO_speed= DESUtil.bytesToUnSignInt16(bytes[21], bytes[22]);
		
		end=bytes[23];
	}

}
