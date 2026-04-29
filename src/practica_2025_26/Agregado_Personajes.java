package practica_2025_26;

import java.util.ArrayList;

public class Agregado_Personajes implements I_Agregado_Personajes{
        private ArrayList<Personaje> personajes;
        
        Agregado_Personajes(){
            personajes = new ArrayList<>();
        }
        
    @Override
    public void agregar(Personaje personaje) {
        personajes.add(personaje);
    }
     
    @Override
    public void recorrer(){
        for(int i=0;i<personajes.size();i++)
            System.out.println(" | Nombre: " + personajes.get(i).getNombre() + " | Nivel " + personajes.get(i).getNivel() + " | Tipo: " + personajes.get(i).getTipo() + " | Precio: " + personajes.get(i).getPrecio());
    }

    @Override
    public ArrayList<Personaje> existePersonaje(String nombre) {
        
        ArrayList<Personaje> existePersonaje = new ArrayList<>();
        
        for(Personaje aux :personajes)
        {
            if(aux.getNombre().trim().equalsIgnoreCase(nombre.trim()))
                existePersonaje.add(aux);
        }
        
        return existePersonaje;
      
    }
    
}
