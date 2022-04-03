package sabado.entidadesDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PadreDAO<T> {

    protected final EntityManager em = Persistence
            .createEntityManagerFactory("SabadoPU")
            .createEntityManager();

    public void insertar(T t) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al insertar autor");
        }
    }

    public void actualizar(T t) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al modificar autor");
        }

    }

    public void eliminar(T t) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al modificar autor");
        }

    }

}
