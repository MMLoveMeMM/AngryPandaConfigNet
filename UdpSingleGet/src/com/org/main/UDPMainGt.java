package com.org.main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Logger;

public class UDPMainGt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 3001;//�������ݰ���IP�˿�
		try(
			DatagramSocket socket = new DatagramSocket(port);) {
			byte b[] = new byte[512];
			DatagramPacket pack = new DatagramPacket(b, b.length);
			while(socket!=null)
			{
				socket.receive(pack);//������Ϣ
				int length = pack.getLength();
				String msg = new String(pack.getData(),0,length);
				Logger.getGlobal().info(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}