package be.he2b.atl.chat.view.console;

import be.he2b.atl.chat.model.ChatClient;
import be.he2b.atl.chat.users.User;
import be.he2b.atl.message.Message;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
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
            String name = "Leeeeeeo";
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

    /**
     * Constructs the console view. Subscribes to the instant messaging client.
     *
     * @param client instant messaging client.
     */
    public ChatClientConsole(ChatClient client) {
        this.model = client;
        this.model.addObserver(this);
    }

    /**
     * Asks to the user a command in console.
     * If the command is list, the console print the list of all connected users.
     * If the command is quit, the client disconnect from the server.
     */
    private void askCommand() {
        System.out.println("Quelle commande voulez-vous exécuter ? ");
    }


    private void printUsage() {
        System.out.println("");
        System.out.println("Usage : ");
        System.out.println("\tAfficher la liste de utilisateurs connectés\t:\tlist");
        System.out.println("\tSe deconnecter\t:\tquit");
        System.out.println("");
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Message reçu! "+arg);
        if (arg != null) {
            Message message = (Message) arg;
            System.out.println("Message recu");
        }
    }

}
