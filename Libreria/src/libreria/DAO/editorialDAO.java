package libreria.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import libreria.entidades.Editorial;

public class EditorialDAO {
     private final EntityManager em = Persistence
            .createEntityManagerFactory("LIBRERIAPU")
            .createEntityManager();

    public void insertar(Editorial editorial) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al insertar autor");
        }
    }

    public void actualizar(Editorial editorial) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al modificar autor");
        }

    }

    public void eliminar(Editorial editorial) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al modificar autor");
        }

    }

    public Editorial buscarPorId(Integer Id) throws Exception {
        try {
            Editorial editorial = em.find(Editorial.class, Id);
            return editorial;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por ID");
        }
    }

    public List<Editorial> buscarPorNombre(String nombre) throws Exception {
        try {
            List<Editorial> editoriales=em.createQuery("SELECT f from Editorial f WHERE f.nombre LIKE :nombre1",Editorial.class)
                    .setParameter("nombre1", nombre)
                    .getResultList();
            return editoriales;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por Nombre");
        }

    }

    public List<Editorial> buscarTodos() throws Exception {
        try {
            List<Editorial> editoriales = em.createQuery("SELECT f from Autor f", Editorial.class
            )
                    .getResultList();
            return editoriales;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por ID");
        }

    }
}
