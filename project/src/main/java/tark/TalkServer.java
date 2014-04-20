package tark;

import java.io.*;
import java.net.*;

public class TalkServer extends Thread {
    static BufferedReader is;

    public static void main(String args[]) {
        try {
            ServerSocket server = null;
            try {
                server = new ServerSocket(4701);
            } catch (Exception e) {
                System.out.println("can not listen to:" + e);
            }
            Socket socket = null;
            try {
                socket = server.accept();
                System.out.println("客户端已连接服务器！");
            } catch (Exception e) {
                System.out.println("Error." + e);
            }

            String readline;
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            TalkServer talkserver = new TalkServer();
            talkserver.start();
            readline = sin.readLine();

            while (!readline.equals("bye")) {
                os.println(readline);
                os.flush();
                System.out.println("Server:" + readline);
                readline = sin.readLine();
            }
            os.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    public void run() {
        String message = "";
        try {
            while ((message = is.readLine()) != null) {
                System.out.println("Client:" + message);
            }
        } catch (IOException e) {

        }
    }

}
