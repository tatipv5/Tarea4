/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author tati
 */
public class Lugar {
    private String nombre; 
    private int Fem, Masc;

    public Lugar(String nombre) {
        this.nombre = nombre;
        this.Fem = Fem;
        this.Masc = Masc;
    
        
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

}
