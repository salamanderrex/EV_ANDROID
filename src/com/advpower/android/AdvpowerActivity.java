package com.advpower.android;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.advpower.android.bean.SYS_RealTimeInfo;
import com.advpower.android.utilities.CONSTANT;
import com.advpower.android.utilities.DESUtil;
import com.advpower.android.utilities.PrintUtility;
import com.advpower.android.utilities.CONSTANT.EVENT;
import com.advpower.android.utilities.bluetooth.ClsUtils;
import com.advpower.android.utilities.bluetooth.MyBlueTooth;
import com.advpower.android.utilities.messagefactory.messageFactory_maker;
import com.krislq.sliding.R;
//update from eclipse 
//20122_13

public class AdvpowerActivity extends Activity {
	/** Called when the activity is first created. */

	public Handler blue_tooth_handler;
	private Button button = null;
	private BluetoothReceiver bluetoothReceiver = null;
	private BluetoothAdapter mbluetoothAdapter = null;
	private Button scanButton = null;
	private Button discoverButton = null;
	private Button stopscanButton = null;
	private Button clientButton = null;
	private Button bondstatusButton = null;
	// private BluetoothDevice device = null;
	private Button writeButton = null;
	private Button initialButton = null;
	private Button getBeanButton = null;
	private Button closeConnction = null;
	private TextView showBox_TextView = null;
	private Button connect_socket = null;
	// ConnectedThread connectedThread;
	MyBlueTooth myblueTooth;
	Set<BluetoothDevice> bluetoothdevices = null;
	private Button readBasic = null;
	private Button readReference = null;

	// Handler blueToothHandler;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		button = (Button) findViewById(R.id.BTlistButtonId);
		button.setOnClickListener(new ButtonListener());
		stopscanButton = (Button) findViewById(R.id.stopscanButtonId);
		discoverButton = (Button) findViewById(R.id.discoverButtonId);
		discoverButton.setOnClickListener(new DiscoverButtonListener());
		scanButton = (Button) findViewById(R.id.scanButtonId);
		initialButton = (Button) findViewById(R.id.initialID);
		clientButton = (Button) findViewById(R.id.clinetID);
		writeButton = (Button) findViewById(R.id.writeID);
		getBeanButton = (Button) findViewById(R.id.getbeanID);
		closeConnction = (Button) findViewById(R.id.closeconnectID);
		showBox_TextView = (TextView) findViewById(R.id.show);
		bondstatusButton = (Button) findViewById(R.id.bondstatusid);
		connect_socket = (Button) findViewById(R.id.connectsocketid);

		readBasic = (Button) findViewById(R.id.read_basic);
		readReference = (Button) findViewById(R.id.read_reference);
		// ����һ��IntentFilter���󣬽���actionָ��ΪBluetoothDevice.ACTION_FOUND
		IntentFilter intentFilter = new IntentFilter(
				BluetoothDevice.ACTION_FOUND);
		IntentFilter filter1 = new IntentFilter(
				BluetoothDevice.ACTION_ACL_CONNECTED);
		IntentFilter filter2 = new IntentFilter(
				BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED);
		IntentFilter filter3 = new IntentFilter(
				BluetoothDevice.ACTION_ACL_DISCONNECTED);

		bluetoothReceiver = new BluetoothReceiver();
		// ע��㲥������
		registerReceiver(bluetoothReceiver, intentFilter);
		// registerReceiver(bluetoothReceiver, filter1);
		// registerReceiver(bluetoothReceiver, filter2);
		// registerReceiver(bluetoothReceiver, filter3);

		/*
		 * blueToothHandler = new Handler() {
		 * 
		 * Override public void handleMessage(Message msg) { if (msg.what ==
		 * 0x123) { SimpleDateFormat df = new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		 * System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		 * showBox_TextView.setText("recvive at time: "+df.format(new
		 * Date())+" \n"+"content is \n" +msg.obj.toString());
		 * 
		 * } } };
		 */
		blue_tooth_handler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub

