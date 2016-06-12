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
public class ArrayManager {
    private ArrayList<Persona> array=new ArrayList<>();
    private static ArrayManager instancia=new ArrayManager(); 
    private ArrayManager() {
        
    }
    public ArrayManager getInstancia(){
        return instancia;
    }
    
    public void agregar(Persona e){
    if(array!=null){
        array.add(e);
    }
 
    }
}
