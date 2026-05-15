
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
    
    
    //se utiliza para comprpobar si alguno de los hijos del EJercito es el que se le pasa
    public boolean contieneEjercito(Ejercito e)
    {
        if(this == e)
            return true;
        
        for(Componente c : miembros)
        {
            if (c instanceof Ejercito)
            {
                Ejercito hijo = (Ejercito) c;
                
                if (hijo.contieneEjercito(e))
                    return true;
            }
        }
        
        return false;
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
    
    public boolean pertenece(Personaje p)
    {
        for (Componente c : miembros) 
        {
            if (c instanceof MiembroEjercito) 
            {
                MiembroEjercito miembro = (MiembroEjercito) c;

                if (miembro.getPersonaje() == p) 
                    return true;
            }

            if (c instanceof Ejercito) 
            {
                Ejercito hijo = (Ejercito) c;

                if (hijo.pertenece(p))
                    return true;
                
            }
        }
        
        return false;
    }
    
    
    public boolean eliminarMiembro(Personaje p)
    {
        boolean eliminado=false;
        
        for(int i=0; i<miembros.size();i++)
        {
            Componente c = miembros.get(i);
            
            if(c instanceof MiembroEjercito)
            {
                MiembroEjercito miembro = (MiembroEjercito) c;
                
                if(miembro.getPersonaje() == p)
                {
                    miembros.remove(i);
                    eliminado = true;
                }
            }
            
            if(c instanceof Ejercito)
            {
                Ejercito hijo = (Ejercito) c;
                
                if(hijo.eliminarMiembro(p))
                    eliminado=true;
            }
        }
        
        return eliminado;
    }
    
}
