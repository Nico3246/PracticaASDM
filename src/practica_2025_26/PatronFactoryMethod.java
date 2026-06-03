
package practica_2025_26;

import java.util.ArrayList;
import java.util.Scanner;


public class PatronFactoryMethod {
    
    private Scanner scanner;
    private Scanner scanner2;
    private I_Agregado_Personajes personajes;

    
    public PatronFactoryMethod(Scanner scanner, Scanner scanner2, I_Agregado_Personajes personajes) {
        this.scanner = scanner;
        this.scanner2 = scanner2;
        this.personajes = personajes;
    }
    
    
    
    
    
    
    public void cargarPersonajesIniciales()
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
    public void CrearPersonajes() 
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


