package libreria.servicios;

import java.util.Locale;
import java.util.Scanner;
import libreria.DAO.AutorDAO;
import libreria.entidades.Autor;

public class AutorServicios {

    Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    AutorDAO autorDAO = new AutorDAO();

    public AutorServicios() {
        autorDAO = new AutorDAO();
    }

    public void crear() throws Exception{
        System.out.println("Ingresar nombre de autor");
        String nombre = read.next();
        System.out.println("Ingresar estado de alta");
        boolean estado = read.nextBoolean();

        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es obligatorio");
            }
            Autor autor=new Autor();
            autor.setNombre(nombre);
            autor.setAlta(estado);
            autorDAO.insertar(autor);
        }catch(Exception e){
            throw new Exception("ERROR al insertar");
        }

    }
}
