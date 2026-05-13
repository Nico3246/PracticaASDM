package practica_2025_26;

import java.util.ArrayList;

//actua como el agregado en el patron Iterator
public interface I_Agregado_Personajes {
    
    void agregar(Personaje personaje);
    void recorrer();
    IteratorPersonajes crearIterador();
    IteratorPersonajes crearIterador2();
    ArrayList<Personaje> existePersonaje(String nombre);//devuelve true si existe un personaje
}
