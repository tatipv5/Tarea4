/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import hilos.Hilo;
import hilos.Lock;
import java.io.File;
import modelo.ArrayManager;

/**
 *
 * @author tati
 */
public class Controlador {

    private Hilo hilo1;
    private Hilo hilo2;
    private Hilo hilo3;
    private Hilo hilo4;
    private Hilo hilo5;
    private Hilo hilo6;
    private int contador = 0;
    private Lock lock;

    public Controlador(Lock lock) {
        this.lock = lock;
    }

    public void iniciarHilos(File file) {
        hilo1 = new Hilo(lock, "Hilo1", 0, file, this);
        hilo2 = new Hilo(lock, "Hilo2", 10, file, this);
        hilo3 = new Hilo(lock, "Hilo3", 20, file, this);
        hilo4 = new Hilo(lock, "Hilo4", 30, file, this);
        hilo5 = new Hilo(lock, "Hilo5", 40, file, this);
        hilo6 = new Hilo(lock, "Hilo6", 50, file, this);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        while (contador != 5) {
            //System.out.println("lololo");
        }
        lock.unlock();
        System.out.println(ArrayManager.getInstance().devolverDiez());
        
    }

    public void aumentarContador() {
        contador++;
    }
}
