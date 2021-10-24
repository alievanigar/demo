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
public class Consumer implements Runnable{
   private String name;
   public Consumer(String name){
      this.name = name; 
   }
             
    @Override
    public void run(){
        while(true){
    int lastindex = Base.list.size()-1;
    if(lastindex>0){
      String s =  Base.list.remove(lastindex);
        System.out.println(name+"s="+s);
    }  } }
    
}
