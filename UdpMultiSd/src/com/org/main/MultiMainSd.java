package com.org.main;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MultiMainSd {
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss:SSS");// 显示日期格式
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			// TTL从字面上翻译，是可以存活的时间，但实际上TTL是IP数据包在计算机网络中可以转发的最大跳数,1为本地网络
			socket.setTimeToLive(1);
			InetAddress mcastaddr = InetAddress.getByName(addr);
			socket.joinGroup(mcastaddr);// 加入 组播组
			byte[] b = msg.getBytes();
			DatagramPacket pack = new DatagramPacket(b, b.length, mcastaddr, port);
			// 待发送数据包
			socket.send(pack);// 组播发送 数据报，可被group成员接收到
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
