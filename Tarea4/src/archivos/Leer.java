/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import modelo.ArrayManager;
import modelo.Persona;

/**
 *
 * @author tati
 */
public class Leer{

    private BufferedReader buffer;
    private FileReader reader;
    //Iterator iter;
//     private boolean finaliced;

    public void open(File path) throws FileNotFoundException {
        reader = new FileReader(path);
        buffer = new BufferedReader(reader);
//        iter = (Iterator) reader;
    }

    public void close() throws IOException {
        buffer.close();
        reader.close();
    }

    private Persona readLine() throws IOException {
        String text = buffer.readLine();
        if (text != null) {
            String vector[] = text.split(",");
            String ced =vector[0];

            String codElec =vector[1];
            String genero =vector[2];
             String caducidad =vector[3];
             String junta =vector[4];
            String nombre = vector[5];
            String apellido1 = vector[6];
            String apellido2 = vector[7];

            return new Persona(ced, codElec, genero.charAt(0), caducidad, junta, nombre, apellido1, apellido2);
        } else {
            return null;
        }
    }

    public void read(int numHilo) throws IOException {
        final int I = 10;
        int j = 1;
        for (int i = 0; i < numHilo; i++) {
//            if (iter.hasNext()) {
            buffer.readLine();
//            }
        }

//        while (iter.hasNext() && j <= I) {
        Persona pers = readLine();
        j++;
        while (pers != null && j <= I) {
            ArrayManager array = ArrayManager.getInstance();
            array.agregar(pers);
            pers = readLine();
            j++;
        }
        for (int i = 0; i < 60; i++) {
//                if (iter.hasNext()) {
            buffer.readLine();
//                }
        }
//    }
        if (j <= I) {
            pers = readLine();
            while (pers != null) {
                //array.agregar
                ArrayManager array = ArrayManager.getInstance();
                array.agregar(pers);
            }
        }

    }
}//fin clase
