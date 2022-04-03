package sabado.servicios;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import sabado.entidades.Autor;
import sabado.entidades.Editorial;
import sabado.entidades.Libro;
import sabado.entidadesDAO.AutorDAO;
import sabado.entidadesDAO.EditorialDAO;
import sabado.entidadesDAO.LibroDAO;

public class LibroServicios {

    Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    AutorServicios autorServicios = new AutorServicios();
    EditorialServicios editorialServicios = new EditorialServicios();
    Autor autor = new Autor();
    Editorial editorial = new Editorial();

    LibroDAO libroDAO = new LibroDAO();
    AutorDAO autorDAO = new AutorDAO();
    EditorialDAO editorialDAO = new EditorialDAO();
    int opc;

    public void crear() throws Exception {
        System.out.println("Ingresar titulo de libro");
        String titulo = read.next();
        System.out.println("Ingresar año de libro");
        Integer anio = read.nextInt();
        System.out.println("Ingresar total de ejemplares");
        Integer ejemplares = read.nextInt();
        System.out.println("Ingresear Ejemplares prestados");
        Integer prestados = read.nextInt();
        System.out.println("Ingresear Ejemplares restantes");
        Integer restantes = read.nextInt();
        System.out.println("Ingresar estado de alta");
        boolean estado = read.nextBoolean();

        try {
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("El titulo es obligatorio");
            }

            List<Autor> autores = autorDAO.buscarTodos();
            try {
                if (autores.isEmpty()) {
                    throw new Exception("la lista de autores esta vacia");
                } else {
                    System.out.printf("%-20s%-20s%-20s \n", "ID", "Nombre", "Estado");
                    for (Autor autore : autores) {
                        System.out.printf("%-20s%-20s%-20s \n", autore.getIdAutor(), autore.getNombreAutor(), autore.getAlta());
                    }
                    System.out.println("Elija ID del autor para añadir:");

                    autor = autorDAO.buscarPorId(read.nextInt());
                }

            } catch (Exception e) {
                throw new Exception("Error al agregar autor");
            }

            Editorial editorial = null;

            List<Editorial> editoriales = editorialDAO.buscarTodos();
            try {
                if (editoriales.isEmpty()) {
                    throw new Exception("la lista de autores esta vacia");
                } else {
                    System.out.printf("%-20s%-20s%-20s \n", "ID", "Nombre", "Estado");
                    for (Editorial editoriale : editoriales) {
                        System.out.printf("%-20s%-20s%-20s \n", editoriale.getIdEdtorial(), editoriale.getNombreEditorial(), editoriale.getAlta());
                    }
                    System.out.println("Elija ID de la editorial para añadir:");

                    editorial = editorialDAO.buscarPorId(read.nextInt());
                }

            } catch (Exception e) {
                throw new Exception("Error al agregar editorial");
            }

            Libro libro = new Libro();
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(prestados);
            libro.setEjemplaresRestantes(restantes);
            libro.setAlta(estado);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libroDAO.insertar(libro);
        } catch (Exception e) {
            throw new Exception("ERROR al insertar");
        }

    }

    public void mostrar() throws Exception {
        try {
            List<Libro> libros = libroDAO.buscarTodos();
            if (libros.isEmpty()) {
                throw new Exception("No existen editoriales con ese nombre");
            } else {
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n", "ISBN", "Titulo", "anio", "ejemplares", "Autor", "editorial");
                for (Libro l : libros) {
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n", l.getIsbn(), l.getTitulo(), l.getAnio(), l.getEjemplares(), l.getAutor().getNombreAutor(), l.getEditorial().getNombreEditorial());
                    //
                }
            }
        } catch (Exception e) {
            throw new Exception("ERROR al mostrar");
        }
    }

    public void mostrarEnAlta() throws Exception {
        try {
            List<Libro> libros = libroDAO.buscarEnAlta();
            if (libros.isEmpty()) {
                throw new Exception("No existen autores con ese nombre");
            } else {
                try {
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n", "ISBN", "Titulo", "anio", "ejemplares", "Autor", "editorial");
                    for (Libro l : libros) {
                        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n", l.getIsbn(), l.getTitulo(), l.getAnio(), l.getEjemplares(), l.getAutor().getNombreAutor(), l.getEditorial().getNombreEditorial());
                        //
                    }
                } catch (Exception e) {
                    throw new Exception("No hay editoriales en alta");
                }
            }
        } catch (Exception e) {
            throw new Exception("ERROR al mostrar");
        }
    }

    public void buscarPorId() throws Exception {
        mostrarEnAlta();
        System.out.println("Ingrese ISBN de Libro a buscar ");
        int isbn;
        isbn = read.nextInt();
        Libro l = null;
        try {
            l = libroDAO.buscarPorId(isbn);

            if (l == null) {
                throw new Exception("No existe libro con ese isbn");
            } else {
                System.out.println("hola");
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n", "ISBN", "Titulo", "anio", "ejemplares", "Autor", "editorial");
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n", l.getIsbn(), l.getTitulo(), l.getAnio(), l.getEjemplares(), l.getAutor().getNombreAutor(), l.getEditorial().getNombreEditorial());

            }
        } catch (Exception e) {
            throw new Exception("ERROR al traer el libro");
        }

    }

    public void buscarPorTitulo() throws Exception {
        System.out.println("Ingrese titulo del libro a buscar ");
        String titulo = read.next();
        try {
            List<Libro> libros = libroDAO.buscarPorTitulo(titulo);
            if (libros.isEmpty()) {
                throw new Exception("No existen libros con ese titulo");
            } else {
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n", "ISBN", "Titulo", "anio", "ejemplares", "Autor", "editorial");

                for (Libro l : libros) {
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n", l.getIsbn(), l.getTitulo(), l.getAnio(), l.getEjemplares(), l.getAutor().getNombreAutor(), l.getEditorial().getNombreEditorial());

                }

            }
        } catch (Exception e) {
            throw new Exception("ERROR al traer lista por nombre");
        }

    }

    public void buscarPorAutor() throws Exception {
        System.out.println("Ingrese autor del libro a buscar ");
        String titulo = read.next();
        try {
            List<Libro> libros = libroDAO.buscarPorAutor(titulo);
            if (libros.isEmpty()) {
                throw new Exception("No existen libros con ese titulo");
            } else {
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n",
                        "ISBN", "Titulo", "anio", "ejemplares", "Autor", "editorial");

                for (Libro l : libros) {
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n", l.getIsbn(), l.getTitulo(), l.getAnio(), l.getEjemplares(), l.getAutor().getNombreAutor(), l.getEditorial().getNombreEditorial());

                }

            }
        } catch (Exception e) {
            throw new Exception("ERROR al traer lista por nombre de autor");
        }
    }

    public void buscarPorEditorial() throws Exception {
        System.out.println("Ingrese editorial del libro a buscar ");
        String nombre = read.next();
        try {
            List<Libro> libros = libroDAO.buscarPorEditorial(nombre);
            if (libros.isEmpty()) {
                throw new Exception("No existen libros de esa editorial");
            } else {
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n",
                        "ISBN", "Titulo", "anio", "ejemplares", "Autor", "editorial");

                for (Libro l : libros) {
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n", l.getIsbn(), l.getTitulo(), l.getAnio(), l.getEjemplares(), l.getAutor().getNombreAutor(), l.getEditorial().getNombreEditorial());

                }

            }
        } catch (Exception e) {
            throw new Exception("ERROR al traer lista por nombre de autor");
        }
    }

    public void actualizarLibro() throws Exception {
        mostrar();
        int opc;
        System.out.println("Ingrese id de libro a actualizar");
        int isbn = read.nextInt();
        try {
            Libro libro = libroDAO.buscarPorId(isbn);
            if (libro == null) {
                throw new Exception("No existe libro con ese isbn");
            } else {

                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n", "ISBN", "Titulo", "anio", "ejemplares", "Autor", "editorial");
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s \n", libro.getIsbn(), libro.getTitulo(), libro.getAnio(), libro.getEjemplares(), libro.getAutor().getNombreAutor(), libro.getEditorial().getNombreEditorial());
                do {
                    System.out.printf("%25s", "Submenu modificar libro\n");
                    System.out.printf("%-15s", "1-Modificar Titulo\n");
                    System.out.printf("%-15s", "2-Modificar Año\n");
                    System.out.printf("%-15s", "3-Modificar Cantidad de ejemplares\n");
                    System.out.printf("%-15s", "4-Modificar Cantidad de ejemplares Restantes\n");
                    System.out.printf("%-15s", "5-Modificar Cantidad de ejemplares Prestados\n");
                    System.out.printf("%-15s", "6-Salir\n");

                    opc = read.nextInt();
                    switch (opc) {
                        case 1:
                            System.out.println("Ingrese nuevo nombre");
                            libro.setTitulo(read.next());
                            break;
                        case 2:
                            System.out.println("Ingrese nuevo Año");
                            libro.setAnio(read.nextInt());
                            break;
                        case 3:
                            System.out.println("Ingrese cantidad de ejempalres");
                            libro.setEjemplares(read.nextInt());
                            break;
                        case 4:
                            System.out.println("Ingrese cantidad de ejempalres Restantes");
                            libro.setEjemplaresRestantes(read.nextInt());
                            break;
                        case 5:
                            System.out.println("Ingrese cantidad de ejempalres Prestados");
                            libro.setEjemplaresPrestados(read.nextInt());
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Opcion incorrecta");
                    }

                } while (opc != 6);
                libroDAO.actualizar(libro);
            }
        } catch (Exception e) {
            throw new Exception("ERROR al traer el libro");
        }

    }

}
