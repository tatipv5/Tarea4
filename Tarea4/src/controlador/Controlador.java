/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import archivos.Escritor;
import archivos.Leer;
import archivos.LeerDistElec;
import hilos.Hilo;
import hilos.Lock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
   private LeerDistElec leerD;
   private Leer leer;
   private Escritor escritor;
    
    public Controlador(Lock lock, LeerDistElec leerD, Leer leer, Escritor escritor) {
        this.lock = lock;
        this.leerD = leerD;
        this.leer = leer;
        this.escritor = escritor;
    }

    public void iniciarHilos(File file) {
       
            hilo1 = new Hilo(lock, "Hilo1", 0, file, this, leer);
            hilo2 = new Hilo(lock, "Hilo2", 10, file, this, leer);
            hilo3 = new Hilo(lock, "Hilo3", 20, file, this, leer);
            hilo4 = new Hilo(lock, "Hilo4", 30, file, this, leer);
            hilo5 = new Hilo(lock, "Hilo5", 40, file, this, leer);
            hilo6 = new Hilo(lock, "Hilo6", 50, file, this, leer);
            
            hilo1.start();
            hilo2.start();
            hilo3.start();
            hilo4.start();
            hilo5.start();
            hilo6.start();
        try {
            //            int contador2 = 1;
//            while (contador< 6) {
////                contador2++;
////                if(contador2 == 1) {
////                System.out.println("Esperando...");
////                }
//            }
hilo1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void aumentarContador(Thread t) {
        System.out.println(t.getName()+"aumento");
        contador++;
    }
    
    public void leerDistrito(File file) throws IOException{
        leerD.open(file);
        leerD.read();
        leerD.close();
    }
    
    public void crearArchivo(String filePath) throws FileNotFoundException  {
        String provincias = leer.crearStringProvincias();
        String canton = leer.crearStringCanton();
        escritor.with_obj_in_file_xml(filePath, provincias);
        escritor.with_obj_in_file_xml(filePath, canton);
    }
}
