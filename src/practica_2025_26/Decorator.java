/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

/**
 *
 * @author Nicolás
 */
public abstract class Decorator implements Personaje{
    protected Personaje personaje;

    public Decorator(Personaje personaje) {
        this.personaje = personaje;
    }
    
    protected String agregarArma(String arma) 
    {
        String armasActuales = personaje.getArmas();

        if (armasActuales == null || armasActuales.isEmpty()) 
        {
            return arma;
        }

        return armasActuales + ", " + arma;
    }

    @Override
    public void subirNivel() 
    {
        personaje.subirNivel();
    }

    @Override
    public String getNombre() 
    {
        return personaje.getNombre();
    }

    @Override
    public void setNombre(String nombre) 
    {
        personaje.setNombre(nombre);
    }

    @Override
    public String getTipo() 
    {
        return personaje.getTipo();
    }

    @Override
    public int gethab() 
    {
        return personaje.gethab();
    }

    @Override
    public void sethab(int hab) 
    {
        personaje.sethab(hab);
    }

    @Override
    public int getNivel() 
    {
        return personaje.getNivel();
    }

    @Override
    public void setNivel(int nivel) 
    {
        personaje.setNivel(nivel);
    }

    @Override
    public double getPrecio() 
    {
        return personaje.getPrecio();
    }

    @Override
    public void setPrecio(double precio) 
    {
        personaje.setPrecio(precio);
    }

    @Override
    public String getArmas() 
    {
        return personaje.getArmas();
    }

    @Override
    public void setArmas(String armas) 
    {
        personaje.setArmas(armas);
    }

    @Override
    public void mostrar() 
    {
        System.out.println("Nombre: " + getNombre() + ", Nivel: " + getNivel() + ", Armas: " + getArmas() + ", Tipo: " + getTipo()  + ", Habilidad: " + gethab() + " Precio: " + getPrecio());
    }

    @Override
    public Personaje clonar() 
    {
        return personaje.clonar();
    }

    @Override
    public void actualizar(Personaje fallecido, String nombreEjercito) 
    {
        personaje.actualizar(fallecido, nombreEjercito);
    }
}
