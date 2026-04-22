package practica_2025_26;

public class Arquero extends PersonajeBase {
    
    private int puntería;
    
    public Arquero (String nombre, int punteria) {
        super(nombre);
        this.puntería=punteria;
        this.tipo="Arquero";
    }
    
    public Arquero (String nombre, int punteria, int nivel,String armas, double precio) {
        super(nombre,nivel,armas, precio);
        this.puntería=punteria;
        this.tipo="Arquero";
    }
}
