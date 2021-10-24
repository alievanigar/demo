/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server_simple;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nigar
 */
public class TCP_server_simple {

    /**
     * @param args the command line arguments
     */
         public static void main(String[] args) throws Exception {
       readAsByte();
    }
         public static void readAsByte() throws Exception{
            ServerSocket ourFirstServerSocket = new ServerSocket(6785);
        while (true){
            System.out.println("Yeni socket ve ya bashqa cur desek yeni mushteri uchun gozleyirem");
            Socket connection = ourFirstServerSocket.accept();
            DataInputStream dis = new DataInputStream(connection.getInputStream());
            byte[] arr = readAsMessage(dis);
            fileutility.FileUtility.writeBytes( "C:\\Users\\nigar\\Desktop\\NigartestTCP.png",arr);
        }

}
         
           public static byte[] readAsMessage(DataInputStream dis) throws Exception{
               int msglng =  dis.readInt();
               byte[] msg = new byte[msglng];
               dis.readFully(msg);
           return msg;
           }
            public static void readAsSring() throws Exception{
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
