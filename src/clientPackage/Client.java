package clientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Je suis un client pas encore connecté…");

        Socket socket = new Socket("localhost", 1234);
        System.out.println("je suis un client connecté");

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter un entier x :");
        int x = scanner.nextInt();

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(x);
        System.out.println("Nombre envoyé au serveur :" + x);

        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        int xx = dis.readInt();
        System.out.println("Result recu du serveur : " + xx);
        dis.close();
        dos.close();
        socket.close();
        scanner.close();
    }
}