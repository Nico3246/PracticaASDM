/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

/**
 *
 * @author Nicolás
 */
//decorador concreto2
public class Baculo extends Decorator 
{

    public Baculo(Personaje personaje) {
        super(personaje);
    }

    @Override
    public String getArmas() {
        return agregarArma("Baculo");
    }

    @Override
    public Personaje clonar() {
        return new Baculo(personaje.clonar());
    }
}
