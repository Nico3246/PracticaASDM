
package practica_2025_26;

import java.util.ArrayList;
import java.util.Scanner;


public class PatronObserver {
    
    private Scanner scanner;
    private Scanner scanner2;
    private I_Agregado_Personajes personajes;
    private ArrayList<Ejercito> ejercitosCreados;

    public PatronObserver(Scanner scanner, Scanner scanner2, I_Agregado_Personajes personajes, ArrayList<Ejercito> ejercitosCreados) {
        this.scanner = scanner;
        this.scanner2 = scanner2;
        this.personajes = personajes;
        this.ejercitosCreados = ejercitosCreados;
    }

    
    public void muertePersonaje() {
        if (personajes.getNumPersonajes() == 0) {
            System.out.println("No hay personajes existentes");
            return;
        }

        IteratorPersonajes iterador = personajes.crearIterador();

        java.util.Random r = new java.util.Random();
        int num = r.nextInt(personajes.getNumPersonajes());

        for (int i = 0; i < num && iterador.tieneSiguiente(); i++) {
            iterador.siguiente();
        }

        Personaje muerto = iterador.siguiente();

        Ejercito ejercitoMuerto = null;

        for (Ejercito e : ejercitosCreados) {
            if (e.pertenece(muerto)) {
                ejercitoMuerto = e;
            }
        }

        System.out.println("Ha muerto el personaje: " + muerto.getNombre());
        System.out.print("Notificar solo a los miembros de su ejercito? S/N: ");
        String opc = scanner2.nextLine();

        personajes.eliminar(muerto);

        if (ejercitoMuerto != null) {
            ejercitoMuerto.eliminarMiembro(muerto);
        }

        if (opc.equalsIgnoreCase("S")) {
            if (ejercitoMuerto == null) {
                System.out.println("El personaje no pertenece a ningun ejercito");
            } else {
                personajes.notificarObservadores(muerto, ejercitoMuerto);
            }
        } else {
            personajes.notificarObservadores(muerto);
        }
    }
}
