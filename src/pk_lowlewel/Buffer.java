/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk_lowlewel;
/**
 *
 * @author Agnieszka
 */
public class Buffer implements IBuffer{
    private final int[] buffer = new int[10];
    private int in = 0; 
    private static int indexPut=0;
    private static int indexGet=0;
    final Object producers = new Object();
    final Object consumers = new Object();
    
    @Override
    public void put(int v) {
        synchronized(producers){
            while (this.in>=10){
                try {
                    System.out.println("bufor pełny");
                    producers.wait();
                } catch (InterruptedException ex) { System.out.println("interrupted"); }
            }
            
            synchronized (this)    {
                buffer[indexPut] = v;                
                in++;
                indexPut = (indexPut +1) % 10;
            }
        }
        
        synchronized(consumers){
            consumers.notifyAll();
        }  
    }

    @Override
    public int get() {
        int temp;
        synchronized(consumers){
            while (this.in<=0){
                try {
                    System.out.println("bufor pusty");
                    consumers.wait();
                } catch (InterruptedException ex) { System.out.println("interrupted"); }
            }
            
            synchronized(this){
                temp = buffer[indexGet];
                indexGet = (indexGet +1) % 10;
                in--;
            }
        }
        
        synchronized(producers){
            producers.notifyAll();
        }
        return temp;
    }
}
