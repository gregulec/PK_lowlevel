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
public class Consumer extends Thread{
    
    Consumer(String name) {
        super(name);
    }
    
    @Override
    public void run(){
        int i = 0;
        while (i<=99){
            System.out.println(getName()+" consumed: "+buffer.get());  
            i++;
        }       
    }

}
