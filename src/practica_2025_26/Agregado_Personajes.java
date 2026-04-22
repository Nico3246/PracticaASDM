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
            System.out.println(personajes.get(i).getNombre());
    }
    
}
