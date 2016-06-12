/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author tati
 */
public class Hilo extends Thread {

    private final Lock lock;
    private final int id;
    public Hilo(Lock lock, String name, int id) {
        super(name);
        this.lock = lock;
        this.id=id;
    }
    
    @Override
    public void run(){
        System.out.println("HILO");
        
    }

}
