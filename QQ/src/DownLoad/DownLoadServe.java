package DownLoad;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dell1 on 2018/2/8.
 */
//下载的服务端
public class DownLoadServe extends Thread {

    Socket socket ;
    //通过多线程连接多个客户端
    public DownLoadServe(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //获取读写字符流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //new FIleInputStrean里放让客户端下载的文件路径
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("")));

            String line = null;
            while((line = br.readLine())!=null)
            {
                //边读边写
                bw.write(line);
                //刷新缓冲区
                bw.flush();
            }
            br.close();
            //关闭socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        //服务端
        ServerSocket serverSocket = new ServerSocket(9090);
        //服务端一直开启
        while(true)
        {
            Socket socket1 = serverSocket.accept();
            //启动
            new DownLoadServe(socket1).start();
        }
    }
}
