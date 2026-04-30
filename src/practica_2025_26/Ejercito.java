
package practica_2025_26;

import java.util.ArrayList;

/*
*clase que representa el compuesto dentro del patron composite
*/
public class Ejercito extends Componente {

    private String nombre;
    private ArrayList<Componente> miembros = new ArrayList<>();

    public Ejercito(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEjercito() {
        return nombre;
    }
    
    
    
    
    @Override
    public boolean agregaPersonaje(Componente p) {
        return miembros.add(p);
    }

    @Override
    public boolean suprimePersonaje(Componente p) {
        return miembros.remove(p);
    }

    @Override
    public void mostrarEjercito() {
        System.out.println("---------------------" + nombre + "---------------------");
        
        for (Componente c : miembros)
            c.mostrarEjercito();
    }
    
}
