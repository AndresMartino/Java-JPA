package libreria.principal;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

public class Main {

    public static void main(String[] args) {
        EntityManager en =Persistence
                          .createEntityManagerFactory("LIBRERIAPU")
                          .createEntityManager();
                
        en.getTransaction().begin();
        
       Editorial ed=new Editorial();
        ed.setNombre("Alba");
        ed.setAlta(false);
        en.persist(ed);
        en.getTransaction().commit();
    }
    
}
