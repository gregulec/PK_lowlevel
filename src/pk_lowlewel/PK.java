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


public class PK {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    static Buffer buffer = new Buffer();
    public static void main(String[] args) throws InterruptedException {
        Producer p1 = new Producer("P1");
        Producer p2 = new Producer("P2");
        Producer p3 = new Producer("P3");
        Consumer c1 = new Consumer("C1");
        Consumer c2 = new Consumer("C2");
        Consumer c3 = new Consumer("C3");
                
        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
        
        p1.join();
        p2.join();
        p3.join();
        c1.join();
        c2.join();
        c3.join();
    }
    
}
