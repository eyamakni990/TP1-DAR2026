
package clientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 1234);
             DataInputStream in =new DataInputStream(socket.getInputStream());
             DataOutputStream out =new DataOutputStream(socket.getOutputStream());
             Scanner sc = new Scanner(System.in)) {

            int choix;

            do {
                System.out.println("\n=== CALCULATRICE TCP ===");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");

                choix = sc.nextInt();

                if (choix < 0 || choix > 4) {
                    System.out.println("Choix invalide ! Essayez encore.");
                    continue;
                }

                out.writeInt(choix);
                out.flush();

                if (choix == 0) {
                    System.out.println("Fin du client.");
                    break;
                }


                System.out.print("Donner le premier nombre x : ");
                double x = sc.nextDouble();

                System.out.print("Donner le deuxieme nombre y : ");
                double y = sc.nextDouble();

                out.writeDouble(x);
                out.writeDouble(y);
                out.flush();

                boolean succes = in.readBoolean();

                if (succes) {
                    double resultat = in.readDouble();
                    System.out.println("Resultat = " + resultat);
                } else {
                    System.out.println("Erreur : " + in.readUTF());
                }

            } while (true);

        } catch (IOException e) {
            System.out.println("Erreur client : " + e.getMessage());
        }
    }
}
