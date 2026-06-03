
package practica_2025_26;

import java.util.ArrayList;


//funciona como una pila
public class IteradorPersonajesConcreto2 implements IteratorPersonajes{
    
    private ArrayList<Personaje> l_personajes;
    private int posicion;

    public IteradorPersonajesConcreto2(ArrayList<Personaje> l_personajes) {
        this.l_personajes = l_personajes;
        this.posicion = l_personajes.size()-1;
    }

    @Override
    public Personaje siguiente() {
        if(tieneSiguiente())
        {
            return l_personajes.get(posicion--);
        }
        System.out.println("No quedan mas personajes");
        return null;
    }

    @Override
    public Personaje anterior() {
        if(posicion>0)
            return l_personajes.get(++posicion);
        
        System.out.println("No hay ningun personaje anterior");
        return null;
    }

    @Override
    public boolean tieneSiguiente() {
        if(posicion>=0)
            return true;
        
        return false;
    }
    
}
