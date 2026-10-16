
package serverPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println(
                "Je suis un serveur en attente de la connexion d'un client."
        );

        Socket socket = serverSocket.accept();
        System.out.println("Un client est connecté.");

        DataInputStream dis = new DataInputStream(socket.getInputStream());

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        while (true) {
            int nb = dis.readInt();

            if (nb == 0) {
                System.out.println("Fin de la communication.");
                break;
            }

            System.out.println("Le serveur a reçu le nombre : " + nb);

            int resultat = nb * 5;

            System.out.println(
                    "Calcul du serveur : " + nb + " * 5 = " + resultat
            );

            dos.writeInt(resultat);
            dos.flush();

            System.out.println(
                    "Le résultat a été envoyé au client : " + resultat
            );
        }

        dis.close();
        dos.close();
        socket.close();
        serverSocket.close();

        System.out.println("Serveur arrêté.");
    }
}
