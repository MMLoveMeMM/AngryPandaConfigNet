package com.org.main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPMainSd {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InetAddress destAddr = InetAddress.getByName("127.0.0.1"/*"192.168.4.199"*/);// ���͵�Ŀ�ĵ�ַ
		int targetPort = 3001; // ���͵�Ŀ�Ķ˿�
		try (DatagramSocket socket = new DatagramSocket(); Scanner r = new Scanner(System.in);) {
			while (true) {
				String s = r.nextLine();
				byte[] b = s.getBytes();
				DatagramPacket pk = new DatagramPacket(b, b.length, destAddr, targetPort);
				socket.send(pk);//����
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}