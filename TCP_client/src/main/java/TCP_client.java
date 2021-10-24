
import java.io.DataOutputStream;
import java.io.OutputStream;
import static java.lang.ProcessBuilder.Redirect.from;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javafx.beans.binding.Bindings.select;
import jdk.nashorn.internal.ir.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nigar
 */
public class TCP_client {
    public static void main(String[] args) throws Exception {
        Socket socket1 = new Socket("localhost",6785);
        OutputStream os = socket1.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        os.write("Socket yeni melumat gonderdi".getBytes());
        socket1.close();        
    }
    
public static void foo() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "12345";
        Connection c = DriverManager.getConnection(url, username, password);
        java.sql.Statement stmt = c.createStatement();//bu bizim d bile app arasindaki qayiqdi
stmt.execute("select *from user");//qayiqda bu text gedir ve execute olunur
ResultSet rs = stmt.getResultSet();//execute olunan melumat geri appa qayidib istifade olunur
while(rs.next()){
    int id  = rs.getInt("id");
    String name = rs.getString("name");
    String surname = rs.getString("username");
    String email = rs.getString("email");
    String phone = rs.getString("phone");
    
    System.out.println("id = "+id);
    System.out.println("name = "+name);
    System.out.println("surname = "+surname);
    System.out.println("email = "+email);
    System.out.println("phone = "+phone);
    System.out.println("-------------------------------");
}
    }

    
}
