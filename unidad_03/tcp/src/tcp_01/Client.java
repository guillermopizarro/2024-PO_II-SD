package tcp_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public final String HOST = "127.0.0.1";
    public final int PORT = 2020;

    public Client() {
        try {
            Socket socket = new Socket(HOST, PORT);
            System.out.println("Conexion exitosa al servidor.");

            // Comunicacion entre sockets - Cliente al servidor
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out_socket = new PrintWriter(out);

            out_socket.println("Cliente 1.");
            out_socket.flush();

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
