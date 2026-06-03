
package practica_2025_26;

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
