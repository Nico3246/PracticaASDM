
package practica_2025_26;


/*
*classe que representa la hoja dentro del patron composite
*/
public class MiembroEjercito extends Componente{
    
    private Personaje personaje;

    public MiembroEjercito(Personaje personaje) {
        this.personaje = personaje;
    }

    public Personaje getPersonaje() {
        return personaje;
    }
    
    

    @Override
    public boolean agregaPersonaje(Componente p) {
        return false;
    }

    @Override
    public boolean suprimePersonaje(Componente p) {
        return false;
    }

    @Override
    public void mostrarEjercito() {
        personaje.mostrar();
    }
    
}
