package ChatTcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 一问一答的服务端
 */
public class ChatServer {

	public static void main(String[] args) throws IOException {
		//建立服务端
		ServerSocket serverSocket = new ServerSocket(9090);
		//通过服务端获取连接的客户端
		Socket socket = serverSocket.accept();
		//获取输入流
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//获取输出流
		OutputStreamWriter socketOut =  new OutputStreamWriter(socket.getOutputStream());
		
		//获取从键盘的输入
		BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
		

		String line = null;
        //边读边写
		while((line = socketReader.readLine())!=null){
			System.out.println("客户端发送的数据:"+ line);
			
			System.out.println("请输入回送给客户端的数据:");
			line = keyReader.readLine();
			socketOut.write(line+"\r\n");
			socketOut.flush();
		}
		
		//关闭服务端
		serverSocket.close();
	}
}
