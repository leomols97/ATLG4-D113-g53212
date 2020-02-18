package esi.atl.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author leopoldmols
 */

public class ServeurAleatoire
{
    public static void main(String[] args)
    {
        // EchoServer server = new EchoServer(7);
        // au 401 et 404 : Error new ServerSocket 7 Address already in use: NET_Bind
        EchoServer server = new EchoServer(49152);
        server.listening();
    }
    
    private boolean running;

    private final int port;

    public ServeurAleatoire(int port)
    {
        this.port = port;
        this.running = true;
    }

    public void listening()
    {
        int msg;
        try (ServerSocket serverSocket = new ServerSocket(49152))
        {
            while (running)
            {
                System.out.println("Serveur listening ...");
                try (Socket localSocket = serverSocket.accept();
                        InputStream in = localSocket.getInputStream();
                        OutputStream out = localSocket.getOutputStream())
                {
                    while ((msg = in.read()) != -1)
                    {
                        System.out.println("Message from client " + (char) msg);
                        out.write(msg);
                    }
                }
                catch (IOException ex)
                {
                    System.out.println("Error listening()" + ex.getMessage());
                    running = false;
                }
            }
        }
        catch (IOException ex)
        {
            System.out.println("Error new ServerSocket " + port + " "
                    + ex.getMessage());
            System.exit(-1);
        }
    }
}
