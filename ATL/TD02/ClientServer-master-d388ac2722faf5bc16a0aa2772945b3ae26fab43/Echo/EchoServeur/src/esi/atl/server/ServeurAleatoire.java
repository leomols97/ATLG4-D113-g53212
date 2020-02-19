package esi.atl.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author leopoldmols
 */

public class ServeurAleatoire {

    private static Random random = new Random();

    public static void main(String[] args) {
        // EchoServer server = new EchoServer(7);
        // au 401 et 404 : Error new ServerSocket 7 Address already in use: NET_Bind
        ServeurAleatoire server = new ServeurAleatoire(49152);
        server.listening();
    }

    private boolean running;

    private final int port;

    public ServeurAleatoire(int port) {
        this.port = port;
        this.running = true;
    }

    public void listening() {
        int msg;
        try (ServerSocket serverSocket = new ServerSocket(this.port)) {
            while (running) {
                System.out.println("Serveur listening ...");
                try (Socket localSocket = serverSocket.accept()) {
                    DataInputStream dataIn = new DataInputStream(localSocket.getInputStream());
                    PrintWriter writer = new PrintWriter(
                            localSocket.getOutputStream()
                    );
                    int maxVal = dataIn.readInt();
                    writer.printf("%d\r\n", random.nextInt(maxVal));
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println("Error listening()" + ex.getMessage());
                    running = false;
                }
            }
        } catch (IOException ex) {
            System.out.println("Error new ServerSocket " + port + " "
                    + ex.getMessage());
            System.exit(-1);
        }
    }
}
