package com.avdpower.android.utilities.bluetooth;

import java.util.Iterator;
import java.util.Set;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.util.Log;

import com.avdpover.android.bean.SYS_RealTimeInfo;
import com.avdpower.android.utilities.CONSTANT;
import com.avdpower.android.utilities.DESUtil;


/**
 * blue tooth
 * first initial->
 * then bond->
 * if bondstatus=BONDED ie =12->
 * then connect, it will create a connect thread->
 * if connect succeed, it will create a connected thread to manage the wirte and recive->
 * you can use wirte to write, use the bean to recive the info
 * 
 * 
 * 
 * @author Rex
 *
 */
public class MyBlueTooth {

	// private BluetoothReceiver bluetoothReceiver = null;
	//private Handler blueToothHandler=null;
	private SYS_RealTimeInfo sys_RealTimeInfo;
	private BluetoothAdapter mbluetoothAdapter = null;
	private Set<BluetoothDevice> devices = null;
	private BluetoothDevice device = null;
	private Handler blue_tooth_handler;
	// private ConnectedThread connectedThread;
	private ConnectThread connectThread;
	//private String bt_mac = "08:FC:88:F4:19:D8";
	private String bt_mac =null;
	
	public  BluetoothDevice remoteDevice=null;
	public BluetoothDevice getRemoteDevice() {
		return remoteDevice;
	}

	public void setRemoteDevice(BluetoothDevice remoteDevice) {
		this.remoteDevice = remoteDevice;
	}

