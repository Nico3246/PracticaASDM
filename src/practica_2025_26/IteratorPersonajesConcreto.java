
package practica_2025_26;

//es el iterador concreto, funcioanra como una cola

import java.util.ArrayList;

public class IteratorPersonajesConcreto implements IteratorPersonajes{
    
    private ArrayList<Personaje> l_personajes;
    private int posicion;

    public IteratorPersonajesConcreto(ArrayList<Personaje> l_personajes) {
        this.l_personajes = l_personajes;
        this.posicion = 0;
    }

    @Override
    public Personaje siguiente() {
        if(tieneSiguiente())
        {
            return l_personajes.get(posicion++);
        }
        System.out.println("No quedan mas personajes");
        return null;
    }

    @Override
    public Personaje anterior() {
        if(posicion>0)
            return l_personajes.get(posicion--);
        
        System.out.println("No hay ningun personaje anterior");
        return null;
    }

    @Override
    public boolean tieneSiguiente() {
        if(posicion<l_personajes.size())
            return true;
        
        return false;
    }
    
    
}
