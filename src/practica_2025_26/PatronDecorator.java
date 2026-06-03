
package practica_2025_26;

import java.util.ArrayList;
import java.util.Scanner;

public class PatronDecorator {
    
    private Scanner scanner;
    private Scanner scanner2;
    private I_Agregado_Personajes personajes;
    private PatronIterator patronIterator;

    public PatronDecorator(Scanner scanner, Scanner scanner2, I_Agregado_Personajes personajes, PatronIterator patronIterator) {
        this.scanner = scanner;
        this.scanner2 = scanner2;
        this.personajes = personajes;
        this.patronIterator = patronIterator;
    }
    
    
    
    //metodo que utiliza el patron decorator para añadir armas a los personajes
    public void anadirArmas()
    {
        System.out.println("PERSONAJES");
        personajes.recorrer();
        System.out.println();
        
        System.out.print("Introduzca el nombre del personaje: ");
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
            original=listOriginal.get(0);
        
        int opc=0;
        
        Personaje copia = original;
        
        do
        {
            System.out.println("Selecciona un arma");
            System.out.println("1. Escudo");
            System.out.println("2. baculo");
            System.out.println("3. Arco");
            System.out.println("4. Finalizar");
            opc=scanner.nextInt();
            
            switch (opc) {
                case 1:
                    original = new Escudo(original); 
                    break;
                case 2:
                    original = new Baculo(original);
                    break;
                case 3:
                    original = new Arco(original);
                    break;
            }
            
        }while(opc!=4);
        
        personajes.eliminar(copia);
        personajes.agregar(original);
        
        System.out.println("Armas: " + original.getArmas());
    }
    
}
