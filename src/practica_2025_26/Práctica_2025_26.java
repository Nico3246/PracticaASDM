package practica_2025_26;

import java.util.*;

public class Práctica_2025_26 {

    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner2 = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        Personaje p;
        Creador miFabricaObjetos = null;

        I_Agregado_Personajes personajes = new Agregado_Personajes();

        miFabricaObjetos = new CreadorGuerrero("Conan", 2);
        Personaje conan = miFabricaObjetos.factory_Method();

        miFabricaObjetos = new CreadorGuerrero("Freyja ", 3);
        Personaje freyja = miFabricaObjetos.factory_Method();

        miFabricaObjetos = new CreadorGuerrero("Kratos ", 2);
        Personaje kratos = miFabricaObjetos.factory_Method();

        miFabricaObjetos = new CreadorArquero("Aloy ", 4);
        Personaje aloy = miFabricaObjetos.factory_Method();

        miFabricaObjetos = new CreadorArquero("Hanzo  ", 3);
        Personaje hanzo = miFabricaObjetos.factory_Method();

        miFabricaObjetos = new CreadorMago("Yennefer", 3);
        Personaje yennefer = miFabricaObjetos.factory_Method();

        miFabricaObjetos = new CreadorMago("Solomon", 3);
        Personaje solomon = miFabricaObjetos.factory_Method();

        personajes.agregar(conan);
        personajes.agregar(freyja);
        personajes.agregar(kratos);
        personajes.agregar(aloy);
        personajes.agregar(hanzo);
        personajes.agregar(yennefer);
        personajes.agregar(solomon);

        System.out.println("ACLARACIONES\n"
                + "Esta práctica esta pensada para ir añadiendo patrones de diseño "
                + "sobre una simulación de un video juego, cada opción del"
                + " menú principal está pensada para añadir un patrón de diseño"
                + " y solo uno\n"
                + "Por tanto, debemos ir realizando las opciones de cada menú e"
                + " ignorando las que están etiquetadas como (futuras)\n"
                + "\nPulsa para continuar");
        scanner2.nextLine();
        System.out.println("El programa principal no es definitivo se irá ampliando"
                + " durante la práctica\n"
                + "\nPulsa para continuar");
        scanner2.nextLine();

        System.out.println("ACLARACIONES\n"
                + "Los requisitos de cada opción se explican en el propio menú "
                + " y el patrón a utilizar"
                + "\nPulsa para continuar");
        scanner2.nextLine();

        System.out.println("ACLARACIONES\n"
                + "Por simplicidad se han añadido algunos personajes que se incluyen en la lista, dicha lista se puede "
                + " modificar y añadir nuevos personajes\n, o cambiar su declaración como se estime oportuno"
                + "\nPulsa para continuar");
        scanner2.nextLine();

        System.out.println("ACLARACIONES\n"
                + "Se puede modificar el código y añadir clases con el objetivo "
                + "de usar los patrones de diseño.\n"
                + "Sería de agradecer que pusieráis comentarios y aclaraciones "
                + "escritas de los patrones que utilizáis en cada opción"
                + "\nPulsa para continuar");

        scanner2.nextLine();

        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }

        do {
            for (int i = 0; i < 50; ++i) {
                System.out.println();
            }

            System.out.println("\nMenú Principal:");
            System.out.println("1. Crear personaje(Factory Method)");
            System.out.println("2. Clonar personaje(futura)");
            System.out.println("3. Subir nivel de personaje (futura)");
            System.out.println("4. Listar personajes(futura)");
            System.out.println("5. Añade armas a personaje(futura)");

            System.out.println("6. Salir");
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

                    CrearPersonajes(scanner, scanner2, personajes);

                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                case 2:
                    System.out.println("Clonaremos un personaje ya creado "
                            + " modificando los datos que sean necesarios "
                            + "y se añadirá a la lista");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                case 3:
                    System.out.println("Subiremos el nivel de uno de los personajes, tendremos que elegir "
                            + "a uno de los añadidos por vosotros con anterioridad o de los ya existentes"
                            + " inicialmente");
                    System.out.println("Indicaremos al resto que se ha subido de nivel");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                case 4:
                    System.out.println("Se mostrarán los distintos personajes"
                            + " se podrían incluir opociones de muestreo, ejemplo solo los "
                            + "magos o por orden de mayor nivel, etc. "
                            + "Con un par bastaría. ");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                case 5:
                    System.out.println("Se añadirán armas a alguno de "
                            + "los personajes existentes añadiéndolas "
                            + "al String armas que tiene cada personaje ");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    System.out.println("Presina para continuar");
                    scanner2.nextLine();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    System.out.println("Presina para continuar");
                    scanner2.nextLine();
            }

        } while (opcion != 6);
    }

    /*Metodo utilizado en el case 1 para crear los personajes
    *utilizando el patron Factory Method
     */
    public static void CrearPersonajes(Scanner scanner, Scanner scanner2, I_Agregado_Personajes personajes) 
    {
        Creador miFabricaObjetos;
        Personaje p;

        System.out.println("Selecciona un personaje: ");
        System.out.println("1.Arquero ");
        System.out.println("2.Guerrero");
        System.out.println("3.Mago");
        int personaje = scanner.nextInt();

        System.out.print("Introduce el nombre: ");
        String nombre = scanner2.nextLine();

        System.out.print("Introduce el nivel: ");
        int nivel = scanner.nextInt();

        System.out.print("Introduce las armas: ");
        String armas = scanner2.nextLine();

        System.out.print("Introduce el precio: ");
        double precio = scanner.nextInt();

        switch (personaje) 
        {
            case 1:
                int punteria;

                System.out.print("Introduce la punteria: ");
                punteria = scanner.nextInt();

                miFabricaObjetos = new CreadorArquero(nombre, punteria, nivel, armas, precio);
                p = miFabricaObjetos.factory_Method();

                personajes.agregar(p);

                break;
            case 2:
                int fuerza;
                System.out.print("Introduce la fuerza: ");
                fuerza = scanner.nextInt();

                miFabricaObjetos = new CreadorGuerrero(nombre, fuerza, nivel, armas, precio);
                p = miFabricaObjetos.factory_Method();

                personajes.agregar(p);

                break;

            case 3:
                int nMagia;

                System.out.print("Introduce el nivel de magia: ");
                nMagia = scanner.nextInt();

                miFabricaObjetos = new CreadorMago(nombre, nMagia, nivel, armas, precio);
                p = miFabricaObjetos.factory_Method();

                personajes.agregar(p);

                break;

        }

        System.out.println("Se ha creado un nuevo personaje: " + nombre);
        personajes.recorrer();

    }
}
