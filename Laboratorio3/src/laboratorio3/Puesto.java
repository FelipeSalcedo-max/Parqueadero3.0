package laboratorio3;

import laboratorio3.Carro;

/**
 * @author Emanuel Martínez Pinzón
 */

public class Puesto {
    private int numeroc;
    private int numerom;
    private int numerob;
    private String estado;
    private Carro carro;
    private Moto moto;
    private Bicicleta bicicleta;
    
    public Puesto(int numeroc){
        this.numeroc = numeroc;
        this.estado = "Libre";
    
    }
    public void asignarPuesto(Carro carro){
        this.carro = carro;
    }
    public int getNumeroc() {
        return numeroc;
    }
    public void setNumero(int numeroc) {
        this.numeroc = numeroc;
    }
    public void asignarPuesto(Moto moto){
        this.moto = moto;
    }
    public int getNumerom() {
        return numerom;
    }
    public void setNumerom(int numerom) {
        this.numerom = numerom;
    }
    public void asignarPuesto(Bicicleta bicicleta){
        this.bicicleta = bicicleta;
    }
    public int getNumerob() {
        return numerob;
    }

    public void setNumerob(int numerob) {
        this.numerob = numerob;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Carro getCarro() {
        return carro;
    }
    public Moto getMoto() {
        return moto;
    }
    public Bicicleta getBicicleta() {
        return bicicleta;
    }
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    public void setMoto(Moto moto) {
        this.moto = moto;
    }
    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }    
    public String libreStringc(){
        return "Puesto: "+this.getNumeroc()
            +"\nEstado: "+this.getEstado();
    }
     public String libreStringm(){
        return "Puesto: "+this.getNumerom()
            +"\nEstado: "+this.getEstado();
    }
      public String libreStringb(){
        return "Puesto: "+this.getNumerob()
            +"\nEstado: "+this.getEstado();
    }
    
    public String toStringc(){
        return "Puesto: "+this.getNumeroc()
            +"\nEstado: "+this.getEstado()
            +"\nPlaca del carro: "+this.getCarro().getPlaca()
            +"\nHora: "+this.getCarro().getHora()+":"+this.getCarro().getMinuto();

}
    public String toStringm(){
        return "Puesto: "+this.getNumerom()
            +"\nEstado: "+this.getEstado()
            +"\nPlaca de la moto: "+this.getMoto().getPlacam()
            +"\nHora: "+this.getMoto().getHora()+":"+this.getMoto().getMinuto();
    }
    public String toStringb(){
        return "Puesto: "+this.getNumerob()
            +"\nEstado: "+this.getEstado()
            +"\nNumero de la bicicleta: "+this.getBicicleta().getNUMERO()
            +"\nHora: "+this.getBicicleta().getHora()+":"+this.getBicicleta().getMinuto();

}
}
