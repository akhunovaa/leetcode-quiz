package server;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Could not start server: java.lang.OutOfMemoryError: unable to create native thread: possibly out of memory or process/resource limits reached
 * [50.931s][warning][os,thread] Failed to start thread - pthread_create failed (EAGAIN) for attributes: stacksize: 1024k, guardsize: 4k, detached.
 */
public class SimpleClient {

    static final int PORT = 8080;
    static final String HOSTNAME = "localhost";
    static final String NEW_LINE = "\r\n";

    public static void main(String[] args) throws InterruptedException {

        Socket[] socketList = new Socket[100000];

        for (int i = 0; i < socketList.length; i++) {
            try {
                socketList[i] = new Socket(HOSTNAME, PORT);


//                OutputStream output = socketList[i].getOutputStream();
//                PrintWriter writer = new PrintWriter(output, true);
//
//                writer.println("GET " + "/test/" + i + " HTTP/1.1");
//                writer.println("Host: " + HOSTNAME);
//                writer.println("User-Agent: Simple Http Client");
//                writer.println("Accept: text/html");
//                writer.println("Accept-Language: en-US");
//                writer.println("Connection: close");
//                writer.println();
//
//                InputStream input = socketList[i].getInputStream();
//
//                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//
//                String line;
//
//                while ((line = reader.readLine()) != null) {
//                    System.out.println(line);
//                }


            } catch (UnknownHostException ex) {
                System.out.println("Server not found: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("I/O error: " + ex.getMessage());
            }


        }

        Thread.sleep(10000000);

    }
}
