
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nigar
 */
public class TCP_SERVER1 {
     public static void main(String[] args) throws Exception {
        ServerSocket ourFirstServerSocket = new ServerSocket(6785);
        while (true){
            System.out.println("Yeni socket ve ya bashqa cur desek yeni mushteri uchun gozleyirem");
            Socket connection = ourFirstServerSocket.accept();
             System.out.println("Yeni socket daxil oldu");
             InputStream is = connection.getInputStream();
             InputStreamReader reader = new InputStreamReader(is);
             BufferedReader bReader = new BufferedReader(reader);
             String messageFromClient = bReader.readLine();
             System.out.println("Yeni socket(mushterinin) gonderdiyi melumat: "+messageFromClient);
            
        }
    }
}
