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
public class Persona {

    private int num1, num2, ced, nun4;
    private String nombre, apellido1, apellido2;

    public Persona(int num1, int num2, int ced, int nun4, String nombre, String apellido1, String apellido2) {
        this.num1 = num1;
        this.num2 = num2;
        this.ced = ced;
        this.nun4 = nun4;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getCed() {
        return ced;
    }

    public void setCed(int ced) {
        this.ced = ced;
    }

    public int getNun4() {
        return nun4;
    }

    public void setNun4(int nun4) {
        this.nun4 = nun4;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @Override
    public String toString() {
        return "Persona{" + "num1=" + num1 + ", num2=" + num2 + ", ced=" + ced + ", nun4=" + nun4 + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + '}';
    }
}
