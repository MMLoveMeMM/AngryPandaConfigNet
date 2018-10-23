package com.org.main;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Logger;

public class MultiMainGt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "224.116.8.0";
		int port = 2011;
		try (MulticastSocket socket = new MulticastSocket(port);) {
			InetAddress mcastaddr = InetAddress.getByName(host);
			socket.joinGroup(mcastaddr);
			byte b[] = new byte[512];
			DatagramPacket pack = new DatagramPacket(b, b.length, mcastaddr, port);
			while (true) {
				socket.receive(pack);
				String msg = new String(pack.getData(), 0, b.length);
				Logger.getGlobal().info(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}