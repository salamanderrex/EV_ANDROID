package com.avdpower.android.utilities.bluetooth;

import java.io.IOException;
import java.lang.reflect.Method;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;

import com.avdpover.android.bean.SYS_RealTimeInfo;
import com.avdpower.android.utilities.CONSTANT;


public class ConnectThread extends Thread {
	private final BluetoothSocket mmSocket;
	//private Handler blueToothHandler;
	private final BluetoothDevice mmDevice;
	private ConnectedThread connectedThread=null;
	private BluetoothAdapter mbluetoothAdapter = null;
	SYS_RealTimeInfo sys_RealTimeInfo;
	private Handler blue_tooth_handler;
	
	// UUID可以看做一个端口号

	public boolean isConnected() throws Exception {
		return connectedThread.isConnected();
	}

	public ConnectedThread getConnectedThread() {
		return connectedThread;
	}

	public void setConnectedThread(ConnectedThread connectedThread) {
		this.connectedThread = connectedThread;
	}

	public ConnectThread(BluetoothDevice device, BluetoothAdapter bluetoothAdapter,SYS_RealTimeInfo RealTimeInfo,Handler handler) {
		// Use a temporary object that is later assigned to mmSocket,
		// because mmSocket is final
		sys_RealTimeInfo=RealTimeInfo;
		//blueToothHandler=gblueToothHandler;
		BluetoothSocket tmp = null;
		mmDevice = device;
		mbluetoothAdapter=bluetoothAdapter;
		  blue_tooth_handler=handler;
		// Get a BluetoothSocket to connect with the given BluetoothDevice
		try {
			// MY_UUID is the app's UUID string, also used by the server
			// code
			//Method createsocket=device.getClass().getMethod("createRfcommSocket");
			//tmp=(BluetoothSocket) createsocket.invoke(device);
			
			tmp = device.createRfcommSocketToServiceRecord(CONSTANT.MY_UUID);
			
		} catch (Exception e) {
			System.out.println("createRfcommSocketToServiceRecord error");
		}
		mmSocket = tmp;
		
		System.out.println("get createRfcommSocketToServiceRecord @"+ mmSocket.getRemoteDevice().getName());

	}

	public void run() {
		// Cancel discovery because it will slow down the connection
		mbluetoothAdapter.cancelDiscovery();

		try {
			// Connect the device through the socket. This will block
			// until it succeeds or throws an exception
			mmSocket.connect();
		} catch (IOException connectException) {
			// Unable to connect; close the socket and get out
			connectException.printStackTrace();
			System.out.println("Unable to connect; close the socket and get out");
			try {
				mmSocket.close();
				System.out.println("cloing tht socket");
			} catch (IOException closeException) {
				System.out.println("cloing rht socket error");
			}
		
			return;
		}

		// Do work to manage the connection (in a separate thread)
		// manageConnectedSocket(mmSocket);

		connectedThread = new ConnectedThread(mmSocket,sys_RealTimeInfo,blue_tooth_handler);
		connectedThread.start();
		try {
			//connectedThread.write("fsdfsdf".getBytes("utf-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ok , i go to write");
	}

	// Will cancel an in-progress connection, and close the socket
	public void cancel() {
		try {
			mmSocket.close();
			
		} catch (IOException e) {
			System.out.println("cancel in connectthread err");
		}

	}
	
	public void write(byte[] bytes) throws Exception {
		connectedThread.write(bytes);
	}
	
	
}