/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author nigar
 */
public class FileUtility {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public static byte[] readyBytes(String filename){
File file = new File(filename);
try(FileInputStream fileInputStream = new FileInputStream(file);){
byte[] bytesArray = new byte[(int) file.length()];
fileInputStream.read(bytesArray);
return bytesArray;}
catch(Exception ex){
ex.printStackTrace();
return null;}
finally{
System.out.println("method ishelese de error da verse bura ishleyecek");}
}

public static void writeBytes(String filename, byte[] data) throws Exception {
FileOutputStream foo = new FileOutputStream(filename);
foo.write(data);
foo.flush();
foo.close();}


}
