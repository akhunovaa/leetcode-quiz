package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleFixedThreadPoolServer {

    static final int PORT = 8080;
    static final String NEW_LINE = "\r\n";

    public static void main(String[] args) throws IOException {
        run();
    }

    static void run() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(80);
            while (true) {
                Socket connection = serverSocket.accept();
                threadPoolExecutor.submit(() -> handle(connection));
            }
        }
    }

    private static void handle(Socket connection) {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            OutputStream out = new BufferedOutputStream(connection.getOutputStream());
            PrintStream pout = new PrintStream(out);

            // read first line of request
            String request = in.readLine();
            if (request == null) return;

            // we ignore the rest
            while (true) {
                String ignore = in.readLine();
                if (ignore == null || ignore.length() == 0) break;
            }

            System.out.println(connection);
//            Thread.sleep(2000);
            if (!request.startsWith("GET ") ||
                    !(request.endsWith(" HTTP/1.0") || request.endsWith(" HTTP/1.1"))) {
                // bad request
                pout.print("HTTP/1.0 400 Bad Request" + NEW_LINE + NEW_LINE);
            } else {
                String response = "Hello, World!";

                pout.print(
                        "HTTP/1.0 200 OK" + NEW_LINE +
                                "Content-Type: text/plain" + NEW_LINE +
                                "Date: " + new Date() + NEW_LINE +
                                "Content-length: " + response.length() + NEW_LINE + NEW_LINE +
                                response + " Thread name: " + Thread.currentThread().getName() + NEW_LINE + request + NEW_LINE +
                                "Active thread count: " + Thread.activeCount() + NEW_LINE
                );
            }

            pout.close();
        } catch (Throwable tri) {
            System.err.println("Error handling request: " + tri);
        }
    }
}
