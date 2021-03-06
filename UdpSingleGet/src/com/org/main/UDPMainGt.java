package com.org.main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Logger;

public class UDPMainGt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 3001;//接收数据包的IP端口
		try(
			DatagramSocket socket = new DatagramSocket(port);) {
			byte b[] = new byte[512];
			DatagramPacket pack = new DatagramPacket(b, b.length);
			while(socket!=null)
			{
				socket.receive(pack);//接收信息
				int length = pack.getLength();
				String msg = new String(pack.getData(),0,length);
				Logger.getGlobal().info(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
