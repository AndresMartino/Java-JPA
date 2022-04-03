package sabado.servicios;

import java.util.Locale;
import java.util.Scanner;

public class MenuLibroServicios {

    LibroServicios libroServicios = new LibroServicios();
    Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    public void menuLibro() throws Exception {
        int opc1;
        do {
            try{
            System.out.printf("%-20s \n", "1-Añadir Libro");
            System.out.printf("%-20s \n", "2-Modificar Libro");
            System.out.printf("%-20s \n", "3-Mostrar Libros en Alta");
            System.out.printf("%-20s \n", "4-Mostrar libros (Alta y Baja)");
            System.out.printf("%-20s \n", "5-Buscar por ISBN");
            System.out.printf("%-20s \n", "6-Buscar por titulo");
            System.out.printf("%-20s \n", "7-Buscar Por nombre de autor");
            System.out.printf("%-20s \n", "8-Buscar Por nombre de editorial");
            System.out.printf("%-20s \n", "9-SALIR");
            opc1 = read.nextInt();
            }catch(Exception e){
                throw new Exception("Ingrese numeros para elegir!");
            }
            switch (opc1) {
                case 1:
                    libroServicios.crear();
                    break;
                case 2:
                    libroServicios.actualizarLibro();
                    break;
                case 3:
                    libroServicios.mostrarEnAlta();
                    break;
                case 4:
                    libroServicios.mostrar();
                    break;
                case 5:
                    libroServicios.buscarPorId();
                    break;
                case 6:
                    libroServicios.buscarPorTitulo();
                    break;
                case 7:
                    libroServicios.buscarPorAutor();
                    break;
                case 8:
                    libroServicios.buscarPorEditorial();
                    break;
                default:
                    System.out.println("Ingrese opcion correcta");

            }

        } while (opc1 != 9);
       
    

    }
}
