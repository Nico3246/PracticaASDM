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
    
    public FacadeJuego()
    {
        scanner = new Scanner(System.in);
        scanner2 = new Scanner(System.in);
        
        personajes = new Agregado_Personajes();
        ejercitosCreados = new ArrayList<>();
        
        cargarPersonajesIniciales();
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

            System.out.println("7. Salir");
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

                    CrearPersonajes();

                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                    
                /*Patron utilizado: Prototype
                 * El usuario selecciona un personaje ya creado y el sistema genera una copia
                 * de ese objeto mediante el metodo clonar()
                 */
                case 2:
                    
                    ClonarPersonaje();
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                    
                /*Patron utilizado: Composite
                *permite crear un ejercito que puede estar formado por personajes u otros
                *ejercitos
                 */
                case 3:
                    Ejercito ejercito = CrearEjercitos();
                    ejercito.mostrarEjercito();
                    scanner2.nextLine();
                    break;

                case 4:
                    muertePersonaje();
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                case 5:
                    listarPersonajes();
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                case 6:
                    subirNivel();
                    System.out.println("Saliendo del programa...");
                    System.out.println("Presina para continuar");
                    scanner2.nextLine();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    System.out.println("Presina para continuar");
                    scanner2.nextLine();
            }

        } while (opcion != 7);
    }
    
    private void cargarPersonajesIniciales()
    {
        Creador miFabricaObjetos = null;
        
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
    }
    
    
    /*Metodo utilizado en el case 1 para crear los personajes
    *utilizando el patron Factory Method
     */
    private void CrearPersonajes() 
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
    
    
    private void ClonarPersonaje()
    {
   
        System.out.println("PERSONAJES");
        personajes.recorrer();
        System.out.println();
        
        System.out.print("Introduzca el nombre del personaje que desea clonar: ");
        String nombre = scanner2.nextLine();
  
        
        ArrayList<Personaje> listOriginal = personajes.existePersonaje(nombre);
        Personaje original;
       
        
        if(listOriginal.isEmpty())
        {
            System.out.println("El eprsonaje no existe");
            return;
        }
        
        if(listOriginal.size()>1)
        {
            System.out.println("Hay mas de un personaje con ese nombre: ");
            for(int i=0; i<listOriginal.size();i++)
            {
                System.out.println(i + " Nombre: " + listOriginal.get(i).getNombre() + " | Nivel: " + listOriginal.get(i).getNivel() + 
                        " | Tipo: " + listOriginal.get(i).getTipo() + "| Precio: " + listOriginal.get(i).getPrecio());
            }
            
            System.out.print("\nSelecciona un personaje: ");
            int opc = scanner.nextInt();
            
            original=listOriginal.get(opc);
        }
        else
            original=listOriginal.getFirst();
            
        
        System.out.print("Cuantos clones desea crear?: ");
        int n=scanner.nextInt();
        
        System.out.println("Desea modificar el clon? S/N");
        String opc = scanner2.nextLine();
        
        for(int i=0; i<n;i++)
        {
            Personaje clon = original.clonar();//se genera un nuevo personaje copiando el estado del objeto original
                                               // el clon conserva el mismo tipo y atributos iniciales que el personaje seleccionado
            
            if(opc.equalsIgnoreCase("S"))
            {
                System.out.print("Introduce el nombre: ");
                String nombreP = scanner2.nextLine();
                clon.setNombre(nombreP);

                System.out.print("Introduce el nivel: ");
                int nivel = scanner.nextInt();
                clon.setNivel(nivel);

                System.out.print("Introduce las armas: ");
                String armas = scanner2.nextLine();
                clon.setArmas(armas);

                System.out.print("Introduce el precio: ");
                double precio = scanner.nextInt();
                clon.setPrecio(precio);

                System.out.println("Introduce el nivel de habilidad: ");
                int hab = scanner.nextInt();   
                clon.sethab(hab);    
               
            }
            
            personajes.agregar(clon);//se anade el clon modificado a la lista de personajes
        }
        

        System.out.println("Se han creado " + n + " clones");  
    }
    
    
    
    /*Metodo unitilazo en el case 3, permite crear un ejercito.
    *devuelve un ejercito para que pueda anadirse como hijo dentro de otro
    */
     private Ejercito CrearEjercitos() {
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
    private void anadirPersonajesEjercito(Ejercito ejercito) {
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
    private Ejercito SeleccionarEjercitoExistente(Ejercito actual) {
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
    private boolean existeEjercito(String nombre) {
        for (Ejercito e : ejercitosCreados) {
            if (e.getNombreEjercito().equalsIgnoreCase(nombre)) {
                return true;
            }
        }

        return false;
    }


    private void subirNivel() {
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


    private void listarPersonajes() {
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


    private void mostrarPersonajes() {
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


    private void filtroTipo() {
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


    private void filtroNivelMinimo() {
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


    private void filtroRangoNivel() {
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


    private void filtroPrecio() {
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


    private void filtroArmas() {
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


    private void filtroNivelHabilidad() {
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


    private void filtroNombre() {
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


    private void mostrarOrdenado() {
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


    private void muertePersonaje() {
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
