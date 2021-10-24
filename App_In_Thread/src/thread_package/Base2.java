/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread_package;

/**
 *
 * @author nigar
 */
public class Base2 {
    private static int a=0;
    public static int getA(){
        return a;
    }
    public synchronized static void incA(){
        a++;
        } }
