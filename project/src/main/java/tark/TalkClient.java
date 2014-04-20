package tark;

import java.io.*;
import java.net.*;

public class TalkClient extends Thread {
    static BufferedReader is;

    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("127.0.0.1", 4701);
        try {
            System.out.println("连接服务器成功!");
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            try {
                PrintWriter os = new PrintWriter(socket.getOutputStream());
                try {
                    is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    try {
                        String readline = "";
                        TalkClient talkclient = new TalkClient();
                        talkclient.start();
                        readline = sin.readLine();
                        while (!readline.equals("bye")) {
                            os.println(readline);
                            os.flush();
                            System.out.println("Client:" + readline);
                            readline = sin.readLine();
                        }
                    } finally {
                        is.close();
                    }
                } finally {
                    os.close();
                }
            } finally {
                sin.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            socket.close();
        }
    }

    public void run() {
        String message = "";
        try {
            while ((message = is.readLine()) != null) {
                System.out.println("Server:" + message);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
