package esi.atl.server;

import java.io.IOException;
import java.net.ServerSocket;

public class EchoServeurMulticlient {

    public static void main(String[] args) {
        // EchoServeurMulticlient server = new EchoServeurMulticlient(7);
        // au 401 et 404 : Error listening()Address already in use: NET_Bind
        var server = new EchoServeurMulticlient(7777);
        server.listening();
    }

    private final boolean running = true;
    private final int port;

    public EchoServeurMulticlient(int port) {
        this.port = port;
    }

    public void listening() {
        try (var serverSocket = new ServerSocket(port)) {
            while (running) {
                System.out.println("Serveur listening ...");
                var socket = serverSocket.accept();
                new ThreadClient(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error listening()" + ex.getMessage());
        }
    }

}
