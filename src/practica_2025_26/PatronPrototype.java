
package practica_2025_26;

import java.util.ArrayList;
import java.util.Scanner;


public class PatronPrototype {
    
    
    private Scanner scanner;
    private Scanner scanner2;
    private I_Agregado_Personajes personajes;
    private PatronIterator patronIterator;

    
    public PatronPrototype(Scanner scanner, Scanner scanner2, I_Agregado_Personajes personajes, PatronIterator patronIterator) {
        this.scanner = scanner;
        this.scanner2 = scanner2;
        this.personajes = personajes;
        this.patronIterator = patronIterator;
    }

    
    public void ClonarPersonaje()
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
            original=listOriginal.get(0);
            
        
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
    
}
