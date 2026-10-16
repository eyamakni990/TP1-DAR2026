package serverPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        //creation du serveur
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Je suis un serveur en attente la connexion d'un client ");

        //attendre un client
        Socket socket = serverSocket.accept();
        System.out.println("un client est connecté");

        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        int nb = dis.readInt();
        System.out.println("Le serveur a recu le nombre : " + nb);

        int x = nb * 5;
        System.out.println("Calcul du serveur : " + nb + "*5 = " + x);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(x);
        System.out.println("le résultat a été envoyé au client. " + x);

        dis.close();
        dos.close();
        socket.close();
        serverSocket.close();
    }
}
