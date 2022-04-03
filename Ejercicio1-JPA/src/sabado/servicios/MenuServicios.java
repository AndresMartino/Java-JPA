package sabado.servicios;

import java.util.Locale;
import java.util.Scanner;

public class MenuServicios {

    public void menu() throws Exception {
         Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        MenuAutorServicios menuAutorServicios = new MenuAutorServicios();
        MenuEditorialServicios menueditorialServicios = new MenuEditorialServicios();
        MenuLibroServicios menulibroServicios = new MenuLibroServicios();
       
        int opc, opc1;
        do {
            System.out.printf("%20s \n", "MENU");
            System.out.printf("%-10s\n", "1-Autor");
            System.out.printf("%-10s\n", "2-Editorial");
            System.out.printf("%-10s\n", "3-Libro");
            System.out.printf("%-10s\n", "4-Salir");
            try{
            opc = read.nextInt();
            }catch(Exception e){
                throw new Exception("Ingrese dato numerico para elegir!");
            }
            switch (opc) {
                case 1:
                   menuAutorServicios.menuAutor();
                    break;
                case 2:
                   menueditorialServicios.menuEditorial();
                    break;
                case 3:
                   menulibroServicios.menuLibro();
                   break;
                case 4:
                    System.out.println("SALIENDO!");
                default:
                    System.out.println("Opcion invalida!");
            }
        } while (opc != 4);
    }
    }

