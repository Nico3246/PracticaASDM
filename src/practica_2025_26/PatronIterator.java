
package practica_2025_26;

import java.util.ArrayList;
import java.util.Scanner;


public class PatronIterator {
    
    private Scanner scanner;
    private Scanner scanner2;
    private I_Agregado_Personajes personajes;

    
    public PatronIterator(Scanner scanner, Scanner scanner2, I_Agregado_Personajes personajes) {
        this.scanner = scanner;
        this.scanner2 = scanner2;
        this.personajes = personajes;
    }
    
    
    public void subirNivel() {
        IteratorPersonajes iteradorMostrar = personajes.crearIterador2();

        System.out.println("Personajes existentes");
        System.out.println("-----------------------------------");

        while (iteradorMostrar.tieneSiguiente()) {
            Personaje p = iteradorMostrar.siguiente();
            p.mostrar();
        }

        System.out.print("Introduce el nombre del personaje: ");
        String nombre = scanner2.nextLine();

        ArrayList<Personaje> encontrados = new ArrayList<>();

        IteratorPersonajes iteradorBuscar = personajes.crearIterador();

        while (iteradorBuscar.tieneSiguiente()) {
            Personaje p = iteradorBuscar.siguiente();

            if (p.getNombre().equalsIgnoreCase(nombre)) {
                encontrados.add(p);
            }
        }

        Personaje elegido;

        if (encontrados.isEmpty()) {
            System.out.println("No existe ningun personaje con ese nombre");
            return;
        }

        if (encontrados.size() > 1) {
            System.out.println("Hay varios personajes con ese nombre");

            for (int i = 0; i < encontrados.size(); i++) {
                Personaje p = encontrados.get(i);

                System.out.println(
                        i + ". " + p.getNombre()
                        + " | Nivel: " + p.getNivel()
                        + " | Tipo: " + p.getTipo()
                        + " | Armas: " + p.getArmas()
                        + " | Precio: " + p.getPrecio()
                );
            }

            System.out.print("Elige una opcion: ");
            int opc = scanner.nextInt();

            if (opc < 0 || opc >= encontrados.size()) {
                System.out.println("Opcion no valida");
                return;
            }

            elegido = encontrados.get(opc);
        } else {
            elegido = encontrados.get(0);
        }

        elegido.subirNivel();

        IteratorPersonajes iteradorMostrar2 = personajes.crearIterador();

        System.out.println("Personajes actualizados");
        System.out.println("-----------------------------------");

        while (iteradorMostrar2.tieneSiguiente()) {
            Personaje p = iteradorMostrar2.siguiente();
            p.mostrar();
        }
    }


