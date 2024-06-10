package java知识点.网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Author: 雨同我
 * @Description: 知识点 socker
 * 一个Socket就是由IP地址和端口号（范围是0～65535）组成，可以把Socket简单理解为IP地址加端口号。端口号总是由操作系统分配，它是一个0～65535
 * 之间的数字，其中，小于1024的端口属于特权端口，需要管理员权限，大于1024的端口可以由任意用户的应用程序打开。
 *
 *
 * 字节流
 * java.io.InputStream 字节输入流
 * java.io.OutputStream 字节输出流
 * 字符流
 * java.io.Reader 字符输入流
 * java.io.Writer 字符输出流
 *（flush清空管道）
 *
 * 字符流：
 * 字符流是基于字符的处理方式。它以字符为单位进行读写操作，并且能够正确地处理字符编码和字符集的相关操作。
 * 字符流通常用于处理文本数据，比如读取和写入文本文件。
 * 字符流在内部使用了缓冲区，这个缓冲区可以提高读写的效率。
 *
 * 字节流：
 * 字节流是基于字节的处理方式。它以字节为单位进行读写操作，对数据没有字符编码和字符集的假设，只是纯粹的字节序列。
 * 字节流通常用于处理二进制数据，比如读取和写入图像文件、音频文件和视频文件等。
 * 字节流没有使用缓冲区，每次读写都直接操作底层字节，所以相对于字符流可能会更加底层和高效。
 *
 *
 * 注意点：
 *    String s=reader.readLine();
 *     writer.newLine();
 *     记得看输入流，他是换行结束，读取也是换行结束
 *
 *
 * @DateTime: 2023/12/22 10:34
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("============>socket服务启动");
        while (true){
            Socket accept = serverSocket.accept();
            System.out.println("==="+accept.getRemoteSocketAddress());
            Thread handle = new Handle(accept);
            handle.start();
        }
    }
}
class Handle extends Thread{
    Socket socket;

    public Handle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream inputStream=socket.getInputStream()){
            try(OutputStream outputStream=socket.getOutputStream()){
                handle(inputStream,outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handle(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream,StandardCharsets.UTF_8));
        writer.write("hello");
        System.out.println("进入监听状态");
        writer.flush();
        while (true){
            String s=reader.readLine();
            System.out.println("读取客户端信息==》"+s);
            writer.write("已经接收==》"+s);
//            writer.newLine();
            writer.flush();
            if ("exit".equals(s)){
                writer.write("exit");
                writer.flush();
                break;
            }
        }
    }
}
