package libreria.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

public class AutorDAO {

    private final EntityManager em = Persistence
            .createEntityManagerFactory("LIBRERIAPU")
            .createEntityManager();

    public void insertar(Autor autor) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al insertar autor");
        }
    }

    public void actualizar(Autor autor) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al modificar autor");
        }

    }

    public void eliminar(Autor autor) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al modificar autor");
        }

    }

    public Autor buscarPorId(Integer Id) throws Exception {
        try {
            Autor autor = em.find(Autor.class, Id);
            return autor;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por ID");
        }
    }

    public List<Autor> buscarPorNombre(String nombre) throws Exception {
        try {
            List<Autor> autores=em.createQuery("SELECT f from Autor f WHERE f.nombre LIKE :nombre1",Autor.class)
                    .setParameter("nombre1", nombre)
                    .getResultList();
            return autores;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por Nombre");
        }

    }

    public List<Autor> buscarTodos() throws Exception {
        try {
            List<Autor> autores = em.createQuery("SELECT f from Autor f", Autor.class
            )
                    .getResultList();
            return autores;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por ID");
        }

    }
}
