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

    public int gethab() {
        return fuerza;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void sethab(int fuerza) {
        this.fuerza = fuerza;
    }
   
    
    /*
     * Implementacion del patron prototype
     * Devuelve un nuevo guerrero con el mismo estado que el objeto actual.
     */
    public Personaje clonar() {
        Personaje p = new Guerrero(getNombre(),gethab(),getNivel(), getArmas(), getPrecio());
        
        return p;
    }
}