				// System.out.println("flag3");
				try {
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					PrintUtility.printFields(msg.obj);
					if (msg.what == CONSTANT.SYS_REALTIMEINFO) {
						/*
						byte[] bytes = ((SYS_RealTimeInfo) msg.obj).inner_bytes;
						byte[] to_change = { (byte) 0x99 };
						byte[] changed_bytes = DESUtil.reverse_modify_bytes(
								bytes, to_change, 0);
						DESUtil.printHexString(changed_bytes);*/
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		};

		// mbluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		scanButton.setOnClickListener(new ScanButtonListener());
		stopscanButton.setOnClickListener(new StopScanButtonListener());

		initialButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					myblueTooth = new MyBlueTooth(blue_tooth_handler);
					// checkto open open
					if (!myblueTooth.getMbluetoothAdapter().isEnabled()) {
						// ����һ��intent���󣬸ö�����������һ��Activity����ʾ�û����������豸
						Intent intent = new Intent(
								BluetoothAdapter.ACTION_REQUEST_ENABLE);
						startActivity(intent);
					}
					//��������������
					bluetoothdevices = myblueTooth.getBondedtBluetoothDevice();
					myblueTooth.Setpaireddevice(CONSTANT.BT_SERVER_NAME);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		getBeanButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
				System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
				try {
					System.out.println("is connected:"
							+ myblueTooth.isconnected());
					PrintUtility.printFields(myblueTooth.getSys_RealTimeInfo());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("print error");
					e.printStackTrace();
				}

			}
		});
		clientButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// System.out.println("starting connnect");
				try {

					myblueTooth.bond();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		bondstatusButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// System.out.println("starting connnect");
				// connectedThread.write("heihei\n".getBytes());
				System.out.println("going to get the status");
				try {

					System.out.println("status is "
							+ myblueTooth.getRemoteDevice().getBondState());
					showBox_TextView.setText(""
							+ myblueTooth.getRemoteDevice().getBondState());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		writeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// System.out.println("starting connnect");
				// connectedThread.write("heihei\n".getBytes());

				try {
					myblueTooth.write(messageFactory_maker.TIME_ROBORT_op());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		readBasic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// System.out.println("starting connnect");
				// connectedThread.write("heihei\n".getBytes());

				try {
					myblueTooth.write(messageFactory_maker
							.EVENT_TRIGGER_op(EVENT.MOTOR_READ));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		closeConnction.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// System.out.println("starting connnect");
				// connectedThread.write("heihei\n".getBytes());

				try {
					System.out.println("closing the connection");
					myblueTooth.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		connect_socket.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// System.out.println("starting connnect");
				// connectedThread.write("heihei\n".getBytes());

				try {
					// System.out.println("closing the connection");
					myblueTooth.connect();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	private class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// �õ�BluetoothAdapter����
			BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
			// �ж�BluetoothAdapter�����Ƿ�Ϊ�գ����Ϊ�գ����������û�������豸
			if (adapter != null) {
				System.out.println("����ӵ�������豸");
				// ����isEnabled()�������жϵ�ǰ�����豸�Ƿ����
				if (!adapter.isEnabled()) {
					// ����һ��intent���󣬸ö�����������һ��Activity����ʾ�û����������豸
					Intent intent = new Intent(
							BluetoothAdapter.ACTION_REQUEST_ENABLE);
					startActivity(intent);
				}
				// �õ������Ѿ���Ե���������������
				Set<BluetoothDevice> devices = adapter.getBondedDevices();
				if (devices.size() > 0) {
					for (Iterator iterator = devices.iterator(); iterator
							.hasNext();) {
						BluetoothDevice bluetoothDevice = (BluetoothDevice) iterator
								.next();
						// �õ�Զ�������豸�ĵ�ַ
						System.out.println(bluetoothDevice.getAddress());
					}
				}
			} else {
				System.out.println("û�������豸");
			}
		}
	}

	// �ü����������޸������豸�ɼ���
	private class DiscoverButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// ����һ��Intent���󣬲�����action��ֵ����ΪBluetoothAdapter.ACTION_REQUEST_DISCOVERABLE
			Intent discoverableIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
			// ��һ����ֵ�Դ�ŵ�Intent�����У���Ҫ����ָ���ɼ�״̬�ĳ���ʱ��
			discoverableIntent.putExtra(
					BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 500);
			startActivity(discoverableIntent);
		}

	}

	private class ScanButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {

			System.out.println("start scanning");
			myblueTooth.getMbluetoothAdapter().startDiscovery();
		}

	}

	private class StopScanButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			myblueTooth.getMbluetoothAdapter().cancelDiscovery();
		}

	}

	private class BluetoothReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			// When discovery finds a device
			if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				// Get the BluetoothDevice object from the Intent
				BluetoothDevice btDevice = intent
						.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				System.out.println(btDevice.getName() + "n"
						+ btDevice.getAddress());
				// Add the name and address to an array adapter to show in a
				try {
					// myblueTooth.addNewFoundedBluetoothDevice(device);
				} catch (Exception e) {
					System.out.println("adding device error");
					e.printStackTrace();
				}

				if (btDevice.getName()
						.equalsIgnoreCase(CONSTANT.BT_SERVER_NAME)) {
					try {
						ClsUtils.setPin(btDevice.getClass(), btDevice,
								CONSTANT.BT_password);
						ClsUtils.createBond(btDevice.getClass(), btDevice);
						ClsUtils.cancelPairingUserInput(btDevice.getClass(),
								btDevice);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // �ֻ�������ɼ������

					System.out.println("adding new  device ");
					myblueTooth.setBt_mac(btDevice.getAddress());
					myblueTooth.getMbluetoothAdapter().cancelDiscovery();
				}
			}
		}
	}
}
