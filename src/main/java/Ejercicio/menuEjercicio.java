
package Ejercicio;

import java.util.Scanner;
        
public class menuEjercicio {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter("/n");
        int opcion;
        do{
        System.out.println("---Bienvenido al Menu de opciones---");
        System.out.println("Ingrese el numero de la accion que desea realizar: ");
        System.out.println("1. Ver Datos ya existentes"); 
        System.out.println("2. Ingresar nuevos datos");
        System.out.println("3. Modificar datos ya existentes");
        System.out.println("4. Eliminar datos");
        System.out.println("5. Salir (Finalizar)");
        
        opcion = scanner.nextInt();
        
        switch(opcion){
            case 1:
                System.out.println("-----VER DATOS EXISTENTES-----");
                ejercicioDAO ver = new ejercicioDAO();
                ver.listar();
                break;
                
            case 2:
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("-----INGRESO DE DATOS-----");
                ejercicioDAO nuevo = new ejercicioDAO();
                System.out.println("Ingrese los datos deseados: ");
                System.out.println("Codigo a ingresar: ");
                int codigo = scanner2.nextInt();
                scanner2.nextLine();
                System.out.println("Nombre  del producto: ");
                String nombre = scanner.next();
                //scanner.nextLine();
                System.out.println("Cantidad existente del producto: ");
                int cantidad = scanner2.nextInt();
                scanner2.nextLine();
                System.out.println("Donde se fabrico el producto?: ");
                String fabricacion = scanner.next();
                //scanner.nextLine();
                System.out.println("Fecha de Ingreso del producto: ");
                System.out.println("(Fecha en formato AÑO-MES-DIA. Ejemplo: 2020-09-12)");
                String fecha = scanner.next();
                //scanner.nextLine();
                nuevo.ingresoDatos(codigo, nombre, cantidad, fabricacion, fecha);
                break;
               
            case 3: 
                System.out.println("-----MODIFICAR PRODUCTOS-----");
                ejercicioDAO modifi =new ejercicioDAO();
                System.out.println("Ingrese el codigo del producto que quiere modificar: ");
                codigo = scanner.nextInt();
                System.out.println("Nuevo Nombre: ");
                nombre = scanner.next();
                System.out.println("Nueva cantidad del producto:  ");
                cantidad = scanner.nextInt();
                System.out.println("Nuevo lugar de fabricacion");
                fabricacion = scanner.next();
                System.out.println("Nueva fecha de ingreso");
                fecha = scanner.next();
                modifi.modificar(codigo, nombre, cantidad, fabricacion, fecha);
                break;
            case 4:
                System.out.println("-----ELIMINAR PRODUCTO-----");
                ejercicioDAO eli = new ejercicioDAO();
                System.out.println("Ingrese el codigo del producto que desea eliminar");
                codigo =scanner.nextInt();
                eli.eliminar(codigo);
                break;
                
        }
        
        }while(opcion<5);
        System.out.println("Gracias por usar este programa");
    }
   
}
