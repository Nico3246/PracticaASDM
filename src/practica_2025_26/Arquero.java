package practica_2025_26;

public class Arquero extends PersonajeBase  {
    
    private int punteria;
    
    public Arquero (String nombre, int punteria) {
        super(nombre);
        this.punteria=punteria;
        this.tipo="Arquero";
    }
    
    public Arquero (String nombre, int punteria, int nivel,String armas, double precio) {
        super(nombre,nivel,armas, precio);
        this.punteria=punteria;
        this.tipo="Arquero";
    }

    public int gethab() {
        return punteria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

   
    public void sethab(int hab) {
        this.punteria = punteria;
    }
    
    
    /*
     * Implementación del patron prototype
     * Devuelve un nuevo arquero con el mismo estado que el objeto actual.
     */
    @Override
    public Personaje clonar() {
        Personaje p = new Arquero(getNombre(),gethab(),getNivel(), getArmas(), getPrecio());
        
        return p;
    }

    

    

  


}
