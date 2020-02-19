package be.he2b.atl.chat.view.console;

import be.he2b.atl.chat.model.ChatClient;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The <code> ChatClientConsole </code> contains all the methods necessary view
 * in console mode the instant messaging client side.
 */
public class ChatClientConsole implements Observer {

    /**
     * Entry points to the instant messaging client side.
     *
     * @param args no arguments needed.
     */
    public static void main(String[] args) {
        ChatClient client = null;
        try {
            String host = "192.168.16.216";
            int port = 12_345;
            String name = "g53212";
            String password = "";
            client = new ChatClient(host, port, name, password);
            ChatClientConsole console = new ChatClientConsole(client);
            client.sendToServer("Mols");
            while (true) {
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatClientConsole.class.getName()).
                    log(Level.SEVERE, "Main error", ex);
            try {
                client.quit();
            } catch (NullPointerException | IOException clientEx) {
                Logger.getLogger(ChatClientConsole.class.getName()).log(
                        Level.SEVERE, "Quit client error", clientEx);
            }
            System.exit(1);
        }
    }

    private final ChatClient model;

    /**
     * Constructs the console view. Subscribes to the instant messaging client.
     *
     * @param client instant messaging client.
     */
    public ChatClientConsole(ChatClient client) {
        this.model = client;
        this.model.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Console update");
        if (arg != null) {
            System.out.println("Message : " + arg);
        }
    }

}
