/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_client_simple;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author nigar
 */
public class TCP_client_simple {

    /**
     * @param args the command line arguments
     */
          public static void main(String[] args) throws Exception {
        Socket socket1 = new Socket("localhost",6785);
        OutputStream os = socket1.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
       // os.write("Socket yeni melumat gonderdi".getBytes());
        
        byte[] bytes = fileutility.FileUtility.readyBytes("C:\\Users\\nigar\\Desktop\\Nigar ADNA\\Pictures\\qəbələ\\20180511_173716.jpg");
        dos.writeInt(bytes.length);
        dos.write(bytes);
        socket1.close();        
    
    }
    
}
