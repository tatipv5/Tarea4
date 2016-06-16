/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import modelo.ArrayDistritos;
import modelo.Distrito;

/**
 *
 * @author tati
 */
public class LeerDistElec {

    private BufferedReader buffer;
    private FileReader reader;

    public void open(File path) throws FileNotFoundException {
        reader = new FileReader(path);
        buffer = new BufferedReader(reader);
    }

    public void close() throws IOException {
        buffer.close();
        reader.close();
    }

    private Distrito readLine() throws IOException {
        String text = buffer.readLine();
        if (text != null) {
            String vector[] = text.split(",");
            String codElec = vector[0];
            String provincia = vector[1];
            String canton = vector[2];

            return new Distrito(codElec, provincia, canton);
        } else {
            return null;
        }
    }

    public void read() throws IOException {
        Distrito dist = readLine();
        while (dist != null) {
            ArrayDistritos array = ArrayDistritos.getInstance();
            array.agregar(dist);
            dist = readLine();
        }
    }

}//fin clase
