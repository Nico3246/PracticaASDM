package practica_2025_26;

import java.util.ArrayList;

public interface I_Agregado_Personajes {
    
    void agregar(Personaje personaje);
    void recorrer();
    ArrayList<Personaje> existePersonaje(String nombre);//devuelve true si existe un personaje
}
