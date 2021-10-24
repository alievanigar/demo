/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author nigar
 */
public class Generics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Container container = new Container(new User());
        doSomething(container);
    }
    public static void doSomething(Container container){
    User u = (User)container.doItAndReturn();
        System.out.println("u="+u);           
    }
}
