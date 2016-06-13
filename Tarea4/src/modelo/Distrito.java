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
public class Distrito {
    String codElec, provincia, canton,distrito;

    public Distrito(String codElec, String provincia, String canton, String distrito) {
        this.codElec = codElec;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
    }

    public String getCodElec() {
        return codElec;
    }

    public void setCodElec(String codElec) {
        this.codElec = codElec;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public String toString() {
        return "Distrito{" + "codElec=" + codElec + ", provincia=" + provincia + ", canton=" + canton + ", distrito=" + distrito + '}';
    }
    
    
}
