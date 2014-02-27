package com.advpower.android.utilities;

import java.util.UUID;

public class CONSTANT {
	public static final UUID MY_UUID = UUID
			.fromString("00001101-0000-1000-8000-00805F9B34FB");

	// send
	public static final int TIME_ROBOT = 0x00;
	public static final int EVENT_TRIGGER = 0x01;
	public static final int EVENT_MODIFY = 0x10;
	public static final int EVENT_READ = 0X11;

	// receive

	public static final int SYS_REALTIMEINFO = 0X99;
	public static  class  EVENT {
		public static  final int BASIC_MODIFY = 0x1;
		public static  final int REFERENCE_MODIFY = 0x2;
		public static  final int MOTOR_MODIFY = 0x3;
		public static  final int CONTROL_MODIFY = 0x4;
		public static final  int TORQUE_MODIFY = 0x5;
		public static  final int PROTECTION_MODIFY = 0x6;
		public static  final int OTHER_MODIFY = 0x7;
		public static  final int FLUX_WEAKEN_MODIFY=0x8;
		public static  final int DC_CURRENT_CALIBRATION_MODIFY=0x9;
		
		public static  final int BASIC_READ = 0x11;
		public static  final int REFERENCE_READ = 0x21;
		public static  final int MOTOR_READ = 0x31;
		public static  final int CONTROL_READ = 0x41;
		public static final  int TORQUE_READ = 0x51;
		public static  final int PROTECTION_READ = 0x61;
		public static  final int OTHER_READ = 0x71;
		public static  final int FLUX_WEAKEN_READ=0x81;
		public static  final int DC_CURRENT_CALIBRATION_READ=0x91;
		

	}

	public static final String BT_password = "1234";
	public static final String BT_SERVER_NAME = "11";
}
