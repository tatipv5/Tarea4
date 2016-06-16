/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author tati
 */
public class ArrayDistritos {
    
    private ArrayList<Distrito> array = new ArrayList<>();
    private static ArrayDistritos instancia = new ArrayDistritos();

    private ArrayDistritos() {

    }

    public static ArrayDistritos getInstance() {
        return instancia;
    }

    public String devolverDiez() {
        String text = "";
//        Iterator iter=array.iterator();
//        while(iter.hasNext()){
//           text+= iter.next()+"\n";
        for (int i = 0; i < 120; i++) {
            if (array.get(i) != null) {
                text += array.get(i) + "\n";
            }
        }

        return text;
    }
    
    public Distrito buscarPersona(String num) throws Exception {
        for (Distrito dist : array) {
            if(dist != null && num.equalsIgnoreCase(dist.getCodElec())) {
                return dist;
            }
        }
        throw new Exception("No existe el codigo");
    }

    public synchronized void agregar(Distrito e) {
        if (array != null) {
            array.add(e);
        }

    }
    
}