	public boolean pair(String strAddr, String strPsw)
	{
		boolean result = false;
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter
				.getDefaultAdapter();

		bluetoothAdapter.cancelDiscovery();

		if (!bluetoothAdapter.isEnabled())
		{
			bluetoothAdapter.enable();
		}

		if (!BluetoothAdapter.checkBluetoothAddress(strAddr))
		{ // 检查蓝牙地址是否有效

			Log.d("mylog", "devAdd un effient!");
		}

		BluetoothDevice device = bluetoothAdapter.getRemoteDevice(strAddr);

		if (device.getBondState() != BluetoothDevice.BOND_BONDED)
		{
			try
			{
				Log.d("mylog", "NOT BOND_BONDED");
				System.out.println( "NOT BOND_BONDED");
				ClsUtils.setPin(device.getClass(), device, strPsw); // 手机和蓝牙采集器配对
				ClsUtils.createBond(device.getClass(), device);
			//	ClsUtils.cancelPairingUserInput(device.getClass(), device);
				remoteDevice = device; // 配对完毕就把这个设备对象传给全局的remoteDevice
				result = true;
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block

				Log.d("mylog", "setPiN failed!");
				e.printStackTrace();
			} //

		}
		else
		{
			Log.d("mylog", "HAS BOND_BONDED");
			try
			{
				ClsUtils.createBond(device.getClass(), device);
				ClsUtils.setPin(device.getClass(), device, strPsw); // 手机和蓝牙采集器配对
				ClsUtils.createBond(device.getClass(), device);
				remoteDevice = device; // 如果绑定成功，就直接把这个设备对象传给全局的remoteDevice
				result = true;
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				Log.d("mylog", "setPiN failed!");
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public MyBlueTooth(Handler handler) throws Exception {
		blue_tooth_handler=handler;
		sys_RealTimeInfo=new SYS_RealTimeInfo();
		mbluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		
		if (mbluetoothAdapter == null) {
			throw new Exception();
		}

		devices = initialBondedtBluetoothDevice();
	}

	public void bond() {
		System.out.println("starting bonding^^^^^^^^^^^");
		//device = mbluetoothAdapter.getRemoteDevice(bt_mac);
		mbluetoothAdapter.cancelDiscovery();
		//pair("7F:69:96:78:E0:37", "1234");
		pair(bt_mac,CONSTANT.BT_password);
		try {
			//ClsUtils.createBond(device.getClass(), device);
			//ClsUtils.setPin(device.getClass(), device, "124");
			//boolean bond_success=ClsUtils.createBond(device.getClass(), device);
			//System.out.println("bond "+bond_success);
			//System.out.println(device.getBondState());
		//	System.out.println(device.get);
			//ClsUtils.printAllInform(device.getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("create bond fail");
			
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//device = mbluetoothAdapter.getRemoteDevice("08:dFC:88:F4:19:D8");

		///if(device.getBondState() == BluetoothDevice.BOND_BONDED){ 
		System.out.println("bond status "+remoteDevice.getBondState() +" "+ BluetoothDevice.BOND_BONDED);
		//}
		//connectThread = new ConnectThread(device, mbluetoothAdapter,sys_RealTimeInfo);
		//connectThread.start();
	}
	
	public void connect() throws Exception
	{
		System.out.println("start conncecting^^^^^^");
		if(remoteDevice.getBondState()==BluetoothDevice.BOND_BONDED){
			connectThread = new ConnectThread(remoteDevice, mbluetoothAdapter,sys_RealTimeInfo,blue_tooth_handler);
			connectThread.start();
			System.out.println("connectThread start");
		}
		else
		{
			Exception e=new Exception();
			throw e;
		}
	}


	public SYS_RealTimeInfo getSys_RealTimeInfo() {
		return sys_RealTimeInfo;
	}

	public void write(byte[] bytes) throws Exception {

		
			connectThread.write(bytes);
			System.out.println("writing ");
			DESUtil.printHexString(bytes);
		
		
	}

	public BluetoothAdapter getMbluetoothAdapter() {
		return mbluetoothAdapter;
	}

	public void setMbluetoothAdapter(BluetoothAdapter mbluetoothAdapter) {
		this.mbluetoothAdapter = mbluetoothAdapter;
	}

	public BluetoothDevice getDevice() {
		return device;
	}

	public void setDevice(BluetoothDevice device) {
		this.device = device;
	}

	public ConnectThread getConnectThread() {
		return connectThread;
	}

	public void setConnectThread(ConnectThread connectThread) {
		this.connectThread = connectThread;
	}

	public String getBt_mac() {
		return bt_mac;
	}

	public void setBt_mac(String bt_mac) {
		this.bt_mac = bt_mac;
	}

	public Set<BluetoothDevice> initialBondedtBluetoothDevice() {

		devices = mbluetoothAdapter.getBondedDevices();
		if (devices.size() > 0) {
			for (Iterator iterator = devices.iterator(); iterator.hasNext();) {
				BluetoothDevice bluetoothDevice = (BluetoothDevice) iterator
						.next();
				// 得到远程蓝牙设备的地址
				System.out.println(bluetoothDevice.getName()
						+ bluetoothDevice.getAddress());

			}
		}
		return devices;
	}
	
	
	public Set<BluetoothDevice> getBondedtBluetoothDevice() {

	
		if (devices.size() > 0) {
			for (Iterator iterator = devices.iterator(); iterator.hasNext();) {
				BluetoothDevice bluetoothDevice = (BluetoothDevice) iterator
						.next();
				// 得到远程蓝牙设备的地址
				System.out.println(bluetoothDevice.getName()
						+ bluetoothDevice.getAddress());

			}
		}
		return devices;
	}
	//the bluetooth  set can not add
	/*
	public void addNewFoundedBluetoothDevice(BluetoothDevice device) {

		System.out.println("there are "+devices.size()+"devices");
		devices.add(device);
	}*/
	public void close() {
		try {
			connectThread.getConnectedThread().cancel();
			
		} catch (Exception e) {

		}
		try {
			connectThread.cancel();
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean isconnected()
	{
		try
		{
		return connectThread.isConnected();
		}
		catch (Exception e )
		{
			return false;
		}
	}
	
	public void Setpaireddevice(String devicename)	
	{
		if (devices.size() > 0) {
			for (Iterator iterator = devices.iterator(); iterator.hasNext();) {
				BluetoothDevice bluetoothDevice = (BluetoothDevice) iterator
						.next();
				// 得到远程蓝牙设备的地址
				//System.out.println(bluetoothDevice.getName()
					//	+ bluetoothDevice.getAddress());
				
				if(bluetoothDevice.getName().equalsIgnoreCase(devicename))
				{
					bt_mac=bluetoothDevice.getAddress();
					//bluetoothDevice
				}

			}
		}
		
		
		
		// if can not find,i.e
		if (this.getBt_mac() == null) {
			// start scanning
			System.out.println("not in bond , start scaning");
			getMbluetoothAdapter().startDiscovery();
		}
	}
}
