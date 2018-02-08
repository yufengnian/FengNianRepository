package ChatUdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

//群聊的发送端
public class ChatSender extends Thread {
	
	@Override
	public void run() {
		try {
			//获取发送端
			DatagramSocket socket = new DatagramSocket();
			//׼得到从键盘的输入
			BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			DatagramPacket packet  = null;
			while((line = keyReader.readLine())!=null){
				//将键盘的输入封装打包发送给接受端
				packet = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("192.168.15.255"), 9090);
				//发送包
				socket.send(packet);
			}
			//关闭发送端
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
