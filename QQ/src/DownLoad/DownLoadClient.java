package DownLoad;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by dell1 on 2018/2/8.
 */
//下载的客户端
public class DownLoadClient {

    public static void main(String[] args) throws IOException {
        //建立客户端
        Socket socket = new Socket(InetAddress.getLocalHost(),9090);
        //获取输入输出流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //输出流放想要输出的路径
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("")));
        String line = null;
        while((line = br.readLine())!=null)
        {
            bw.write(line);
            bw.flush();
        }
        bw.close();
        //br会随着socket的关闭而关闭
        socket.close();
    }
}
