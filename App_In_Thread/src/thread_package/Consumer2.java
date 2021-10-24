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
public class Consumer2 implements Runnable{   
    @Override
    public void run(){
        System.out.println("I am working");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        int a = Base2.getA();
        Base2.incA();
    }}
