
package practica_2025_26;

/*
*clase abstracta, representa la clase componente del patron composite
*/
public abstract class Componente {
    protected int n_elementos;
    
    public abstract boolean agregaPersonaje(Componente p);
    public abstract boolean suprimePersonaje(Componente p);
    public abstract void mostrarEjercito();
}
