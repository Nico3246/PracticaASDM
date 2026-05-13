package practica_2025_26;
import java.util.ArrayList;
import java.util.List;

public abstract class PersonajeBase implements Personaje {
    protected String nombre;
    protected int nivel;
    protected String armas;
    protected String tipo;
    protected double precio;

    
    public PersonajeBase(String nombre) 
    {
        this.nombre = nombre;
        this.nivel = 1;
        this.armas="Hacha de piedra";
        this.precio=1;
    }
    
    
    
    public PersonajeBase(String nombre, int nivel,String armas, double precio)
    {
        this.nombre = nombre;
        this.nivel = nivel;
        this.armas=armas;
        this.precio=precio;
    }

    
    public String getArmas() {
        if(armas ==null)
            return "";
        
        return armas;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    } 

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setArmas(String armas) {
        this.armas = armas;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
        
 

    @Override
    public void subirNivel() {
        nivel++;
    }

    @Override
     public String getNombre() {
        return nombre;
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre: " + nombre + ", Nivel: " + nivel + ", Armas: " + armas + ", Tipo: " + tipo + ", Habilidad: " + gethab() + " Precio: " + getPrecio());
    }    
   

}
