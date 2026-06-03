/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

/**
 *
 * @author Nicolás
 */
//decorador concreto 1
public class Escudo extends Decorator{

    public Escudo(Personaje personaje) {
        super(personaje);
    }

    @Override
    public String getArmas() {
        return agregarArma("Escudo");
    }

    @Override
    public Personaje clonar() {
        return new Escudo(personaje.clonar());
    }
    
}
