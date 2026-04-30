
package practica_2025_26;

/**
 *
 * es un creador concretodo del patron FactoryMethos
 * se encarga de crear objetos de tipo Guerrero
 */
public class CreadorGuerrero extends Creador{
    private String nombre;
    private int fuerza;
    private int nivel;
    private String armas;
    private double precio;
    
    private Agregado_Personajes a;
    private Personaje p;
    
    public CreadorGuerrero(String n, int f)
    {
        nombre=n;
        fuerza=f;
    }

    public CreadorGuerrero(String nombre, int fuerza, int nivel, String armas, double precio) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.nivel = nivel;
        this.armas = armas;
        this.precio = precio;
    }
    
    
    
    @Override
    public Personaje factory_Method()
    {   
        return new Guerrero(nombre, fuerza, nivel, armas, precio);
    } 
    
}
