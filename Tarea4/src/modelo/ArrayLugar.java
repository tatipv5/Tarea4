/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author tati
 */
public class ArrayLugar {
    private ArrayList<Lugar> array = new ArrayList<>();
    private static ArrayLugar instancia = new ArrayLugar();

    private ArrayLugar() {

    }

    public static ArrayLugar getInstance() {
        return instancia;
    }

   public Lugar buscarLugar(String nombre){
       for (int i = 0; i < array.size(); i++) {
          if(array.get(i)!=null && array.get(i).getNombre().equals(nombre)){
             return array.get(i);
          }
           
       }
       return null;
   }

    public synchronized void agregar(Lugar e) {
        if (array != null) {
            array.add(e);
        }
    }
}
