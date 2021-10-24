/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionlar;

import java.util.HashMap;

/**
 *
 * @author nigar
 */
public class Collectionlar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Studen s = new Studen("Nigar", "Aliyeva");
         Studen s1 = new Studen("Nigar", "Aliyeva");
        HashMap<Studen, Integer> map = new HashMap<>();
        map.put(s, Integer.SIZE);
        map.put(s1, Integer.SIZE);
        
        System.out.println(map);
      }
}
