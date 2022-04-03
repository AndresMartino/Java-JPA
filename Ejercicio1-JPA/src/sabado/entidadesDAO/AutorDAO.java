package sabado.entidadesDAO;

import java.util.List;
import sabado.entidades.Autor;

public class AutorDAO extends PadreDAO<Autor>{

   
    
     public List<Autor> buscarTodos() throws Exception {
        try {
            List<Autor> autores = em.createQuery("SELECT a from Autor a", Autor.class
            ).getResultList();

            return autores;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por ID");
        }

    }
      public List<Autor> buscarEnAlta() throws Exception {
        try {
            List<Autor> autores = em.createQuery("SELECT a from Autor a where a.alta=1", Autor.class
            ).getResultList();

            return autores;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el autor por ID");
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
   
}
