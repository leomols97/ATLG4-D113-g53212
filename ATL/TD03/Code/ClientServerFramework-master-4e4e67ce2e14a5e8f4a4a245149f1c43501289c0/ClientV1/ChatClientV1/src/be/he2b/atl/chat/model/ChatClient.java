package be.he2b.atl.chat.model;

import be.he2b.atl.client.AbstractClient;
import java.io.IOException;

/**
 * The <code> ChatClient </code> contains all the methods necessary to set up a
 * Instant messaging client.
 */
public class ChatClient extends AbstractClient {
    
    /**
     * Constructs the client. Opens the connection with the server.
     *
     * @param host the server's host name.
     * @param port the port number.
     * @param name the name of the user.
     * @param password the password needed to connect.
     * @throws IOException if an I/O error occurs when opening.
     */
    public ChatClient(String host, int port, String name, String password)
            throws IOException {
        super(host, port);
        openConnection();
    }
    
    @Override
    protected void handleMessageFromServer(Object msg) {
        System.out.println("testhandleMessageFromServer(Object msg)");
        setChanged();
        notifyObservers(msg);
    }
    
    /**
     * Quits the client and closes all aspects of the connection to the server.
     *
     * @throws IOException if an I/O error occurs when closing.
     */
    public void quit() throws IOException {
        closeConnection();
    }
    
    @Override
    protected void connectionEstablished()
    {
        if (isConnected())
        {
            System.out.println("Client connecté");
        }
        else
        {
            System.out.println("Client non connecté");
        }
    }
}