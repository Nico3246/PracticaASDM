
package practica_2025_26;

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
