package tcp_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public final String HOST = "127.0.0.1";
    public final int PORT = 2020;

    public Client() {
        try {
            Socket socket = new Socket(HOST, PORT);
            System.out.println("Conexion exitosa al servidor.");
            
            // I/O Buffers
            // Entrada
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader in_socket = new BufferedReader( in );

            // Salida
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out_socket = new PrintWriter( out );

            Scanner teclado = new Scanner( System.in );

            String input = "";
            String output = "";

            while(true) {
                while ((input = teclado.nextLine()) != null) { 
                    System.out.println("Cliente dice " + input);
                    out_socket.println(input);
                    out_socket.flush();
                    break;
                }

                while ((input = in_socket.readLine()) != null) { 
                    System.out.println("Servidor dice: " + input);
                    break;
                }

                if (input.equals("adios")) {
                    break;
                }
            }

            socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}

