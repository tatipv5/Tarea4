/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import hilos.Hilo;
import java.io.File;

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

public void iniciarHilos(File file) {
    hilo1 = new Hilo("Hilo1", 0, file);
    hilo2 = new Hilo("Hilo2", 10, file);
    hilo3 = new Hilo("Hilo3", 20, file);
    hilo4 = new Hilo("Hilo4", 30, file);
    hilo5 = new Hilo("Hilo5", 40, file);
    hilo6 = new Hilo("Hilo6", 50, file);
    
    hilo1.start();
    hilo2.start();
    hilo3.start();
    hilo4.start();
    hilo5.start();
    hilo6.start();
    
}
}
