package com.org.main;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MultiMainSd {
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss:SSS");// ��ʾ���ڸ�ʽ
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ͨ�������޸�host�����116.8.0�������ֽ�
		 * ����ipЭ��,�����mac��,����һ��(��ָ·����,���ǽ��ܶ�,���ն���Ӧ�ò����޷���ȡ��)
		 * ����㼴���Ի�ȡ���洫�ݵ������ֽڵ���Ϣ,������������ֽڼ����Եõ�һ������Ϣ;
		 * */
		String host = "224.116.8.0";
		int port = 2011;
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				send(host, port, SDF.format(new Date()));
			}
		}, 0, 2000);
	}
	
	public static void send(String addr, int port, String msg) {
		try (MulticastSocket socket = new MulticastSocket(port);) {
			// TTL�������Ϸ��룬�ǿ��Դ���ʱ�䣬��ʵ����TTL��IP���ݰ��ڼ���������п���ת�����������,1Ϊ��������
			socket.setTimeToLive(1);
			InetAddress mcastaddr = InetAddress.getByName(addr);
			socket.joinGroup(mcastaddr);// ���� �鲥��
			byte[] b = msg.getBytes();
			DatagramPacket pack = new DatagramPacket(b, b.length, mcastaddr, port);
			// ���������ݰ�
			socket.send(pack);// �鲥���� ���ݱ����ɱ�group��Ա���յ�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}