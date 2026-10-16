
package clientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        System.out.println("Je suis un client pas encore connecté...");

        Socket socket = new Socket("localhost", 1234);
        System.out.println("Je suis un client connecté.");

        Scanner scanner = new Scanner(System.in);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        DataInputStream dis = new DataInputStream(socket.getInputStream());

        while (true) {
            System.out.print("Entrer un entier x (0 pour quitter) : ");
            int x = scanner.nextInt();

            dos.writeInt(x);
            dos.flush();

            System.out.println("Nombre envoyé au serveur : " + x);

            if (x == 0) {
                System.out.println("Fin de la communication.");
                break;
            }

            int resultat = dis.readInt();
            System.out.println("Résultat reçu du serveur : " + resultat);
        }

        dis.close();
        dos.close();
        socket.close();
        scanner.close();

        System.out.println("Client arrêté.");
    }
}
