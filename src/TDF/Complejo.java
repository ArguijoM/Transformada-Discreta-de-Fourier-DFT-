/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDF;

/**
 *
 * @author manuel
 */
public class Complejo {
    double real;
    double imaginario;

    public Complejo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginario(double imaginario) {
        this.imaginario = imaginario;
    }

    public double getReal() {
        return real;
    }

    public double getImaginario() {
        return imaginario;
    }
    
    
}
