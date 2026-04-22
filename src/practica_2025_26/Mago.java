package practica_2025_26;

public class Mago extends PersonajeBase {
    
    private int nivel_magia;
    
       
    public Mago(String nombre, int nivel_magia) {
        super(nombre);
        this.nivel_magia=nivel_magia;
        this.tipo="Mago";
    }
    
    public Mago(String nombre, int nivel_magia, int nivel,String armas, double precio) {
        super(nombre,nivel,armas, precio);
        this.nivel_magia=nivel_magia;
        this.tipo="Mago";
    }
}