    public void listarPersonajes() {
        int opc = 0;

        do {
            System.out.println("Filtros");
            System.out.println("------------------------------------");
            System.out.println("1. Mostrar todos los personajes");
            System.out.println("2. Filtrar por tipo");
            System.out.println("3. Filtrar por nivel minimo");
            System.out.println("4. Filtrar por rango de nivel");
            System.out.println("5. Filtrar por precio maximo");
            System.out.println("6. Filtrar por arma");
            System.out.println("7. Filtrar por habilidad minima");
            System.out.println("8. Buscar por nombre");
            System.out.println("9. Mostrar ordenado");
            System.out.println("10. Salir");
            System.out.print("Elige una opcion: ");

            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    mostrarPersonajes();
                    break;

                case 2:
                    filtroTipo();
                    break;

                case 3:
                    filtroNivelMinimo();
                    break;

                case 4:
                    filtroRangoNivel();
                    break;

                case 5:
                    filtroPrecio();
                    break;

                case 6:
                    filtroArmas();
                    break;

                case 7:
                    filtroNivelHabilidad();
                    break;

                case 8:
                    filtroNombre();
                    break;

                case 9:
                    mostrarOrdenado();
                    break;

                case 10:
                    System.out.println("Volviendo...");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (opc != 10);
    }


    public void mostrarPersonajes() {
        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado = false;

        System.out.println("Personajes existentes");
        System.out.println("-----------------------------------");

        while (iterador.tieneSiguiente()) {
            Personaje p = iterador.siguiente();
            p.mostrar();
            encontrado = true;
        }

        if (!encontrado) {
            System.out.println("No hay personajes");
        }
    }


    public void filtroTipo() {
        System.out.print("Introduce el tipo de personaje, Arquero, Mago o Guerrero: ");
        String tipo = scanner2.nextLine();

        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado = false;

        while (iterador.tieneSiguiente()) {
            Personaje p = iterador.siguiente();

            if (p.getTipo().equalsIgnoreCase(tipo)) {
                p.mostrar();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay personajes de ese tipo");
        }
    }


    public void filtroNivelMinimo() {
        System.out.print("Introduce el nivel minimo: ");
        int nivel = scanner.nextInt();

        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado = false;

        while (iterador.tieneSiguiente()) {
            Personaje p = iterador.siguiente();

            if (p.getNivel() >= nivel) {
                p.mostrar();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay personajes con ese nivel minimo");
        }
    }


    public void filtroRangoNivel() {
        System.out.print("Introduce el nivel minimo: ");
        int nivelMin = scanner.nextInt();

        System.out.print("Introduce el nivel maximo: ");
        int nivelMax = scanner.nextInt();

        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado = false;

        while (iterador.tieneSiguiente()) {
            Personaje p = iterador.siguiente();

            if (p.getNivel() >= nivelMin && p.getNivel() <= nivelMax) {
                p.mostrar();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay personajes en ese rango de nivel");
        }
    }


    public void filtroPrecio() {
        System.out.print("Introduce el precio maximo: ");
        double precio = scanner.nextDouble();

        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado = false;

        while (iterador.tieneSiguiente()) {
            Personaje p = iterador.siguiente();

            if (p.getPrecio() <= precio) {
                p.mostrar();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay personajes con ese precio maximo");
        }
    }


    public void filtroArmas() {
        System.out.print("Introduce el arma: ");
        String arma = scanner2.nextLine();

        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado = false;

        while (iterador.tieneSiguiente()) {
            Personaje p = iterador.siguiente();

            if (p.getArmas() != null && p.getArmas().toLowerCase().contains(arma.toLowerCase())) {
                p.mostrar();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay personajes con esa arma");
        }
    }


    public void filtroNivelHabilidad() {
        System.out.print("Introduce el nivel minimo de habilidad: ");
        int nivelH = scanner.nextInt();

        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado = false;

        while (iterador.tieneSiguiente()) {
            Personaje p = iterador.siguiente();

            if (p.gethab() >= nivelH) {
                p.mostrar();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay personajes con esa habilidad minima");
        }
    }


    public void filtroNombre() {
        System.out.print("Introduce el nombre: ");
        String nombre = scanner2.nextLine();

        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado = false;

        while (iterador.tieneSiguiente()) {
            Personaje p = iterador.siguiente();

            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.mostrar();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay personajes con ese nombre");
        }
    }


    public void mostrarOrdenado() {
        System.out.println("Ordenar por:");
        System.out.println("1. Nivel");
        System.out.println("2. Precio");
        System.out.print("Selecciona una opcion: ");

        int opc1 = scanner.nextInt();

        System.out.println("Orden:");
        System.out.println("1. Ascendente");
        System.out.println("2. Descendente");
        System.out.print("Selecciona una opcion: ");

        int opc2 = scanner.nextInt();

        IteratorPersonajes iterador;

        if (opc2 == 1) {
            iterador = personajes.crearIterador3(opc1);
        } else {
            iterador = personajes.crearIterador4(opc1);
        }

        boolean encontrado = false;

        while (iterador.tieneSiguiente()) {
            Personaje p = iterador.siguiente();
            p.mostrar();
            encontrado = true;
        }

        if (!encontrado) {
            System.out.println("No hay personajes");
        }
    }


}
