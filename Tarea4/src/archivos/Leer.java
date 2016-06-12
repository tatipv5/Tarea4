/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import modelo.Persona;

/**
 *
 * @author tati
 */
public class Leer {

    private BufferedReader buffer;

    public void open(String path) throws FileNotFoundException {
        buffer = new BufferedReader(new FileReader(path));
    }

    public void close() throws IOException {
        buffer.close();
    }

    private Persona readLine() throws IOException {
        String text = buffer.readLine();
        if (text != null) {
            String vector[] = text.split(",");
            int num1 = Integer.parseInt(vector[0]);
            int num2 = Integer.parseInt(vector[1]);
            int ced = Integer.parseInt(vector[2]);
            int num4 = Integer.parseInt(vector[3]);
            String nombre = vector[4];
            String apellido1 = vector[5];
            String apellido2 = vector[6];
            
            return new Persona(num1, num2, ced, num4, nombre, apellido1, apellido2);
        } else {
            return null;
        }
    }

    public void read(int numHilo) throws IOException {
        for (int i = 0; i < numHilo; i++) {
            buffer.readLine();
        }
    }

}//fin clase
