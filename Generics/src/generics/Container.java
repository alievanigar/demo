/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author nigar
 */
public class Container {
    private Object object;
    
    public Container(Object object){
          this.object = object;
            }
    
    public Object doItAndReturn(){
      System.out.println("I did shomething");
      return this;
    }
}
