
package practica_2025_26;

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
