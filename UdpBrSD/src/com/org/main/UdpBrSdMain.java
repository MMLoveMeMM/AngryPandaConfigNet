package com.org.main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UdpBrSdMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		byte[] msg = new String("connection successfully!!!").getBytes();
        /*
         * ��Java UDP�е�����㲥�Ĵ�������ͬ��,Ҫʵ�־��й㲥���ܵĳ���ֻ��Ҫʹ�ù㲥��ַ����, ���磺����ʹ���˱��صĹ㲥��ַ
         */
        InetAddress inetAddr = InetAddress.getByName("255.255.255.255");
        DatagramSocket client = new DatagramSocket();
 
        DatagramPacket sendPack = new DatagramPacket(msg, msg.length, inetAddr,
                8888);
 
        client.send(sendPack);
        System.out.println("Client send msg complete");
        client.close();
	}

}