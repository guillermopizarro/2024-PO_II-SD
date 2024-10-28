package tcp_03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public final int PORT = 2020;

    public Server() {
        try {
            ServerSocket server_socket = new ServerSocket(PORT);
            System.out.println("Puerto 2020 se encuentra abierto.");

            Socket socket;

            while(true) {
                socket = server_socket.accept();
                System.out.println("Cliente conectado.");

                HiloSocket hilo = new HiloSocket(socket);
                hilo.start();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
