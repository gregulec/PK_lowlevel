/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk_lowlewel;

import static pk_lowlewel.PK.buffer;
/**
 *
 * @author Agnieszka
 */
public class Producer extends Thread{
  
    public Producer(String name) {
        super(name);
    }
    
    @Override
    public void run(){       
        int i = 101;
        while(i<=200){
           buffer.put(i); 
           i++;
       }
    }
}
