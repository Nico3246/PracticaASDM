package practica_2025_26;

import java.util.*;

@SuppressWarnings("empty-statement")
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
        ArrayList<Ejercito> ejercitosCreados = new ArrayList<>();//aqui se almacenan los ejercitos que se vatan creando


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


        do {
            for (int i = 0; i < 50; ++i) {
                System.out.println();
            }

            System.out.println("\nMenú Principal:");
            System.out.println("1. Crear personaje(Factory Method)");
            System.out.println("2. Clonar personaje(Prototype)");
            System.out.println("3. Crear ejercito (Composite)");
            System.out.println("4. Subir nivel (Iterator)");
            System.out.println("5. Listar personaje (Iterator)");

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

                    
                /*Patron utilizado: Prototype
                 * El usuario selecciona un personaje ya creado y el sistema genera una copia
                 * de ese objeto mediante el metodo clonar()
                 */
                case 2:
                    
                    ClonarPersonaje(scanner, scanner2, personajes);
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                    
                /*Patron utilizado: Composite
                *permite crear un ejercito que puede estar formado por personajes u otros
                *ejercitos
                 */
                case 3:
                    Ejercito ejercito = CrearEjercitos(scanner, scanner2, personajes, ejercitosCreados);
                    ejercito.mostrarEjercito();
                    scanner2.nextLine();
                    break;

                case 4:
                    subirNivel(scanner, scanner2, personajes);
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                case 5:
                    listarPersonajes( scanner,  scanner2,  personajes);
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
    
    
    public static void ClonarPersonaje(Scanner scanner, Scanner scanner2, I_Agregado_Personajes personajes)
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
            
            personajes.agregar(clon);//se añade el clon modificado a la lista de personajes
        }
        

        System.out.println("Se han creado " + n + " clones");  
    }
    
    
    
    /*Metodo unitilazo en el case 3, permite crear un ejercito.
    *devuelve un ejercito para que pueda añadirse como hijo dentro de otro
    */
     public static Ejercito CrearEjercitos(Scanner scanner, Scanner scanner2, I_Agregado_Personajes personajes, ArrayList<Ejercito> ejercitosCreados)
     {
        System.out.print("Introduce el nombre del ejercito:");
        String nombreEjercito = scanner2.nextLine();
        
   
        while(existeEjercito(ejercitosCreados, nombreEjercito))
        {
            System.out.println("Ya existe un ejercito con ese nombre");
            System.out.print("Introduce el nombre del ejercito:");
            nombreEjercito = scanner2.nextLine();
        }
        
        Ejercito nuevo = new Ejercito(nombreEjercito);
        ejercitosCreados.add(nuevo);
        int opc=0;
        
        do
        {
            System.out.println("1. Anadir un ejercito al ejercito");
            System.out.println("2. Anadir miembros al ejercito");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opcion: ");
            opc=scanner.nextInt();
            
            switch (opc) {
                case 1:
                    System.out.println("1- Crear un nuevo ejercito");
                    System.out.println("2- Anadir un ejercito existente");
                    System.out.println("3- Vovler");
                    int opc2 = scanner.nextInt();
                    switch (opc2) {
                        case 1:
                            Ejercito hijo = CrearEjercitos(scanner,scanner2,personajes, ejercitosCreados);
                            nuevo.agregaPersonaje(hijo);
                            System.out.println("Ejercito añadido");
                            break;
                            
                        case 2:
                            Ejercito hijo2 = SeleccionarEjercitoExistente(scanner, ejercitosCreados, nuevo);
                            
                            if(hijo2 != null)
                            {
                                nuevo.agregaPersonaje(hijo2);
                                System.out.println("Ejercito añadido3");
                            }

                            break;
                            
                        case 3:
                            System.out.println("Volivendo...");
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                   
                    
                    break;
                case 2:
                    anadirPersonajesEjercito(scanner, scanner2, personajes, nuevo);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
                    
            }    
            
        }while(opc!=3);
        
        return nuevo;
    }
     
     
     /*
     metodo utilizado en el case 3 para añadir personajes a un ejercito
     */
    public static void anadirPersonajesEjercito(Scanner scanner, Scanner scanner2, I_Agregado_Personajes personajes, Ejercito ejercito)
    {
        Creador miFabricaObjetos;
        Personaje p;
        
        System.out.println("Selecciona un personaje: ");
        System.out.println("1.Arquero ");
        System.out.println("2.Guerrero");
        System.out.println("3.Mago");
        int personaje = scanner.nextInt();
        
        System.out.print("Cuantos personajes desea crear?: ");
        int n=scanner.nextInt();

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

                for(int i=0;i<n;i++)
                {
                    Personaje clon = p.clonar();
                    personajes.agregar(clon);
                    ejercito.agregaPersonaje(new MiembroEjercito(clon));
                }
                break;
                
            case 2:
                int fuerza;
                System.out.print("Introduce la fuerza: ");
                fuerza = scanner.nextInt();

                miFabricaObjetos = new CreadorGuerrero(nombre, fuerza, nivel, armas, precio);
                p = miFabricaObjetos.factory_Method();

                for(int i=0;i<n;i++)
                {
                    Personaje clon = p.clonar();
                    personajes.agregar(clon);
                    ejercito.agregaPersonaje(new MiembroEjercito(clon));
                }

                break;

            case 3:
                int nMagia;

                System.out.print("Introduce el nivel de magia: ");
                nMagia = scanner.nextInt();

                miFabricaObjetos = new CreadorMago(nombre, nMagia, nivel, armas, precio);
                p = miFabricaObjetos.factory_Method();

                for(int i=0;i<n;i++)
                {
                    Personaje clon = p.clonar();
                    personajes.agregar(clon);
                    ejercito.agregaPersonaje(new MiembroEjercito(clon));
                }

                break;

        }
    }
    
    
    //se utiliza para realizar el case 3 muestra los ejercitos que ya se hanc reado previamente y permite añadirlos al ejercitos que se este creando
    public static Ejercito SeleccionarEjercitoExistente(Scanner scanner, ArrayList<Ejercito> ejercitosCreados, Ejercito actual)
    {
        ArrayList<Ejercito>disponibles = new ArrayList<>();
        
        for(Ejercito e: ejercitosCreados)
        {
            if(e != actual && !e.contieneEjercito(actual))//controlo que no se añada a si mismo
            {
                disponibles.add(e);
            }
        }
        
        if(disponibles.isEmpty())
        {
            System.out.println("No hay ejercitos disponibles para añadir");
            return null;
        }
        
        System.out.println("Ejercitos disponibles: ");
        
        for(int i=0; i<disponibles.size();i++)
        {
            System.out.println(i + "- " + disponibles.get(i).getNombreEjercito());
        }
        
        System.out.println("Selecciona una opcion: ");
        int opc = scanner.nextInt();
        
        return disponibles.get(opc);
    }  


    //se utiliza pra comprobar si ya existe un ejercitos creado previamente con el mismo nombre que el que se esta creando
    public static boolean existeEjercito(ArrayList<Ejercito> ejercitosCreados, String nombre)
    {
        for(Ejercito e : ejercitosCreados)
        {
            if(e.getNombreEjercito().equalsIgnoreCase(nombre))
            {
                return true;
            }    
        }

        return false;
    }
    
    
    
    public static void subirNivel(Scanner scanner, Scanner scanner2, I_Agregado_Personajes personajes)
    {
        IteratorPersonajes iteradorMostrar = personajes.crearIterador2();
        
        System.out.println("Personajes existentes");
        System.out.println("-----------------------------------");
        
        while(iteradorMostrar.tieneSiguiente())
        {
            Personaje p= iteradorMostrar.siguiente();
            p.mostrar();
        }
        
        System.out.println("Introduce el nombre del personaje: ");
        String nombre=scanner2.nextLine();
        
        ArrayList<Personaje> encontrados=new ArrayList<>();
        
        IteratorPersonajes iteradorBuscar = personajes.crearIterador();
        
        while(iteradorBuscar.tieneSiguiente())
        {
            Personaje p= iteradorBuscar.siguiente();
            if(p.getNombre().equalsIgnoreCase(nombre))
                encontrados.add(p);
        }
        
        Personaje elegido=null;
        
        if(encontrados.isEmpty())
        {
            System.out.println("No existe ningun personaje con ese nombre");
            return;
        }
        
        if(encontrados.size()>1)
        {
            System.out.println("Hat varios personajes con ese nombre");
            for(int i=0; i< encontrados.size(); i++)
            {
                Personaje p = encontrados.get(i);
                
                System.out.println(i + "- " + p.getNombre() + " | Nivel " + p.getNivel() + " | Tipo " + p.getTipo() + " | Armas: " + p.getArmas() + " | Precio: " + p.getPrecio());
                
                
            }
            
            System.out.print("Elige una opcion: ");
            int opc=scanner.nextInt();

            elegido=encontrados.get(opc);
        }
        else
            elegido=encontrados.get(0);
        
        if(elegido==null)
        {
            System.out.println("ERROR");
            return;
        }
        
        elegido.subirNivel();
        
        
        IteratorPersonajes iteradorMostrar2 = personajes.crearIterador();
        
        System.out.println("Personajes actualizados");
        System.out.println("-----------------------------------");
        
        while(iteradorMostrar2.tieneSiguiente())
        {
            Personaje p= iteradorMostrar2.siguiente();
            p.mostrar();
        }
        
    }

    
    public static void listarPersonajes(Scanner scanner, Scanner scanner2, I_Agregado_Personajes personajes)
    {
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
        System.out.println("10. salir");
        
        int opc = scanner.nextInt();
        
        switch (opc) {
            case 1:
                mostrarPersonajes(personajes);
                break;
            case 2:
                filtroTipo( scanner2,  personajes);
                break;
            case 3:
                filtroNivelMinimo( scanner,  personajes);
                break;
            case 4: 
                filtroRangoNivel( scanner,  personajes);
                break;
            case 5: 
                filtroPrecio( scanner,  personajes);
                break;
            case 6:
                filtroArmas( scanner2,  personajes);
                break;
            case 7:
                filtroNivelHabilidad( scanner,  personajes);
                break;
            case 8:
                filtroNombre( scanner2,  personajes);
                break;
            case 9:
                mostrarOrdenado( scanner,  personajes);
                break;
            case 10:
                System.out.println("Volivendo...");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }

    }
    
    
    public static void mostrarPersonajes(I_Agregado_Personajes personajes)
    {
        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado=false;
        System.out.println("Personajes existentes");
        System.out.println("-----------------------------------");

        while(iterador.tieneSiguiente())
        {
            Personaje p= iterador.siguiente();
            p.mostrar();
            encontrado=true;
        }
        
        if(!encontrado)
            System.out.println("No hay personajes");
    }
    
    public static void filtroTipo(Scanner scanner2, I_Agregado_Personajes personajes)
    {
        System.out.print("Introduce el tipo de personaje (Arquero, mago, geuerrero: ");
        String tipo=scanner2.nextLine();
        
        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado=false;
        
        while(iterador.tieneSiguiente())
        {
            Personaje p= iterador.siguiente();
            
            if(p.getTipo().equalsIgnoreCase(tipo))
            {
                p.mostrar();
            encontrado=true;
            }
        }
        
        if(!encontrado)
            System.out.println("No hay personajes");
    }
    
    
    public static void filtroNivelMinimo(Scanner scanner, I_Agregado_Personajes personajes)
    {
        System.out.print("Introduce el nivel minimo: ");
        int nivel=scanner.nextInt();
        
        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado=false;
        
        while(iterador.tieneSiguiente())
        {
            Personaje p= iterador.siguiente();
            
            if(p.getNivel() >= nivel)
            {
                p.mostrar();
                encontrado=true;
            }
        }
        
        if(!encontrado)
            System.out.println("No hay personajes");
    }
    
    public static void filtroRangoNivel(Scanner scanner, I_Agregado_Personajes personajes)
    {
        System.out.print("Introduce el nivel minimo: ");
        int nivel=scanner.nextInt();
        
        System.out.print("Introduce el nivel maximo: ");
        int nivel2=scanner.nextInt();
        
        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado=false;
        
        while(iterador.tieneSiguiente())
        {
            Personaje p= iterador.siguiente();
            
            if(p.getNivel() >= nivel && p.getNivel()<= nivel2)
            {
                p.mostrar();
                encontrado=true;
            }
        }
        
        if(!encontrado)
            System.out.println("No hay personajes");
        
    }
    
    
    public static void filtroPrecio(Scanner scanner, I_Agregado_Personajes personajes)
    {
        System.out.print("Introduce el precio maximo: ");
        int precio=scanner.nextInt();
       
        
        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado=false;
        
        while(iterador.tieneSiguiente())
        {
            Personaje p= iterador.siguiente();
            
            if(p.getPrecio() <= precio)
            {
                p.mostrar();
                encontrado=true;
            }
        }
        
        if(!encontrado)
            System.out.println("No hay personajes");
        
    }
    
    
    public static void filtroArmas(Scanner scanner2, I_Agregado_Personajes personajes)
    {
        System.out.print("Introduce el arma: ");
        String arma=scanner2.nextLine();
       
        
        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado=false;
        
        while(iterador.tieneSiguiente())
        {
            Personaje p= iterador.siguiente();
            
            if(arma != null && p.getArmas().contains(arma))
            {
                p.mostrar();
                encontrado=true;
            }
        }
        
        if(!encontrado)
            System.out.println("No hay personajes");
        
    }
    
    public static void filtroNivelHabilidad(Scanner scanner, I_Agregado_Personajes personajes)
    {
        System.out.print("Introduce el nivel minimo de habilidad: ");
        int nivelH=scanner.nextInt();
       
        
        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado=false;
        
        while(iterador.tieneSiguiente())
        {
            Personaje p= iterador.siguiente();
            
            if(p.gethab()<= nivelH)
            {
                p.mostrar();
                encontrado=true;
            }
        }
        
        if(!encontrado)
            System.out.println("No hay personajes");
        
    }
    
    
    public static void filtroNombre(Scanner scanner2, I_Agregado_Personajes personajes)
    {
        System.out.print("Introduce el nombre: ");
        String nombre=scanner2.nextLine();
       
        
        IteratorPersonajes iterador = personajes.crearIterador();
        boolean encontrado=false;
        
        while(iterador.tieneSiguiente())
        {
            Personaje p= iterador.siguiente();
            
            if(p.getNombre().equalsIgnoreCase(nombre))
            {
                p.mostrar();
                encontrado=true;
            }
        }
        
        if(!encontrado)
            System.out.println("No hay personajes");
    }
    
    
    public static void mostrarOrdenado(Scanner scanner, I_Agregado_Personajes personajes)
    {
        System.out.println("Ordenar por: ");
        System.out.println("1. Nivel");
        System.out.println("2. Precio");
        System.out.println("Seleccion una opcion: ");
        int opc1=scanner.nextInt();
        
        System.out.println("Orden: ");
        System.out.println("1. Ascendente");
        System.out.println("2. Descendente");
        System.out.println("Selecciona una opcion: ");
        int opc2=scanner.nextInt();
        
        IteratorPersonajes iterador;
        
        if(opc2 == 1)
            iterador = personajes.crearIterador3(opc1);
        else
            iterador = personajes.crearIterador4(opc1);
        
        boolean encontrado=false;
        
        while(iterador.tieneSiguiente())
        {
            Personaje p = iterador.siguiente();
            p.mostrar();
            encontrado=true;
        }
        
        if(!encontrado)
            System.out.println("No hay personajes");
    }
    
    
    
    
            
    
    
    
    
    
    
    
    
    
    
    
    
}




