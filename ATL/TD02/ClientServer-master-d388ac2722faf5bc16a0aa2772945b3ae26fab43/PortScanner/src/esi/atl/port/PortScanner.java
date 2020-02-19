package esi.atl.port;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Tente de se connecter sur tous les ports d'une machine
 *
 * Attention : n'essayer ce programme que sur une machine que vous possedez, il
 * risque en effet d'être consideré hostile !
 *
 * Tire de : Java Network Programming, 3rd Edition, Elliotte Rusty Harold,
 * O'Reilly, Sebastopol (CA), 2005
 */
public class PortScanner {

    public static void main(String[] args) {

        String host = "localhost";

        if (args.length > 0) {
            host = args[0];
        }

        for (int i = 1; i < 65536; ++i) {
            Socket connection = null;
            try {
                connection = new Socket(host, i);
                System.out.println("There is a server on port "
                        + i + " of " + host);
            } catch (UnknownHostException uhe) {
                System.err.println("Bad hostname : " + uhe);
                break; // pour interrompre le for
            } catch (IOException e) {
                System.out.println("No server on port "
                        + i + " of " + host);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (IOException e) {
                }
            }
        } // end for    
    }  // end main
}
