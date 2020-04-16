package laboratorio3;

/**
 * @author Emanuel Martínez Pinzón
 */
import laboratorio3.Carro;
import java.util.ArrayList;
import laboratorio3.Puesto;
import presentacion.Ventana;

public class Parqueadero {
    ArrayList<Puesto> Puesto;
    ArrayList<Carro> Carro;
    ArrayList<Moto> Moto;
    ArrayList<Bicicleta> Bicicleta;
    
    private int tarifaMinutoc = 75;
    private int tarifaMinutom = 20;
    private int tarifaMinutob = 10;
    private int tarifaFija =13000;
    private int totalRecaudado;
    
    int CantidadCarros;
    int CantidadMotos;
    int CantidadBicicletas;
    
    public Parqueadero(){
        this.Puesto = new ArrayList<Puesto>();
        this.Carro = new ArrayList<Carro>();
        this.Moto = new ArrayList<Moto>();
        this.Bicicleta = new ArrayList<Bicicleta>();
        this.crearPuestos();
        
        CantidadCarros = this.Carro.size();
        CantidadMotos = this.Moto.size();
        CantidadBicicletas = this.Bicicleta.size();
    }
    
    private void crearPuestos(){
        for(int i=0; i<25; i++){
            if(CantidadCarros < 12 ){
                this.Puesto.add(new Puesto(i+1));
            } else {
                Ventana.imp("No hay puestos para parquear más carros");
                return;
            }
            if(CantidadMotos < 8 ){
                this.Puesto.add(new Puesto(i+1));
            } else {
                Ventana.imp("No hay puestos para parquear más motos");
                return;
            }
            if(CantidadBicicletas < 6 ){
                this.Puesto.add(new Puesto(i+1));
            } else {
                Ventana.imp("No hay puestos para parquear más bicicletas");
                return;
            }
            
            }
            
    }
    
    //-----------------------REQUERIMIENTOS FUNCIONALES-----------------------//
    public String parquearCarro(String placa, String hora, String minuto){
        
        if(this.buscarCarro(placa) != null)
            return "El carro ya esta parqueado en un puesto";
        
        if(this.puestoVacioc()!=-1){
            Carro carro = new Carro(placa, hora, minuto);
            this.Puesto.get(this.puestoVacioc()).asignarPuesto(carro);
            this.Puesto.get(this.puestoVacioc()).setEstado("Ocupado");
            return "Carro parqueado con exito";
        }         
        return null;
        
   }
    public String retirarCarro(String placa, String hora, String minutos){
        String mensaje = "No se ha podido retirar el carro";
        
        int precio = this.calcularPrecioc(hora, minutos, this.buscarCarro(placa));
        
        for(int i=0; i<=this.Puesto.size(); i++)
            if(this.Puesto.get(i).getCarro()!= null && 
                    this.Puesto.get(i).getCarro().getPlaca().equalsIgnoreCase(placa)){
                this.Puesto.get(i).setCarro(null);
                this.Puesto.get(i).setEstado("Libre");
                return "Se ha retirado correctamente, debe pagar "+precio;
            }
                
        return mensaje;
    }
    
    public String parquearMoto(String Placam, String hora, String minuto){
        
        if(this.buscarMoto(Placam) != null)
            return "La moto ya esta parqueada en un puesto";
        
        if(this.puestoVaciom()!=-1){
            Moto moto = new Moto(Placam, hora, minuto);
            this.Puesto.get(this.puestoVaciom()).asignarPuesto(moto);
            this.Puesto.get(this.puestoVaciom()).setEstado("Ocupado");
            return "Moto parqueada con exito";
        }
        return null;
            
        
    }
    
