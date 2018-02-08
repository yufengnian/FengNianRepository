package ChatTcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/*
    通过tcp协议进行通信
 */


//一问一答的客户端
public class ChatClient {

	public static void main(String[] args) throws IOException {
		//建立客户端
		Socket socket = new Socket(InetAddress.getLocalHost(),9090);
		//获取输出流
		OutputStreamWriter socketOut =	new OutputStreamWriter(socket.getOutputStream());
		//获取输入流
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//从键盘读入数据
		BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		//边读边写
		while((line = keyReader.readLine())!=null){
            //必须加上/r/n，否则无法读取到结束
			socketOut.write(line+"\r\n");
			//刷新缓冲区
			socketOut.flush();
			
			//接受从服务端的数据
			line = socketReader.readLine();
			System.out.println("服务端:"+line);
		}
		//关闭客户端
		socket.close();
	}
	
	
}
