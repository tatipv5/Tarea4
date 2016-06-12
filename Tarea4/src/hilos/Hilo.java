/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import archivos.Leer;
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

//    private final Lock lock;
    private final int id;
    private Leer leer;
    private File path;
    public Hilo( String name, int id, File path) {
        super(name);
//        this.lock = lock;
        this.id = id;
        this.path=path;
    }

    @Override
    public void run() {
       System.out.println("se ejecjuca el hilo "+super.getName()+" "+id);
        leer=new Leer();
        try {
            leer.open(path);
            leer.read(id);
            leer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
