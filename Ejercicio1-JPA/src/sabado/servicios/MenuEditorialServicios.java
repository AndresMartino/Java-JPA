/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sabado.servicios;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author andrelo
 */
public class MenuEditorialServicios {
EditorialServicios editorialServicios=new EditorialServicios();
    Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    public void menuEditorial() throws Exception {
        int opc1;
        do {
            System.out.printf("%-20s \n", "1-Añadir Editorial");
            System.out.printf("%-20s \n", "2-Modificar estado Editorial(soft-delete)");
            System.out.printf("%-20s \n", "3-Mostrar Editoriales en Alta");
            System.out.printf("%-20s \n", "4-Mostrar Editoriales (Alta y Baja)");
            System.out.printf("%-20s \n", "5-SALIR");
            opc1 = read.nextInt();
            switch (opc1) {
                case 1:
                    editorialServicios.crearEditorial();
                    break;
                case 2:
                    editorialServicios.actualizarEstado();
                    break;
                case 3:
                    editorialServicios.mostrarEnAlta();
                    break;
                case 4:
                    editorialServicios.mostrarTodos();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Ingrese opcion correcta");

            }

        } while (opc1 != 5);

    }
}
