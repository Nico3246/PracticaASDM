
package practica_2025_26;

/**
 *
 * es un creador concretodo del patron FactoryMethos
 * se encarga de crear objetos de tipo Mago
 */
public class CreadorMago extends Creador{
    private String nombre;
    private int nMagia;
    private int nivel;
    private String armas;
    private double precio;
    
    private Agregado_Personajes a;
    private Personaje p;
    
    public CreadorMago (String n, int m)
    {
        nombre=n;
        nMagia=m;
    }

    public CreadorMago(String nombre, int nMagia, int nivel, String armas, double precio) {
        this.nombre = nombre;
        this.nMagia = nMagia;
        this.nivel = nivel;
        this.armas = armas;
        this.precio = precio;
    }
    
    @Override
    public Personaje factory_Method()
    {   
        return new Mago(nombre, nMagia, nivel, armas, precio);
    }
    
}
