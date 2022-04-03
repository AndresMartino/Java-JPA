package sabado.servicios;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import sabado.entidades.Autor;
import sabado.entidadesDAO.AutorDAO;

public class AutorServicios {

    Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    AutorDAO autorDAO = new AutorDAO();

    public AutorServicios() {
        autorDAO = new AutorDAO();
    }

    public void crearAutor() throws Exception {

        Autor autor = new Autor();
        System.out.println("Ingrese nombre de autor");
        String nombre = read.next();

        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es obligatorio");
            }

            autor.setNombreAutor(nombre);
            autor.setAlta(true);
            autorDAO.insertar(autor);

        } catch (Exception e) {
            throw new Exception("ERROR al insertar");
        }
    }

    public void mostrarEnAlta() throws Exception {
        try {
            List<Autor> autores = autorDAO.buscarEnAlta();
            if (autores.isEmpty()) {
                throw new Exception("No existen autores con ese nombre");
            } else {
                System.out.printf("%-20s%-20s%-20s \n", "ID", "Nombre", "Estado");
                for (Autor autore : autores) {
                    System.out.printf("%-20s%-20s%-20s \n", autore.getIdAutor(), autore.getNombreAutor(), autore.getAlta());
                }
            }
        } catch (Exception e) {
            throw new Exception("ERROR al mostrar");
        }
    }

    public void mostrarTodos() throws Exception {
        try {
            List<Autor> autores = autorDAO.buscarTodos();
            if (autores.isEmpty()) {
                throw new Exception("No existen autores con ese nombre");
            } else {
                System.out.printf("%-20s%-20s%-20s \n", "ID", "Nombre", "Estado");
                for (Autor autore : autores) {
                    System.out.printf("%-20s%-20s%-20s \n", autore.getIdAutor(), autore.getNombreAutor(), autore.getAlta());
                }
            }
        } catch (Exception e) {
            throw new Exception("ERROR al mostrar");
        }
    }

    public void actualizarEstado() throws Exception {
        mostrarTodos();
        System.out.printf("%10s\n", "Ingrese id de autor a actualizar");
        int opc = read.nextInt();
        Autor autor = new Autor();
        int opc2;

        try {
            List<Autor> autores = autorDAO.buscarTodos();
            autor = (autorDAO.buscarPorId(opc));
            if (autores.isEmpty() | autor == null) {
                throw new Exception("No existen autores");
            } else {

                do {
                    System.out.println("elija estado de alta");
                    System.out.println("1-Alta");
                    System.out.println("2-Baja");
                    opc2 = read.nextInt();
                    switch (opc2) {
                        case 1:
                            autor.setAlta(true);
                            break;
                        case 2:
                            autor.setAlta(false);
                            break;
                        default:
                            System.out.println("ERROR opcion incorrecta");
                    }
                } while (opc2 != 1 && opc2 != 2);
                autorDAO.actualizar(autor);
            }

        } catch (Exception e) {
            throw new Exception("ERROR al actualizar");

        }
    }
}
