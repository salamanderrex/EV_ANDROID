package com.advpower.android;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.advpower.android.utilities.CONSTANT;
import com.advpower.android.utilities.bluetooth.ClsUtils;

public class BluetoothConnectActivityReceiver extends BroadcastReceiver {

	final String ACTION_PAIRING_REQUEST = "android.bluetooth.device.action.PAIRING_REQUEST";
	final String ACTION_ACL_CONNECTED = "android.bluetooth.device.action.ACTION_ACL_CONNECTED";
	final String ACTION_ACL_DISCONNECT_REQUESTED = "android.bluetooth.device.action.ACTION_ACL_DISCONNECT_REQUESTED";
	final String ACTION_ACL_DISCONNECTED = "android.bluetooth.device.action.ACTION_ACL_DISCONNECTED";
	final String ACTION_BOND_STATE_CHANGED = "android.bluetooth.device.action.ACTION_BOND_STATE_CHANGED";
	static BluetoothDevice remoteDevice = null;

	@Override
	public void onReceive(Context context, Intent intent) {

		String action = intent.getAction();
		System.out.println(action);
		if (intent.getAction().equals(ACTION_PAIRING_REQUEST)) {

			BluetoothDevice device = intent
					.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
			if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
				System.out.println("I am in broadcast ,BluetoothConnectActivityReceiver ");
				try {
				ClsUtils.setPin(device.getClass(), device, CONSTANT.BT_password); // �ֻ�������ɼ������
					// ClsUtils.createBond(device.getClass(), device);
					// ClsUtils.cancelPairingUserInput(device.getClass(),
					//device); //һ����ò��ɹ���ǰ�����潲�����
					System.out
							.println("bond status is" + device.getBondState());
					Toast.makeText(context, "�����Ϣ" + device.getName(), 5000)
							.show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(context, "�������Ӵ���...", 1000).show();
				}
			}

			// */
			// pair(device.getAddress(),strPsw);
		}

		else if (ACTION_ACL_CONNECTED.equals(action)) {
			// Device is now connected
			System.out.println("connected");
		}

		else if (ACTION_ACL_DISCONNECT_REQUESTED.equals(action)) {
			// Device is about to disconnect
		} else if (ACTION_ACL_DISCONNECTED.equals(action)) {
			// Device has disconnected
		}

		else if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)) {
			System.out.println("bonded");
			Toast.makeText(context, "bonded" , 5000)
			.show();
		}
	}
}