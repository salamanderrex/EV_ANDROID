package com.avdpower.android.utilities.bluetooth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.avdpover.android.bean.SYS_RealTimeInfo;
import com.avdpower.android.utilities.CONSTANT;
import com.avdpower.android.utilities.DESUtil;
import com.avdpower.android.utilities.messagefactory.messageFactory_receiver;

import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Message;

public class ConnectedThread extends Thread {
	private final BluetoothSocket mmSocket;
	private final InputStream mmInStream;
	private final OutputStream mmOutStream;
	private final BufferedReader mmBufferedReader;
	private Handler blue_tooth_handler;
	private boolean connected = false;// only one device will connect at one
										// time
	private SYS_RealTimeInfo sys_RealTimeInfo;

	public boolean isConnected() {
		return connected;
	}

	public ConnectedThread(BluetoothSocket socket, SYS_RealTimeInfo RealTimeInfo,Handler handler) {
		 blue_tooth_handler=handler;
		sys_RealTimeInfo = RealTimeInfo;
		mmSocket = socket;
		InputStream tmpIn = null;
		OutputStream tmpOut = null;
		BufferedReader tmpBufferedReader = null;

		// Get the input and output streams, using temp objects because
		// member streams are final
		try {
			tmpIn = socket.getInputStream();
			tmpOut = socket.getOutputStream();
			tmpBufferedReader = new BufferedReader(new InputStreamReader(tmpIn));
		} catch (IOException e) {
		}

		mmInStream = tmpIn;
		mmOutStream = tmpOut;
		mmBufferedReader = tmpBufferedReader;
	}

	public void run() {
		byte[] buffer = new byte[24]; // buffer store for the stream
		int index = 0;
		int bytes = 0; // bytes returned from read()
		connected = true;
		// Keep listening to the InputStream until an exception occurs
		while (true) {
			try {

				// Read from the InputStream
				byte[] temp_buffer = new byte[24];
				bytes = mmInStream.read(temp_buffer);
				System.out.println("received " + bytes + "bytes\n");
				if (bytes != 24) {

					for (int i = 0; i < bytes; i++) {
						buffer[index] = temp_buffer[i];
						index++;
					}
				}
				if (index == 24) {
					System.out.println("Finally, received " + 24 + "bytes\n");
					int type=messageFactory_receiver.get_respose_type(buffer);
					if(type==CONSTANT.SYS_REALTIMEINFO)
					{
					
					sys_RealTimeInfo.initial(buffer);
					}
					DESUtil.printHexString(buffer);
					index = 0;
				}
				// Send the obtained bytes to the UI Activity
				// mHandler.obtainMessage(MESSAGE_READ, bytes, -1, buffer)
				// .sendToTarget();
				Message msg=new Message();
			//	msg.what=0x123;
				//msg.obj=sys_RealTimeInfo;
				//blue_tooth_handler.sendMessage(msg);
				
				try {
					int type=messageFactory_receiver.get_respose_type(buffer);
					System.out.println("receive type is "+type);
					if(type!=0)
					{
					msg.what=type;
					msg.obj=messageFactory_receiver.get_bean(buffer,type);
					blue_tooth_handler.sendMessage(msg);
					}
					//System.out.println("flag2"+type);
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*
				 * String content = null; while ((content =
				 * mmBufferedReader.readLine()) != null) { Message msg = new
				 * Message(); msg.what = 0x123; msg.obj = content;
				 * handler.sendMessage(msg);
				 * 
				 * }
				 */
			} catch (IOException e) {
				connected = false;
				System.out.print("lost connection!!");
				break;
			}
		}
	}

	/* Call this from the main Activity to send data to the remote device */
	public void write(byte[] bytes) throws Exception {

		try {
			mmOutStream.write(bytes);
		} catch (Exception e) {
			connected=false;
			cancel();
			throw e;
		}

	}

	/* Call this from the main Activity to shutdown the connection */
	public void cancel() {
		try {
			mmSocket.close();
		} catch (IOException e) {
			System.out.println("cancel in connectedthread err");
		} finally {
			connected = false;
		}
	}
}