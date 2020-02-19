package esi.atl.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientAleatoire
{
    private String hostName;
    private int port;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ClientAleatoire clientAleatoire = new ClientAleatoire("localhost",49152);
        // for (;;) // permet de boucler infiniment sur l'instruction suivante
            clientAleatoire.start();
    }

    public ClientAleatoire(String hostName, int port) {
        this.hostName = hostName;
        this.port = port;
    }

    public void start()
    {
        int maxVal = sc.nextInt();
        try (Socket socket = new Socket(hostName, port)){
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
            Scanner scannerIn = new Scanner(socket.getInputStream());
            dataOut.writeInt(maxVal);
            while (!scannerIn.hasNext()) {}
            String output = scannerIn.nextLine();
            System.out.println(output);
        } catch (IOException e) {
            System.out.printf("La connexion avec le serveur a échoué car (%s)%n", e.getMessage());
        }
    }
}