    public String retirarMoto(String Placam, String hora, String minutos){
        String mensaje = "No se ha podido retirar la moto";
        
        int precio = this.calcularPreciom(hora, minutos, this.buscarMoto(Placam));
        
        for(int i=0; i<=this.Puesto.size(); i++)
            if(this.Puesto.get(i).getMoto()!= null && 
                    this.Puesto.get(i).getMoto().getPlacam().equalsIgnoreCase(Placam)){
                this.Puesto.get(i).setMoto(null);
                this.Puesto.get(i).setEstado("Libre");
                return "Se ha retirado correctamente, debe pagar "+precio;
            }
                
        return mensaje;
    }
    
    public String parquearBicicleta( String NUMERO, String hora, String minuto){
        
        if(this.buscarBicicleta(NUMERO) != null)
            return "La Bicicleta ya esta parqueada en un puesto";
        
        if(this.puestoVaciob()!=-1){
            Bicicleta bicicleta = new Bicicleta(NUMERO, hora, minuto);
            this.Puesto.get(this.puestoVaciob()).asignarPuesto(bicicleta);
            this.Puesto.get(this.puestoVaciob()).setEstado("Ocupado");
            return "Bicicleta parqueada con exito";
        }
        return null;
            
        
    }
    
    public String retirarBicicleta(String NUMERO, String hora, String minutos){
        String mensaje = "No se ha podido retirar la bicicleta";
        
        int precio = this.calcularPreciob(hora, minutos, this.buscarBicicleta(NUMERO));
        
        for(int i=0; i<=this.Puesto.size(); i++)
            if(this.Puesto.get(i).getBicicleta()!= null && 
                    this.Puesto.get(i).getBicicleta().getNUMERO().equalsIgnoreCase(NUMERO)){
                this.Puesto.get(i).setBicicleta(null);
                this.Puesto.get(i).setEstado("Libre");
                return "Se ha retirado correctamente, debe pagar "+precio;
            }
                
        return mensaje;
    }
    
    public String InfoPuestosLibres(){
        String libres = "";
        
        for(Puesto p: Puesto)
            if(p!=null && p.getEstado().equalsIgnoreCase("Libre"))
                libres += p.libreStringc()+"\n\n";
                
        return libres;
    }
    
    //----------------------REQUERIMIENTOS OPERACIONALES----------------------//
    public Carro buscarCarro(String placa){
        Carro carro = null;
        
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Ocupado") && 
                    p.getCarro().getPlaca().equalsIgnoreCase(placa))
                carro = p.getCarro();
        
