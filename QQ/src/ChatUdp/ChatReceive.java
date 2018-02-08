package ChatUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//群聊的接受端
public class ChatReceive extends Thread {
	
	@Override
	public void run() {
		try {
			//建立接受端
			DatagramSocket socket = new DatagramSocket(9090);
			// 缓冲数组
			byte[] buf = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			boolean flag = true;
			while(flag){
				socket.receive(packet);
				// packet.getAddress() 获取发送端的地址，全都封装在其发送过来的包里面
				System.out.println(packet.getAddress().getHostAddress()+"˵:"+new String(buf,0,packet.getLength()));
			}
			//关闭连接
			socket.close();
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
