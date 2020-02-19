package be.he2b.atl.chat.model;

import be.he2b.atl.chat.users.User;
import be.he2b.atl.client.AbstractClient;
import be.he2b.atl.message.Message;
import be.he2b.atl.message.MessageProfile;
import be.he2b.atl.message.Type;
import java.io.IOException;

/**
 * The <code> ChatClient </code> contains all the methods necessary to set up a
 * Instant messaging client.
 */
public class ChatClient extends AbstractClient {

    private User mySelf;

    /**
     * Constructs the client. Opens the connection with the server. Sends the
     * user name inside a <code> MessageProfile </code> to the server.
     *
     * @param host the server's host name.
     * @param port the port number.
     * @param name the name of the user.
     * @param password the password needed to connect.
     * @throws IOException if an I/O error occurs when opening.
     */
    public ChatClient(String host, int port, String name, String password) throws IOException {
        super(host, port);
        openConnection();
        sendToServer(new MessageProfile(0, name));
    }

    @Override
    protected void handleMessageFromServer(Object msg) {
        Message message = (Message) msg;
        Type type = message.getType();
        switch (type) {
            case PROFILE:
                setMySelf(message.getAuthor());
                break;
            default:
                throw new IllegalArgumentException("Message type unknown " + type);
        }
        setChanged();
        notifyObservers(message);
    }

    /**
     * Quits the client and closes all aspects of the connection to the server.
     *
     * @throws IOException if an I/O error occurs when closing.
     */
    public void quit() throws IOException {
        closeConnection();
    }

    /**
     * Return the user.
     *
     * @return the user.
     */
    public User getMySelf() {
        return mySelf;
    }

    private void setMySelf(User user) {
        this.mySelf = user;
    }

}
