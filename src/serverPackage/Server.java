
package serverPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(1234)) {

            System.out.println("Serveur en attente du client...");

            try (Socket socket = serverSocket.accept();
                 DataInputStream in =
                         new DataInputStream(socket.getInputStream());
                 DataOutputStream out =
                         new DataOutputStream(socket.getOutputStream())) {

                System.out.println("Client connecté.");

                while (true) {

                    int choix = in.readInt();

                    // Choix 0 : arrêter la communication
                    if (choix == 0) {
                        System.out.println("Fin de la communication.");
                        break;
                    }

                    double x = in.readDouble();
                    double y = in.readDouble();

                    double resultat = 0;
                    String erreur = "";

                    switch (choix) {

                        case 1:
                            resultat = x + y;
                            break;

                        case 2:
                            resultat = x - y;
                            break;

                        case 3:
                            resultat = x * y;
                            break;

                        case 4:
                            if (y == 0) {
                                erreur = "Division par zero impossible.";
                            } else {
                                resultat = x / y;
                            }
                            break;

                        default:
                            erreur = "Choix invalide.";
                    }

                    if (!erreur.isEmpty()) {
                        out.writeBoolean(false);
                        out.writeUTF(erreur);
                    } else {
                        out.writeBoolean(true);
                        out.writeDouble(resultat);
                    }

                    out.flush();
                }
            }

        } catch (IOException e) {
            System.out.println("Erreur serveur : " + e.getMessage());
        }
    }
}
