package sabado.entidadesDAO;

import java.util.List;

import sabado.entidades.Libro;

public class LibroDAO extends PadreDAO<Libro> {

    public Libro buscarPorId(Integer Id) throws Exception {
        try {
            // Libro libro = em.find(Libro.class, Id);
            Libro libro = em.createQuery("SELECT f from Libro f  WHERE f.isbn =:Id", Libro.class)
                    .setParameter("Id", Id)
                    .getSingleResult();
            return libro;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por ID");
        }
    }

    public List<Libro> buscarPorTitulo(String nombre) throws Exception {
        try {
            List<Libro> libros = em.createQuery("SELECT f from Libro f  WHERE f.titulo LIKE :nombre1", Libro.class)
                    .setParameter("nombre1", nombre)
                    .getResultList();
            return libros;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por Nombre");
        }

    }

    public List<Libro> buscarPorAutor(String nombre) throws Exception {
        try {
            List<Libro> libros;
            libros = em.createQuery("SELECT f from Libro f  WHERE f.autor.nombreAutor LIKE :nombre1", Libro.class)
                    .setParameter("nombre1", nombre)
                    .getResultList();
            return libros;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por Nombre");
        }

    }

    public List<Libro> buscarPorEditorial(String nombre) throws Exception {
        try {
            List<Libro> libros;
            libros = em.createQuery("SELECT f from Libro f  WHERE f.editorial.nombreEditorial LIKE :nombre1", Libro.class)
                    .setParameter("nombre1", nombre)
                    .getResultList();
            return libros;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por Nombre");
        }

    }

    public List<Libro> buscarTodos() throws Exception {
        try {
            List<Libro> libros = em.createQuery("SELECT f from Libro f", Libro.class
            ).getResultList();

            return libros;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por ID");
        }

    }

    public List<Libro> buscarEnAlta() throws Exception {
        try {
            List<Libro> libros = em.createQuery("SELECT e from Libro e where e.alta=1", Libro.class
            ).getResultList();

            return libros;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el editorial por ID");
        }

    }

}
