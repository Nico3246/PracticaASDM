/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nicob
 */
public class FacadeJuego implements I_FacadeJuego{

    private Scanner scanner;
    private Scanner scanner2;
    
    private I_Agregado_Personajes personajes;
    private ArrayList<Ejercito> ejercitosCreados;
    
    private PatronFactoryMethod patronFactoryMethod;
    private PatronPrototype patronPrototype;
    private PatronComposite patronComposite;
    private PatronObserver patronObserver;
    private PatronIterator patronIterator;
    private PatronDecorator patronDecorator;
    
    
    
    public FacadeJuego()
    {
        scanner = new Scanner(System.in);
        scanner2 = new Scanner(System.in);
        
        personajes = new Agregado_Personajes();
        ejercitosCreados = new ArrayList<>();
        
        patronFactoryMethod = new PatronFactoryMethod(scanner, scanner2, personajes);
        patronIterator = new PatronIterator(scanner, scanner2, personajes);
        patronPrototype = new PatronPrototype(scanner, scanner2, personajes, patronIterator);
        patronComposite = new PatronComposite(scanner, scanner2, personajes, ejercitosCreados);
        patronObserver = new PatronObserver(scanner, scanner2, personajes, ejercitosCreados);
        patronDecorator = new PatronDecorator(scanner, scanner2, personajes, patronIterator);

        patronFactoryMethod.cargarPersonajesIniciales();
    }
    
    
    @Override
    public void iniciarJuego() {
        int opcion=0;
        do {
            for (int i = 0; i < 50; ++i) {
                System.out.println();
            }

            System.out.println("\nMenú Principal:");
            System.out.println("1. Crear personaje(Factory Method)");
            System.out.println("2. Clonar personaje(Prototype)");
            System.out.println("3. Crear ejercito (Composite)");
            System.out.println("4. Muerte personaje (Observer");
            System.out.println("5. Listar personaje (Iterator)");
            System.out.println("6. Subir nivel (Iterator)");
            System.out.println("7. Añadir armas (Decorator)");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            for (int i = 0; i < 50; ++i) {
                System.out.println();
            }

            switch (opcion) {
                /*Patron utilizado: Factory Method
                *El usuario elige el tipo de personaje(Arquero, guerrero o mago)
                *e introduce los datos del personaje
                *se utiliza un creadore concreto para instanciar cada personaje
                 */
                case 1:

                    patronFactoryMethod.CrearPersonajes();

                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                    
                /*Patron utilizado: Prototype
                 * El usuario selecciona un personaje ya creado y el sistema genera una copia
                 * de ese objeto mediante el metodo clonar()
                 */
                case 2:
                    
                    patronPrototype.ClonarPersonaje();
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                    
                /*Patron utilizado: Composite
                *permite crear un ejercito que puede estar formado por personajes u otros
                *ejercitos
                 */
                case 3:
                    Ejercito ejercito = patronComposite.CrearEjercitos();
                    ejercito.mostrarEjercito();
                    scanner2.nextLine();
                    break;

                case 4:
                    patronObserver.muertePersonaje();
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                case 5:
                    patronIterator.listarPersonajes();
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                case 6:
                    patronIterator.subirNivel();
                    System.out.println("Presina para continuar");
                    scanner2.nextLine();
                    
                    break;
                case 7:
                    patronDecorator.anadirArmas();
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                    
                case 8:
                    System.out.println("Saliendo...");
                    break;
                
                default:
                    System.out.println("Opción no válida.");
                    System.out.println("Presina para continuar");
                    scanner2.nextLine();
            }

        } while (opcion != 8);
    }
    
   
    
    
    
    
    
}
