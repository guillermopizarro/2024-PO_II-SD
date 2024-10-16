package tcp_02;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

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
            OutputStreamWriter out = new OutputStreamWriter(this.socket.getOutputStream());
            PrintWriter out_socket = new PrintWriter( out );
            out_socket.println( (new Date()).toString() );
            out_socket.flush();
    
            this.socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
