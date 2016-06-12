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
public class ArrayManager {

    private ArrayList<Persona> array = new ArrayList<>();
    private static ArrayManager instancia = new ArrayManager();

    private ArrayManager() {

    }

    public static ArrayManager getInstance() {
        return instancia;
    }

    public String devolverDiez(){
       String text="";
//        Iterator iter=array.iterator();
//        while(iter.hasNext()){
//           text+= iter.next()+"\n";
           for (int i = 0; i < 10; i++) {
           if(array.get(i)!=null)
               text+=array.get(i)+"\n";
        }
        
        return text;
    }
    public void agregar(Persona e) {
        if (array != null) {
            array.add(e);
        }

    }
}