        return carro;
    }
    
    public int puestoVacioc(){
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Libre"))
                return (p.getNumeroc()-1);
        
        return -1;
    }
    
        public Moto buscarMoto(String placa){
        Moto moto = null;
        
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Ocupado") && 
                    p.getCarro().getPlaca().equalsIgnoreCase(placa))
                moto = p.getMoto();
        
        return moto;
    }
        public int puestoVaciom(){
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Libre"))
                return (p.getNumerom()-1);
        
        return -1;
    }
    
        public Bicicleta buscarBicicleta(String NUMERO){
        Bicicleta bicicleta = null;
        
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Ocupado") && 
                    p.getBicicleta().getNUMERO().equalsIgnoreCase(NUMERO))
                bicicleta = p.getBicicleta();
        
        return bicicleta;
    }
    
    public int puestoVaciob(){
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Libre"))
                return (p.getNumerob()-1);
        
        return -1;
    }
    
    public int calcularPrecioc(String minutoSalida, String horaSalida, Carro carro){
        int costo = 0;
        
        //int cantHoras = Integer.parseInt(horaSalida)-Integer.parseInt(carro.getHora());
        int cantMinutos = Integer.parseInt(minutoSalida)-Integer.parseInt(carro.getMinuto());
        
        int costoHora = cantMinutos*this.getTarifaMinutoc()*60;
        int costoFijo = 0;
        
        if(cantMinutos>=10)
            costoFijo = this.getTarifaFija();
        
        costo = costoHora;
        
        this.setTotalRecaudado(this.getTotalRecaudado()+costoHora);
        
        return costo;
    }
    
    public int calcularPreciom( String minutoSalida,String horaSalida, Moto moto){
        int costo = 0;
        
        int cantHoras = Integer.parseInt(horaSalida)-Integer.parseInt(moto.getHora());
        int cantMinutos = Integer.parseInt(minutoSalida)-Integer.parseInt(moto.getMinuto());
        
        int costoHora = cantHoras*this.getTarifaMinutom()*60;
        int costoFijo = 0;
        
        if(cantHoras>=10)
            costoFijo = this.getTarifaFija();
        
        costo = costoHora;
        
        this.setTotalRecaudado(this.getTotalRecaudado()+costoHora+costoFijo);
        
        return costo;
    }
    
    public int calcularPreciob( String minutoSalida,String horaSalida, Bicicleta bicicleta){
        int costo = 0;
        
        int cantHoras = Integer.parseInt(horaSalida)-Integer.parseInt(bicicleta.getHora());
        int cantMinutos = Integer.parseInt(minutoSalida)-Integer.parseInt(bicicleta.getMinuto());
        
        int costoHora = cantMinutos*this.getTarifaMinutob();
        int costoFijo = 0;
        
        if(cantHoras>0)
            costoFijo = this.getTarifaFija();
        
        costo = costoHora;
        
        this.setTotalRecaudado(this.getTotalRecaudado()+costoHora);
        
        return costo;
    }

    public String concatenarPlacasCarro(){
        String carro = "";
        

        for(int i=0; i<this.Puesto.size();i++)
            if(this.Puesto.get(i).getEstado().equalsIgnoreCase("Ocupado"))
                carro += this.Puesto.get(i).getCarro().getPlaca()+"~";
        return carro;
    }
    
     public String concatenarPlacasMoto(){
        String moto = "";   

        for(int i=0; i<this.Puesto.size();i++)
            if(this.Puesto.get(i).getEstado().equalsIgnoreCase("Ocupado"))
                moto += this.Puesto.get(i).getMoto().getPlacam()+"~";
        return moto;
     }
        public String concatenarNumeroBici(){
        String bici = "";
        
        for(int i=0; i<this.Puesto.size();i++)
            if(this.Puesto.get(i).getEstado().equalsIgnoreCase("Ocupado"))
                bici += this.Puesto.get(i).getBicicleta().getNUMERO()+"~";
        return bici;
    }
    public String concatenarInfoCarros(){
        String info = "";
        
        for(Puesto p: Puesto)
            if(p.getEstado().equalsIgnoreCase("Ocupado"))
                info += p.toStringc()+"\n\n";
        
        return info;
    }
    public String concatenarInfoMotos(){
        String info = "";
        
        for(Puesto pm: Puesto)
            if(pm.getEstado().equalsIgnoreCase("Ocupado"))
                info += pm.toStringm()+"\n\n";
        
        return info;
    }
    public String concatenarInfoBicicletas(){
        String info = "";
        
        for(Puesto pb: Puesto)
            if(pb.getEstado().equalsIgnoreCase("Ocupado"))
                info += pb.toStringb()+"\n\n";
        
        return info;
    }
    
    //------------------------Getter's y Setter's-----------------------------//
    public int getTarifaMinutoc() {
        return tarifaMinutoc;
    }

    public void setTarifaMinutoc(int tarifaMinutoc) {
        this.tarifaMinutoc = tarifaMinutoc;
    }
    public int getTarifaMinutom() {
        return tarifaMinutom;
    }

    public void setTarifaMinutom(int tarifaMinutom) {
        this.tarifaMinutom = tarifaMinutom;
    }
    public int getTarifaMinutob() {
        return tarifaMinutob;
    }

    public void setTarifaMinutob(int tarifaMinutob) {
        this.tarifaMinutob = tarifaMinutob;
    }
    
    public int getTarifaFija() {
        return tarifaFija;
    }

    public void setTarifaFija(int tarifaFija) {
        this.tarifaFija = tarifaFija;
    }


    public int getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(int totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }
}

    
