package esi.atl.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ThreadClient extends Thread {

    private final Socket localSocket;

    public ThreadClient(Socket localSocket) {
        this.localSocket = localSocket;
    }

    @Override
    public void run() {
        int msg;
        try (InputStream in = localSocket.getInputStream();
                OutputStream out = localSocket.getOutputStream()) {
            while ((msg = in.read()) != -1) {
                System.out.println("Message from client " + (char) msg);
                out.write(msg);
            }
        } catch (IOException ex) {
            System.out.println("Error run()" + ex.getMessage());
        }
    }
}
