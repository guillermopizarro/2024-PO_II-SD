package tcp_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public final String HOST = "127.0.0.1";
    public final int PORT = 2020;

    public Client() {
        try {
            Socket socket = new Socket(HOST, PORT);
            System.out.println("Conexion exitosa al servidor.");

            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader in_socket = new BufferedReader(in);

            String mensaje = in_socket.readLine();
            System.out.println("Servidor dice: " + mensaje);

            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}

