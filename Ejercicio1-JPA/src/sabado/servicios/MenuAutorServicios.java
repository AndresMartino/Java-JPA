package sabado.servicios;

import java.util.Locale;
import java.util.Scanner;

public class MenuAutorServicios {
    AutorServicios autorServicios=new AutorServicios();
    public void menuAutor() throws Exception {
        Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        int opc1;
        do {
            try{
            System.out.printf("%-20s \n", "1-Añadir Autor");
            System.out.printf("%-20s \n", "2-Modificar estado Autor(soft-delete)");
            System.out.printf("%-20s \n", "3-Mostrar autores en Alta");
            System.out.printf("%-20s \n", "4-Mostrar autores (Alta y Baja)");
            System.out.printf("%-20s \n", "5-SALIR");
            opc1 = read.nextInt();
            }catch(Exception n){
            throw new Exception("Ingrese numeros para elegir!");
            }
            switch (opc1) {
                case 1:
                    autorServicios.crearAutor();
                    break;
                case 2:
                    autorServicios.actualizarEstado();
                    break;
                case 3:
                    autorServicios.mostrarEnAlta();
                    break;
                case 4:
                    autorServicios.mostrarTodos();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Ingrese opcion correcta");

            }

        } while (opc1 != 5);

    }
}
