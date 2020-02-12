package esi.atl.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServeurMulticlient {

    public static void main(String[] args) {
        // EchoServeurMulticlient server = new EchoServeurMulticlient(7);
        // au 401 et 404 : Error listening()Address already in use: NET_Bind
        EchoServeurMulticlient server = new EchoServeurMulticlient(7777);
        server.listening();
    }

    private final boolean running;
    private final int port;

    public EchoServeurMulticlient(int port) {
        this.port = port;
        this.running = true;
    }

    public void listening() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (running) {
                System.out.println("Serveur listening ...");
                Socket localSocket = serverSocket.accept();
                new ThreadClient(localSocket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error listening()" + ex.getMessage());
        }
    }

}
