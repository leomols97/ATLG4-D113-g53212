package esi.atl.client;

import esi.atl.msg.Message;
import esi.atl.msg.Type;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) {
        EchoClient client = new EchoClient("localhost", 7);
        client.start();
    }

    private final String host;
    private final int port;
    private ObjectOutputStream toServer;
    private ObjectInputStream fromServer;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        String userInput;
        String serverAnswer;
        try (Socket socketClient = new Socket(host, port);
             InputStream in = socketClient.getInputStream();
             OutputStream out = socketClient.getOutputStream();
             BufferedReader keyboard =
                            new BufferedReader(new InputStreamReader(System.in));) {
            System.out.println("Client started ...");
            toServer = new ObjectOutputStream(out);
            fromServer = new ObjectInputStream(in);
            while ((userInput = keyboard.readLine()) != null) {
                writeToServer(userInput);
                serverAnswer = readFromServer();
                System.out.println("Message from server : " + serverAnswer);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Unreadeable Message " + ex.getMessage());
        }
    }

    private void writeToServer(String userInput) throws IOException {
        Message msgTo = new Message(Type.CLT_MSG, userInput);
        toServer.writeObject(msgTo);
        toServer.flush();
    }

    private String readFromServer() throws IOException, ClassNotFoundException {
        Object object = fromServer.readObject();
        Message msgFrom = (Message) object;
        String serverAnswer = msgFrom.getTxt();
        return serverAnswer;
    }

}
