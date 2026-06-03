/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

/**
 *
 * @author Nicolás
 */
//decorador concreto3
public class Arco extends Decorator{

    public Arco(Personaje personaje) {
        super(personaje);
    }

    @Override
    public String getArmas() {
        return agregarArma("Arco");
    }

    @Override
    public Personaje clonar() {
        return new Arco(personaje.clonar());
    }
}
