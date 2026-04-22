/**
 * es un creador concretodo del patron FactoryMethos
 * se encarga de crear objetos de tipo Arquero
 */
package practica_2025_26;


public class CreadorArquero extends Creador{
    private String nombre;
    private int punteria;
    private int nivel;
    private String armas;
    private double precio;
    
    private Agregado_Personajes a;
    
    public CreadorArquero (String n, int p)
    {
        nombre=n;
        punteria=p;
    }
    
    public CreadorArquero (String n, int p, int nivel,String armas, double precio)
    {
        nombre=n;
        punteria=p;
        this.nivel=nivel;
        this.armas=armas;
        this.precio=precio;
    }
    
    @Override
    public Personaje factory_Method()
    {
        return new Arquero(nombre, punteria, nivel, armas, precio);
    }
}
