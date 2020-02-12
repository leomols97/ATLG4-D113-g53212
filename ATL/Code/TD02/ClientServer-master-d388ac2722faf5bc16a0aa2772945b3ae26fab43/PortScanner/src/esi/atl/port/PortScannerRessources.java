package esi.atl.port;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortScannerRessources {

    public static void main(String[] args) {

        String host = "localhost";

        if (args.length > 0) {
            host = args[0];
        }

        for (int i = 1; i < 65536; ++i) {
            try (Socket connection = new Socket(host, i)) {
                System.out.println("There is a server on port " + i + " of " + host);
            } catch (UnknownHostException uhe) {
                System.err.println("Bad hostname : " + uhe);
                break; // pour interrompre le for
            } catch (IOException e) {
                System.out.println("No server on port " + i + " of " + host);
            }
        } // end for    
    }  // end main
}
