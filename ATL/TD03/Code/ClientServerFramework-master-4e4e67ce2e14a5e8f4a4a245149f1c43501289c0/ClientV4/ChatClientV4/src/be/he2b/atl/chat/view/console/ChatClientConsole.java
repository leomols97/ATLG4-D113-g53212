package be.he2b.atl.chat.view.console;

import be.he2b.atl.chat.model.ChatClient;
import be.he2b.atl.message.Message;
import be.he2b.atl.message.Type;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
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
            String host = "localhost";
            int port = 12_345;
            String name = "g12345";
            String password = "";
            client = new ChatClient(host, port, name, password);
            ChatClientConsole console = new ChatClientConsole(client);
            console.printUsage();
            console.askCommand();
        } catch (IOException ex) {
            Logger.getLogger(ChatClientConsole.class.getName()).log(Level.SEVERE, "Main error", ex);
            try {
                client.quit();
            } catch (NullPointerException | IOException clientEx) {
                Logger.getLogger(ChatClientConsole.class.getName()).log(Level.SEVERE, "Quit client error", clientEx);
            }
            System.exit(0);
        }
    }

    private final ChatClient model;
    private final DateTimeFormatter formatter;

    /**
     * Constructs the console view. Subscribes to the instant messaging client.
     *
     * @param client instant messaging client.
     */
    public ChatClientConsole(ChatClient client) {
        this.model = client;
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.model.addObserver(this);
    }

    /**
     * Asks to the user a command in console.
     * If the command is list, the console print the list of all connected users.
     * If the command is send, the client sends a message to the given connected user.
     * If the command is quit, the client disconnect from the server.
     */
    private void askCommand() {

    }


    private void printUsage() {
        System.out.println("");
        System.out.println("Usage : ");
        System.out.println("\tAfficher la liste de utilisateurs connectés\t:\tlist");
        System.out.println("\tEnvoyer un message à un utilisateur connecté\t:\tsend <userID> <message>");
        System.out.println("\tSe deconnecter\t:\tquit");
        System.out.println("");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null) {
            Message message = (Message) arg;
            if (message.getType().equals(Type.MAIL_TO)) {
            }
        }
    }

}
