package practica_2025_26;

public class Guerrero extends PersonajeBase {
    
    private int fuerza;
    
    public Guerrero(String nombre, int fuerza) {
        super(nombre);
        this.fuerza=fuerza;
        this.tipo="Guerrero";
    }
    
    public Guerrero(String nombre, int fuerza, int nivel,String armas, double precio) {
        super(nombre,nivel,armas, precio);
        this.fuerza=fuerza;
        this.tipo="Guerrero";
    }
}
