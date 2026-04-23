package practica_2025_26;


public interface I_Agregado_Personajes {
    
    void agregar(Personaje personaje);
    void recorrer();
    Personaje existePersonaje(String nombre);//devuelve true si existe un personaje
}
