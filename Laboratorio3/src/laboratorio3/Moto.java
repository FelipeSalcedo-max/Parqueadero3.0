/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio3;

/**
 *
 * @author RetailAdmin
 */
public class Moto {
    private String Placam;
    private String hora;
    private String minuto;

    public Moto(String Placam, String hora, String minuto){
        this.Placam = Placam;
        this.hora = hora;
        this.minuto = minuto;
    }
    
    public String getPlacam() {
        return Placam;
    }

    public void setPlacam(String Placam) {
        this.Placam = Placam;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }
}
