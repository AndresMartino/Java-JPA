package libreria.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Libro;

public class LibroDAO {
     private final EntityManager em = Persistence
            .createEntityManagerFactory("LIBRERIAPU")
            .createEntityManager();

    public void insertar(Libro libro) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al insertar autor");
        }
    }

    public void actualizar(Libro libro) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al modificar autor");
        }

    }

    public void eliminar(Libro libro) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al modificar autor");
        }

    }

    public Libro buscarPorId(Integer Id) throws Exception {
        try {
            Libro libro = em.find(Libro.class, Id);
            return libro;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por ID");
        }
    }

    public List<Libro> buscarPorNombre(String nombre) throws Exception {
        try {
            List<Libro> libros=em.createQuery("SELECT f from Libro f WHERE f.titulo LIKE :nombre1",Libro.class)
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
            List<Libro> libros = em.createQuery("SELECT f from Autor f", Libro.class
            )
                    .getResultList();
            return libros;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por ID");
        }

    }
}
