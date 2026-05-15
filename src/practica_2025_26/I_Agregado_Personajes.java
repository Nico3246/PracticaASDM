package practica_2025_26;

import java.util.ArrayList;

//actua como el agregado en el patron Iterator
public interface I_Agregado_Personajes {
    
    void agregar(Personaje personaje);
    void eliminar(Personaje p);
    void recorrer();
    public int getNumPersonajes();
    IteratorPersonajes crearIterador();//recorre como cola
    IteratorPersonajes crearIterador2();//recorre como pila
    IteratorPersonajes crearIterador3(int tipoOrden);//recorre ordenando ascendentemente
    IteratorPersonajes crearIterador4(int tipoOrden);//recorre ordenando descendentemente
    ArrayList<Personaje> existePersonaje(String nombre);//devuelve true si existe un personaje
    
    //para el patron observer
    void agregarObservador(Personaje observador);
    void eliminarObservador(Personaje observador);
    void notificarObservadores(Personaje p);
    void notificarObservadores(Personaje p, Ejercito e);
    void muerePersonaje(Personaje p, Ejercito e);
}
