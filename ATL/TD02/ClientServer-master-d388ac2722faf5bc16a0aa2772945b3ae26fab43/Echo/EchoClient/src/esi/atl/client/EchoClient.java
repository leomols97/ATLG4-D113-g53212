package esi.atl.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) {
        // EchoClient client = new EchoClient("localhost", 7);
        // pour test au 401 et 404 :
        EchoClient client = new EchoClient("localhost", 7777);
        client.start();
    }

    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        String userInput;
        String serverAnswer;
        try (Socket socketClient = new Socket(host, port);
                PrintWriter toServer = new PrintWriter(socketClient.
                        getOutputStream());
                BufferedReader fromServer = new BufferedReader(
                        new InputStreamReader(socketClient.getInputStream()));
                BufferedReader keyboard = new BufferedReader(
                        new InputStreamReader(System.in))) {
            System.out.println("Client started ...");
            while ((userInput = keyboard.readLine()) != null) {
                toServer.println(userInput);
                toServer.flush();
                serverAnswer = fromServer.readLine();
                System.out.println("Response from server : " + serverAnswer);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
