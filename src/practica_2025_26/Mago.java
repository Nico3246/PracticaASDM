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

    public int gethab() {
        return nivel_magia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }
    
    
    public void sethab(int nivel_magia) {
        this.nivel_magia = nivel_magia;
    }
    
    
    /*
     * Implementacion del patron prototype
     * Devuelve un nuevo mago con el mismo estado que el objeto actual.
     */
    public Personaje clonar() {
        Personaje p = new Mago(getNombre(),gethab(),getNivel(), getArmas(), getPrecio());
        
        return p;
    }
    
    
}
