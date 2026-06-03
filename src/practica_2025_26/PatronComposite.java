/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nicolás
 */
public class PatronComposite {
    
    
    private Scanner scanner;
    private Scanner scanner2;
    private I_Agregado_Personajes personajes;
    private ArrayList<Ejercito> ejercitosCreados;

    public PatronComposite(Scanner scanner, Scanner scanner2, I_Agregado_Personajes personajes, ArrayList<Ejercito> ejercitosCreados) {
        this.scanner = scanner;
        this.scanner2 = scanner2;
        this.personajes = personajes;
        this.ejercitosCreados = ejercitosCreados;
    }
    
    
    
    
     /*Metodo unitilazo en el case 3, permite crear un ejercito.
    *devuelve un ejercito para que pueda anadirse como hijo dentro de otro
    */
     public Ejercito CrearEjercitos() {
        System.out.print("Introduce el nombre del ejercito: ");
        String nombreEjercito = scanner2.nextLine();

        while (existeEjercito(nombreEjercito)) {
            System.out.println("Ya existe un ejercito con ese nombre");
            System.out.print("Introduce el nombre del ejercito: ");
            nombreEjercito = scanner2.nextLine();
        }

        Ejercito nuevo = new Ejercito(nombreEjercito);
        ejercitosCreados.add(nuevo);

        int opc = 0;

        do {
            System.out.println("1. Anadir un ejercito al ejercito");
            System.out.println("2. Anadir miembros al ejercito");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opcion: ");
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("1. Crear un nuevo ejercito");
                    System.out.println("2. Anadir un ejercito existente");
                    System.out.println("3. Volver");
                    System.out.print("Selecciona una opcion: ");

                    int opc2 = scanner.nextInt();

                    switch (opc2) {
                        case 1:
                            Ejercito hijo = CrearEjercitos();
                            nuevo.agregaPersonaje(hijo);
                            System.out.println("Ejercito anadido");
                            break;

                        case 2:
                            Ejercito hijo2 = SeleccionarEjercitoExistente(nuevo);

                            if (hijo2 != null) {
                                nuevo.agregaPersonaje(hijo2);
                                System.out.println("Ejercito anadido");
                            }
                            break;

                        case 3:
                            System.out.println("Volviendo...");
                            break;

                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }

                    break;

                case 2:
                    anadirPersonajesEjercito(nuevo);
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (opc != 3);

        return nuevo;
    }


    /*
     * Metodo utilizado en el case 3 para anadir personajes a un ejercito.
     */
    public void anadirPersonajesEjercito(Ejercito ejercito) {
        Creador miFabricaObjetos;
        Personaje p = null;

        System.out.println("Selecciona un personaje: ");
        System.out.println("1. Arquero");
        System.out.println("2. Guerrero");
        System.out.println("3. Mago");
        System.out.print("Elige una opcion: ");

        int personaje = scanner.nextInt();

        System.out.print("Cuantos personajes desea crear?: ");
        int n = scanner.nextInt();

        System.out.print("Introduce el nombre: ");
        String nombre = scanner2.nextLine();

        System.out.print("Introduce el nivel: ");
        int nivel = scanner.nextInt();

        System.out.print("Introduce las armas: ");
        String armas = scanner2.nextLine();

        System.out.print("Introduce el precio: ");
        double precio = scanner.nextDouble();

        switch (personaje) {
            case 1:
                System.out.print("Introduce la punteria: ");
                int punteria = scanner.nextInt();

                miFabricaObjetos = new CreadorArquero(nombre, punteria, nivel, armas, precio);
                p = miFabricaObjetos.factory_Method();
                break;

            case 2:
                System.out.print("Introduce la fuerza: ");
                int fuerza = scanner.nextInt();

                miFabricaObjetos = new CreadorGuerrero(nombre, fuerza, nivel, armas, precio);
                p = miFabricaObjetos.factory_Method();
                break;

            case 3:
                System.out.print("Introduce el nivel de magia: ");
                int nMagia = scanner.nextInt();

                miFabricaObjetos = new CreadorMago(nombre, nMagia, nivel, armas, precio);
                p = miFabricaObjetos.factory_Method();
                break;

            default:
                System.out.println("Opcion no valida");
                return;
        }

        for (int i = 0; i < n; i++) {
            Personaje clon = p.clonar();
            personajes.agregar(clon);
            ejercito.agregaPersonaje(new MiembroEjercito(clon));
        }

        System.out.println("Personajes anadidos al ejercito");
    }


    // Muestra los ejercitos creados previamente y permite anadirlos al ejercito actual.
    public Ejercito SeleccionarEjercitoExistente(Ejercito actual) {
        ArrayList<Ejercito> disponibles = new ArrayList<>();

        for (Ejercito e : ejercitosCreados) {
            if (e != actual && !e.contieneEjercito(actual)) {
                disponibles.add(e);
            }
        }

        if (disponibles.isEmpty()) {
            System.out.println("No hay ejercitos disponibles para anadir");
            return null;
        }

        System.out.println("Ejercitos disponibles:");

        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println(i + ". " + disponibles.get(i).getNombreEjercito());
        }

        System.out.print("Selecciona una opcion: ");
        int opc = scanner.nextInt();

        if (opc < 0 || opc >= disponibles.size()) {
            System.out.println("Opcion no valida");
            return null;
        }

        return disponibles.get(opc);
    }


    // Comprueba si ya existe un ejercito con ese nombre.
    public boolean existeEjercito(String nombre) {
        for (Ejercito e : ejercitosCreados) {
            if (e.getNombreEjercito().equalsIgnoreCase(nombre)) {
                return true;
            }
        }

        return false;
    }
}
