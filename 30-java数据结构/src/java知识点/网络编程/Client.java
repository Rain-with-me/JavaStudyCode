package java知识点.网络编程;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/12/22 11:37
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6666);
        try (InputStream input = socket.getInputStream()) {
            try (OutputStream output = socket.getOutputStream()) {
                handle(input, output);
            }
        }
        socket.close();
        System.out.println("disconnected.");
    }

    private static void handle(InputStream input, OutputStream output) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output,StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        while (true){
            String in=scanner.nextLine();
            System.out.println("发送成功==>"+in);
            writer.write(in);
            writer.newLine();
            writer.flush();
            String s = reader.readLine();
            System.out.println("服务器响应==>"+s);
            if ("exit".equals(s)){
                break;
            }
        }
    }
}
