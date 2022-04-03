/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sabado.servicios;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import sabado.entidades.Editorial;
import sabado.entidadesDAO.EditorialDAO;

/**
 *
 * @author andrelo
 */
public class EditorialServicios {

    Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    EditorialDAO editorialDAO = new EditorialDAO();

    public EditorialServicios() {
        editorialDAO = new EditorialDAO();
    }

    public void crearEditorial() throws Exception {

        Editorial editorial = new Editorial();
        System.out.println("Ingrese nombre de autor");
        String nombre = read.next();
        System.out.println("Ingrese estado");
        Boolean alta = read.nextBoolean();
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es obligatorio");
            }

            editorial.setNombreEditorial(nombre);
            editorial.setAlta(alta);
            editorialDAO.insertar(editorial);

        } catch (Exception e) {
            throw new Exception("ERROR al insertar");
        }
    }

    public void mostrarEnAlta() throws Exception {
        try {
            List<Editorial> editoriales = editorialDAO.buscarEnAlta();
            if (editoriales.isEmpty()) {
                throw new Exception("No existen autores con ese nombre");
            } else {
                try {
                    System.out.printf("%-20s%-20s%-20s \n", "ID", "Nombre", "Estado");
                    for (Editorial editor : editoriales) {
                        System.out.printf("%-20s%-20s%-20s \n", editor.getIdEdtorial(), editor.getNombreEditorial(), editor.getAlta());
                    }
                } catch (Exception e) {
                    throw new Exception("No hay editoriales en alta");
                }
            }
        } catch (Exception e) {
            throw new Exception("ERROR al mostrar");
        }
    }

    public void mostrarTodos() throws Exception {
        try {
            List<Editorial> editoriales = editorialDAO.buscarTodos();
            if (editoriales.isEmpty()) {
                throw new Exception("No existen autores con ese nombre");
            } else {
                System.out.printf("%-20s%-20s%-20s \n", "ID", "Nombre", "Estado");
                for (Editorial autore : editoriales) {
                    System.out.printf("%-20s%-20s%-20s \n", autore.getIdEdtorial(), autore.getNombreEditorial(), autore.getAlta());
                }
            }
        } catch (Exception e) {
            throw new Exception("ERROR al mostrar");
        }
    }

    public void actualizarEstado() throws Exception {
        mostrarTodos();
        System.out.printf("%10s\n", "Ingrese id de editorial a actualizar");
        int opc = read.nextInt();
        Editorial editorial = new Editorial();
        int opc2;

        try {
            List<Editorial> editoriales = editorialDAO.buscarTodos();
            editorial = (editorialDAO.buscarPorId(opc));
            if (editoriales.isEmpty() | editorial == null) {
                throw new Exception("No existen editoriales");
            } else {

                do {
                    System.out.println("elija estado de alta");
                    System.out.println("1-Alta");
                    System.out.println("2-Baja");
                    opc2 = read.nextInt();
                    switch (opc2) {
                        case 1:
                            editorial.setAlta(true);
                            break;
                        case 2:
                            editorial.setAlta(false);
                            break;
                        default:
                            System.out.println("ERROR opcion incorrecta");
                    }
                } while (opc2 != 1 && opc2 != 2);
                editorialDAO.actualizar(editorial);
            }

        } catch (Exception e) {
            throw new Exception("ERROR al actualizar");

        }
    }
}
