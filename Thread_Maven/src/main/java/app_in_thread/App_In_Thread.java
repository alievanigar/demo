/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_in_thread;

import thread_package.Consumer;
import thread_package.Producer;

/**
 *
 * @author nigar
 */
public class App_In_Thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread p1 = new Thread(new Producer());
        Thread p2 = new Thread(new Producer());
        
        Thread m1 = new Thread(new Consumer("Nigar"));
        Thread m2 = new Thread(new Consumer("Mehriban"));
        Thread m3 = new Thread(new Consumer("Esmer"));
        Thread m4 = new Thread(new Consumer("Aynur"));
        Thread m5 = new Thread(new Consumer("Ayten"));
        
        p1.start();
        p2.start();
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m5.start();
        
        
        
    }
    
}
