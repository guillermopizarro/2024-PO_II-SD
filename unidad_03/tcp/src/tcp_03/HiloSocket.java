package tcp_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


class HiloSocket extends Thread {

    Socket socket;

    public HiloSocket(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            // I/O Buffers

            // Entrada
            InputStreamReader in = new InputStreamReader(this.socket.getInputStream());
            BufferedReader in_socket = new BufferedReader( in );

            // Salida
            OutputStreamWriter out = new OutputStreamWriter(this.socket.getOutputStream());
            PrintWriter out_socket = new PrintWriter( out );

            Scanner teclado = new Scanner( System.in );

            String input = "";
            String output = "";
            
            while ((input = in_socket.readLine()) != null) { 
                System.out.println(input);

                if (input.equals("hola")) {
                    output = teclado.nextLine();
                } else if (input.equals("hora")) {
                    output = (new Date()).toString();
                } else if (input.equals("adios")) {
                    output = "¡Que te vaya bien!";
                    out_socket.println(output);
                    out_socket.flush();
                    break;
                }
                out_socket.println(output);
                out_socket.flush();
            }

            this.socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
