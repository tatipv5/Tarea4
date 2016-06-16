/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import hilos.Lock;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import modelo.ArrayDistritos;
import modelo.Distrito;
import modelo.Persona;
import static sun.misc.GThreadHelper.lock;

/**
 *
 * @author tati
 */
public class Leer {

    private BufferedReader buffer;
    private FileReader reader;
    private ArrayList<ObjetoLugar> provincias = new ArrayList<>();
    private ArrayList<ObjetoLugar> canton = new ArrayList<>();
    private ArrayDistritos listD = ArrayDistritos.getInstance();

    public void open(File path) throws FileNotFoundException {
        reader = new FileReader(path);
        buffer = new BufferedReader(reader);
    }

    public void close() throws IOException {
        buffer.close();
        reader.close();
    }

    private Persona readLine() throws IOException {
        String text = buffer.readLine();
        if (text != null) {

            String vector[] = text.split(",");
            String ced = vector[0];
            String codElec = vector[1];
            String genero = vector[2];

            return new Persona(ced, codElec, genero.charAt(0), "", "", "", "", "");
        } else {
            return null;
        }
    }

//    public void read(int numHilo) throws IOException, Exception {
//        final int I = 10;
//        int j = 0;
//        for (int i = 0; i < numHilo; i++) {
//            buffer.readLine();
//        }
//
//        Persona pers = readLine();
//        j++;
//
//        while (pers != null) {
//            if (j > I) {
//                pers = null;
//            } else {
//                Distrito dist = listD.buscarPersona(pers.getCodElec());
//                if (dist != null) {
//                    String provincia = dist.getProvincia();
//                    String cantons = dist.getCanton();
//                    existeProvincia(provincia, pers.getGenero());
//                    existeCanton(cantons, pers.getGenero());
//                }
//                pers = readLine();
//                j++;
//            }
//        }
//        for (int i = 0; i < 60; i++) {
//            buffer.readLine();
//        }
//    }
    public void read(Lock lock) throws IOException, Exception {
        lock.lock();
        Persona pers = readLine();
        while (pers != null) {
            Distrito dist = listD.buscarPersona(pers.getCodElec());
            if (dist != null) {
                String provincia = dist.getProvincia();
                String cantons = dist.getCanton();
                existeProvincia(provincia, pers.getGenero());
                existeCanton(cantons, pers.getGenero());
            }
            pers = readLine();
        }
        lock.unlock();
    }

    public synchronized void existeProvincia(String name, char genero) {
        boolean encontrado = false;
        for (int i = 0; i < provincias.size(); i++) {
            if (canton.get(i) != null && name.equalsIgnoreCase(provincias.get(i).getNombre())) {
                encontrado = true;
                if (genero == '2') {
                    provincias.get(i).aumentarF();
                } else {
                    provincias.get(i).aumentarM();
                }
            }
        }

        if (!encontrado) {
            ObjetoLugar obj = new ObjetoLugar(name);
            if (genero == '1') {
                obj.aumentarF();
            } else {
                obj.aumentarM();
            }
            provincias.add(obj);
        }
    }

    public synchronized void existeCanton(String name, char genero) {
        boolean encontrado = false;
        for (int i = 0; i < canton.size(); i++) {

            if (canton.get(i) != null && name.equalsIgnoreCase(canton.get(i).getNombre())) {
                encontrado = true;
                if (genero == 'f') {
                    canton.get(i).aumentarF();
                } else {
                    canton.get(i).aumentarF();
                }
            }
        }

        if (!encontrado) {
            ObjetoLugar obj = new ObjetoLugar(name);
            if (genero == 'f') {
                obj.aumentarF();
            } else {
                obj.aumentarF();
            }
            canton.add(obj);
        }
    }

    public String crearStringProvincias() {
        String text = "";
        for (ObjetoLugar provincia : provincias) {
            if (provincia != null) {
                text += provincia.toString();
            }

        }
        return text;
    }

    public String crearStringCanton() {
        String text = "";
        for (ObjetoLugar canton : canton) {
            if (canton != null) {
                text += canton.toString() + "\n";
            }
        }
        return text;
    }

    private class ObjetoLugar {

        private String nombre;
        private int Fem = 0, Masc = 0;

        public ObjetoLugar(String nombre) {
            this.nombre = nombre;

        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getFem() {
            return Fem;
        }

        public void aumentarF() {
            this.Fem++;
        }

        public int getMasc() {
            return Masc;
        }

        public void aumentarM() {
            this.Masc++;
        }

        @Override
        public String toString() {
            return "ObjetoLugar{" + "nombre=" + nombre + ", Fem=" + Fem + ", Masc=" + Masc + '}';
        }

    }
}//fin clase
