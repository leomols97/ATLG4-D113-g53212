package esi.atl.local.port;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Tente de creer un serveur sur chaque port de la machine hote dans le but de
 * tester quels ports sont deja utilises
 *
 * Tire de : Java Network Programming, 3rd Edition, Elliotte Rusty Harold,
 * O'Reilly, Sebastopol (CA), 2005
 */
public class LocalPortScannerRessources {

    public static void main(String[] args) {

        for (int port = 1; port <= 65535; ++port) {
            try (ServerSocket server = new ServerSocket(port)) {
                System.out.println("Pas de serveur sur le port : " + port + ".");
            } catch (IOException ex) {
                System.out.println("There is a server on port " + port + ".");
            } // end catch      
        } // end for
    }
}
