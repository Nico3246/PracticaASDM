/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

import java.util.ArrayList;

/**
 *
 * @author Nicolás
 */

//este iterador recorre la lista en un orden ascendente determinado segun el tipo que se le pase
public class IteradorPersonajesConcreto3 implements IteratorPersonajes{
    private ArrayList<Personaje> personajesOrdenados;
    private int posicion;

    public IteradorPersonajesConcreto3(ArrayList<Personaje> personajes, int tipoOrden) {
        personajesOrdenados=new ArrayList<>();
        
        for(int i=0; i<personajes.size();i++)
        {
            personajesOrdenados.add(personajes.get(i));
        }
        
        ordenar(tipoOrden);//utiliza la ordenacion por insercion para ordenar segun el tipo q se le pase (1.nivel,2.precio)
        this.posicion = 0;
    }
    
    private void ordenar(int tipoOrden)
    {
         for(int i=1; i< personajesOrdenados.size();i++)
         {
             Personaje actual = personajesOrdenados.get(i);
             int j = i - 1;
             
             while(j >= 0 && intercambia(personajesOrdenados.get(j),actual,tipoOrden)>0)
             {
                 personajesOrdenados.set(j + 1, personajesOrdenados.get(j));
                 j--;
             }
             
             personajesOrdenados.set(j + 1, actual);
         }
    }
    
    private int intercambia(Personaje p1,Personaje p2, int tipoOrden)
    {
        if(tipoOrden == 1)
        {
            if(p1.getNivel() > p2.getNivel())
                return 1;
            else if(p1.getNivel() < p2.getNivel())
                return -1;
            else
                return 0;
        }
        
        if(tipoOrden == 2)
        {
            if(p1.getPrecio()> p2.getPrecio())
                return 1;
            else if(p1.getPrecio() < p2.getPrecio())
                return -1;
            else
                return 0;
        }
        
        return 0;
        
    }

    @Override
    public Personaje siguiente() {
        if(tieneSiguiente())
        {
            Personaje p= personajesOrdenados.get(posicion);
            posicion++;
            return p;
        }
        
        
        System.out.println("No quedan mas personajes");
        return null;
        
    }

    @Override
    public Personaje anterior() {
        if(posicion > 0)
        {
            posicion--;
            return personajesOrdenados.get(posicion);
        }
        
        System.out.println("No hay ningun personaje anterior");
        return null;
    }

    @Override
    public boolean tieneSiguiente() {
        return posicion < personajesOrdenados.size();
        
    }
    
    
}
