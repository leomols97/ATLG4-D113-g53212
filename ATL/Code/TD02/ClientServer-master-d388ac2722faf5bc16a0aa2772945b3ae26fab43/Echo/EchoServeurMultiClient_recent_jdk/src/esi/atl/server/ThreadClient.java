package esi.atl.server;

import java.io.IOException;
import java.net.Socket;

public class ThreadClient extends Thread {

    private final Socket socket;

    public ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (var in = socket.getInputStream();
                var out = socket.getOutputStream()) {
            int msg;
            while ((msg = in.read()) != -1) {
                System.out.println("Message from client " + (char) msg);
                out.write(msg);
            }
        } catch (IOException ex) {
            System.out.println("Error run()" + ex.getMessage());
        }
    }
}
