/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import archivos.Leer;
import controlador.Controlador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tati
 */
public class Hilo extends Thread {

    private final Lock lock;
    private final int id;
    private Leer leer;
    private File path;
    private Controlador controlador;

    public Hilo(Lock lock, String name, int id, File path, Controlador controlador, Leer leer) {
        super(name);
        this.lock = lock;
        this.id = id;
        this.path = path;
        this.controlador = controlador;
        this.leer=leer;
    }

    @Override
    public void run() {
        System.out.println("se ejecuta el hilo " + super.getName() + " " + id);
        try {
            leer.open(path);
            leer.read( lock);
            leer.close();
            System.out.println("termino de leer el hilo " + super.getName() + " " + id);
            controlador.aumentarContador(this);
            //this.lock.lock(); 
           //wait();
        } catch (FileNotFoundException ex) {
            System.out.println("se despcho el hilo"+super.getName() + " " + id+"fnfe");
            //Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
             System.out.println("se despicho el hilo"+super.getName() + " " + id+"ioe");
            //Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
       
        } catch (Exception ex) {
         //   Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("se despicho el hilo"+super.getName() + " " + id+"e");
        }
    }

}
