package esi.atl.server;

import esi.atl.msg.Message;
import esi.atl.msg.Type;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        EchoServer server = new EchoServer(7);
        server.listening();
    }

    private boolean status;
    private final int port;
    private ObjectInputStream fromClient;
    private ObjectOutputStream toClient;

    public EchoServer(int port) {
        this.port = port;
        this.status = true;
    }

    public void listening() {
        String msg;
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (status) {
                System.out.println("Server listening ...");
                try (Socket localSocket = serverSocket.accept();
                     InputStream in = localSocket.getInputStream();
                     OutputStream out = localSocket.getOutputStream();) {
                    fromClient = new ObjectInputStream(in);
                    toClient = new ObjectOutputStream(out);
                    while ((msg = readFromClient()) != null) {
                        System.out.println("Message from client " + msg);
                        writeToClient(msg);
                    }
                } catch (IOException ex) {
                    System.out.println("Error listening()" + ex.getMessage());
                    status = false;
                } catch (ClassNotFoundException ex) {
                    System.out.println("Unreadeable Message " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("Error new ServerSocket " + port + " " +
                               ex.getMessage());
            System.exit(-1);
        }
    }

    private void writeToClient(String msg) throws IOException {
        Message msgTo = new Message(Type.SRV_STATE_INFO, msg);
        toClient.writeObject(msgTo);
        toClient.flush();
    }

    private String readFromClient() throws IOException, ClassNotFoundException {
        Object object = fromClient.readObject();
        Message msgFrom = (Message) object;
        String clientMsg = msgFrom.getTxt();
        return clientMsg;
    }

}
