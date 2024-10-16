package tcp_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public final int PORT = 2020;

    public Server() {
        try {
            ServerSocket server_socket = new ServerSocket(PORT);
            System.out.println("Puerto 2020 se encuentra abierto.");

            Socket socket = server_socket.accept();

            // Comunicacion entre sockets - Del cliente al servidor
            InputStreamReader in = new InputStreamReader( socket.getInputStream() );
            BufferedReader in_socket = new BufferedReader(in);

            String mensaje = in_socket.readLine();
            System.out.println( "Cliente dice: " + mensaje );

            // Comunicacion entre sockets - Del servidor al cliente
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out_socket = new PrintWriter(out);

            out_socket.println("¡Bienvenido!");
            out_socket.flush();
            
            socket.close();
            server_socket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
