package practica_2025_26;

import java.util.ArrayList;

//actua como el agregado en el patron Iterator
public interface I_Agregado_Personajes {
    
    void agregar(Personaje personaje);
    void recorrer();
    IteratorPersonajes crearIterador();//recorre como cola
    IteratorPersonajes crearIterador2();//recorre como pila
    IteratorPersonajes crearIterador3(int tipoOrden);//recorre ordenando ascendentemente
    IteratorPersonajes crearIterador4(int tipoOrden);//recorre ordenando descendentemente
    ArrayList<Personaje> existePersonaje(String nombre);//devuelve true si existe un personaje
}
